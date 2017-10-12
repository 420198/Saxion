import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Created by sklar on 11/17/2016.
 */
public class Server {
    private ArrayList<Socket> sockets;
    private ArrayList<Clientthread> clientthreads;
    private ServerSocket serverSocket;

    public static void main(String[] args) {

        new Server().run();
    }

    private void run() {
        sockets = new ArrayList<>();
        clientthreads = new ArrayList<>();
        try {
            serverSocket = new ServerSocket(1337);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {

                System.out.println("Connecting to port: " + serverSocket.getLocalPort());
                Socket socket = serverSocket.accept();
                sockets.add(socket);
                Clientthread thread = new Clientthread(socket);
                thread.start();
                clientthreads.add(thread);
                //start new client thread;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class Clientthread extends Thread {
        private Socket socket;
        private boolean userNameSet;
        private String username;
        private boolean running = true;

        public Clientthread(Socket socket) {
            this.socket = socket;
        }

        public String getUsername() {
            return username;
        }

        public Socket getSocket() {
            return socket;
        }

        @Override
        public void run() {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (running) {
                try {
                    String str = reader.readLine();
                    System.out.println(str);
                    if (!userNameSet) {
                        boolean succes = true;
                        if (clientthreads.size() > 1) {
                            for (Clientthread ct : clientthreads) {
                                if (ct.getUsername() != null && ct.getUsername().equals(str)) {
                                    succes = false;
                                }
                            }
                        }
                        if (succes) {
                            this.username = str;
                            userNameSet = true;
                            sendMessageToUser("Username has been set");
                        } else {
                            sendMessageToUser("Username has already been taken");
                        }
                    } else {
                        if (str.startsWith("/pm")) {
                            String[] split = str.split(" ");
                            String message = "";
                            for (int i = 2; i < split.length; i++) {
                                message += split[i] + " ";
                            }
                            sendPm(split[1], this, message);
                        } else if (str.startsWith("/stop")) {
                            System.out.println("IK BEN GESTOPT");
                            stopT();
                        } else {
                            String message = "Username: " + username + "\n" + "Message: " + str + "\n";
                            sendToAll(message);
                        }


                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    try {
                        stopT();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }

        private void sendToAll(String message) throws IOException {
            for (int i = 0; i < sockets.size(); i++) {
                System.out.println(message);
                sockets.get(i).getOutputStream().write(message.getBytes());
            }
        }

        private void sendMessageToUser(String message) {
            try {
                socket.getOutputStream().write(message.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void stopT() throws IOException {
            clientthreads.remove(this);
            sockets.remove(socket);
            sendMessageToUser("stopped");
            socket.close();
            running = false;
            return;
        }
    }

    private void sendPm(String recipient, Clientthread sender, String message) throws IOException {
        boolean exists = false;
        Clientthread ctToSend = null;
        for (Clientthread ct : clientthreads) {
            if (ct.getUsername().equals(recipient) && ct != null) {
                ctToSend = ct;
                exists = true;
            }
        }
        if (exists) {
            String mToSend = "-----------------------------------------------------" +
                    "\nHey, " + recipient +
                    "\nYou have received a pm from " + sender.getUsername() +
                    "\nMessage: " + message + "\n" +
                    "-----------------------------------------------------\n";
            ctToSend.getSocket().getOutputStream().write(mToSend.getBytes());
        } else {
            String mToSend = "User doesn't exist";
            sender.getSocket().getOutputStream().write(mToSend.getBytes());
        }
    }
}