package httpServer;//image stuff

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class ResponseHandler extends Thread {

    private Socket socket;
    private OutputStream outputStream;
    private SystemInformation info = SystemInformation.getInformation(); //to get the correct slash we need to know the OS
    private boolean loginHeader = false;
    private String username = "";
    private String password = "";

    public ResponseHandler(Socket socket) {
        this.socket = socket;
    } //set the socket

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outputStream = socket.getOutputStream();
            String request = reader.readLine();

            if (request != null) { //request exists!
                this.checkForAuthentication(reader);

                String[] split = request.split(" "); //split the first line of the request on spaces, we only need the last part
                String uri = split[1].replace('/', info.getSlash()); //replace the slashes when needed and get the uri

                if (uri.equals("/moved")) { //if the page is moved, move the user!
                    this.respondMoved("http://ww.google.com/");
                } else {
                    if (uri.equals("/")) { //user didn't specify a file or folder, use index.html
                        uri = info.getSlash() + "index.html";
                    } else if (!uri.contains(".")) { //user goes to a folder without specifying a file.. just try index.html
                        uri += info.getSlash() + "index.html";
                    }

                    if (info.getPathMap().containsKey(uri)) { //the file exists!
                        String doc = "htdocs" + uri; //get the path to the file/document the user is trying to access

                        //make a nice path to the folder the file is in
                        String folder = this.getFolderPath(doc);

                        if (info.getPathMap().containsKey(folder + info.getSlash() + ".htaccess")) { //check for htaccess
                            if (!this.checkLoginData(folder)) { //htaccess file found! check for logindata
                                this.respondNotAllowed(); //not allowed!
                                join();//stop thread
                            } //just continue if the user is allowed
                            System.out.println("Access granted");
                        }

                        this.respond(doc, this.getMimeType(this.getExtension(doc)), 200); //RESPOND!
                    } else { //file doesnt exist, 404
                        System.out.println("File not found!");
                        this.respond("htdocs" + info.getSlash() + "404.html", "text/html", 404);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                this.respondInternalServerError();
            } catch (Exception e1) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Responds with the contents of a file
     *
     * @param path        path of a file
     * @param contentType MIME-type/Content-Type of file
     * @throws Exception exception
     */
    private void respond(String path, String contentType, int statuscode) throws Exception {
        if (contentType.equals("image/jpeg")) {
            this.respondImage(new File(path));
        } else {
            String data = read(path, Charset.defaultCharset()); //load data
            Headers headerToSend = new Headers(data.getBytes().length); //set the headers
            headerToSend.setContentType(contentType);
            headerToSend.setStatuscode(statuscode);
            this.finished(headerToSend.getHeaders(false), data.getBytes());
        }
    }

    /**
     * Responds with an image
     *
     * @param image File the image that you want to send
     * @throws IOException throws this when the image doesnt exist
     */
    private void respondImage(File image) throws IOException {
        BufferedImage origImage = ImageIO.read(image); //read the image to a bufferedImage
        ByteArrayOutputStream imageOutputStream = new ByteArrayOutputStream(); //make new outputstream to get bytearray

        ImageIO.write(origImage, "jpg", imageOutputStream); //write the image to the outputstream

        byte[] imageInByte = imageOutputStream.toByteArray(); //get the bytearray from the outputstream

        Headers headers = new Headers(imageInByte.length); //set the correct content-length
        headers.setContentType("image/jpeg");

        outputStream.write(headers.getHeaders(false).getBytes());
        outputStream.write(imageInByte);
        outputStream.flush();
        outputStream.close();
        socket.close();
    }

    /**
     * Responds with a Not Authorized page and requests http basic authentication
     *
     * @throws Exception exception
     */
    private void respondNotAllowed() throws Exception {
        System.out.println("Access denied!");
        String returnData = "<html><head></head><body><h2>Not authorized</h2></body></html>";
        Headers headers = new Headers(returnData.length());
        headers.setStatuscode(401);

        this.finished(headers.getHeaders(true), returnData.getBytes());
    }

    /**
     * Responds with an Internal Server Error (500) page
     *
     * @throws Exception
     */
    private void respondInternalServerError() throws Exception {
        System.out.println("Internal server error");
        String returnData = "<html><head></head><body><h2>Internal Server Error - 500</h2></body></html>";
        Headers headers = new Headers(returnData.length());
        headers.setStatuscode(500);

        this.finished(headers.getHeaders(true), returnData.getBytes());
    }

    /**
     * Respond with a header that redirects the user to another page
     *
     * @param movedToUrl String url of the page to redirect to
     * @throws Exception
     */
    private void respondMoved(String movedToUrl) throws Exception {
        System.out.println("Moved");
        Headers headers = new Headers(0);
        this.finished(headers.getMoved(movedToUrl), "".getBytes());
    }

    /**
     * Call this to finish a response and send it to the client
     *
     * @param headers String valid headers (Headers class can provide this)
     * @param data    byte[] (Data
     * @throws Exception
     */
    private void finished(String headers, byte[] data) throws Exception {
        outputStream.write(headers.getBytes());
        outputStream.write(data);
        outputStream.flush();
        outputStream.close();
        join();
    }

    /**
     * Reads a file and then returns a String object
     *
     * @param path     the path to the file
     * @param encoding the encoding of the file
     * @return String returns a string with file contents
     * @throws IOException File not found? exception
     */
    private String read(String path, Charset encoding) throws IOException {
        path = path.replace('/', info.getSlash());
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    /**
     * Check the credentials
     *
     * @param folder String folder to get the htaccess file for username&pass
     * @return boolean
     * @throws IOException if .htaccess file not found
     */
    private boolean checkLoginData(String folder) throws IOException {
        if (loginHeader) {//there is a authenticationheader
            System.out.println("Checking username and password..");
            String loginData = read("htdocs" + info.getSlash() + folder + info.getSlash() + ".htaccess", Charset.defaultCharset()); //load htaccess

            //check if username and password are correct
            return (loginData.split(":")[0].equals(username) && loginData.split(":")[1].equals(password));
        }
        return false; //no header? no dice.
    }

    /**
     * Get the path to a folder
     *
     * @param document String
     * @return String
     */
    private String getFolderPath(String document) {
        String[] splitPath = document.split(String.valueOf(info.getSlash()));
        String folder = "";
        for (int i = 1; i < splitPath.length - 1; i++) {
            folder += info.getSlash() + splitPath[i];
        }
        return folder;
    }

    /**
     * Returns a mimetype based on the file extension
     *
     * @param extension String extension of the file
     * @return String mimetype (e.g. text/html)
     */
    private String getMimeType(String extension) {
        switch (extension) { //respond with the right contenttype
            case "jpg":
                return "image/jpeg";
            case "html":
                return "text/html";
            case "css":
                return "text/css";
            case "js":
                return "text/javascript";
            case "woff":
                return "application/x-font-woff";
            case "woff2":
                return "font/woff2";
            case "ttf":
                return "application/font-ttf";
            case "eot":
                return "application/vnd.ms-fontobject";
            case "svg":
                return "image/svg+xml";
            case "map":
                return "application/json";
            default:
                return "text/plain"; //no extension, respond with plaintext
        }
    }

    /**
     * Get the file extension
     *
     * @param path String the path of the file
     * @return String the extension
     */
    private String getExtension(String path) {
        if (path.contains(".")) { //if there is an extension
            String[] extensionSplits = path.split("\\.");
            return extensionSplits[extensionSplits.length - 1];//get the extension
        }
        return "";
    }

    /**
     * Checks if the user tries to authenticate and sets the variables accordingly
     *
     * @param reader BufferedReader with the request
     * @throws IOException Throws an ioexception from the reader
     */
    private void checkForAuthentication(BufferedReader reader) throws Exception {
        String headerLine;
        while (!(headerLine = reader.readLine()).equals("")) { //as long as there are headers we're going to check em
            if (headerLine.startsWith("Authorization: Basic ")) { //hey, its an authorization header!
                loginHeader = true;
                int startFrom = headerLine.indexOf("c ") + 2;

                String encodedString = headerLine.substring(startFrom);
                String decodedString = new String(Base64.getDecoder().decode(encodedString)); //decode the string, cause its base64..

                String[] splitAuth = decodedString.split(":"); //username and password are separated by :

                if (splitAuth.length == 2) { //we WANT username AND password!
                    username = decodedString.split(":")[0];
                    password = decodedString.split(":")[1];
                } else {
                    this.respondNotAllowed();
                }
            }
        }
    }
}