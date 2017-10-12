import httpServer.ResponseHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by sklar on 12/15/2016.
 */
public class WebServer {
    private void run(int portNumber) {
        while (true) {
            try {
                System.out.println("Ready for a request!");
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket socket = serverSocket.accept();
                ResponseHandler responseHandler = new ResponseHandler(socket);
                responseHandler.run();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
                return; //cant bind, quit!
            }
        }
    }
    public static void main(String args[]){
        System.out.println("Server started!");
        int port = (args[0].isEmpty()) ? 8080 : Integer.parseInt(args[0]); //get port to use..
        new WebServer().run(port);
    }
}