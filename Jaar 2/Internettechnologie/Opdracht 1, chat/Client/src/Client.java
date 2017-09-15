import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Created by sklar on 11/17/2016.
 */
public class Client {
    private Socket socket;
    private String username;
    private boolean userNameSet;
    public volatile boolean running;

    public static void main(String[] args) {
        new Client().run(args);
    }

    private void run(String[] args) {
        try {
            socket = new Socket(args[0], Integer.parseInt(args[1]));
            System.out.println("Welcome to the fantastical chat app!\n");
            System.out.println("Input your username: ");
            OutputThread outputThread = new OutputThread();
            InputThread inputThread = new InputThread();
            running=true;
            outputThread.start();
            inputThread.start();
        } catch (IOException e) {
            e.printStackTrace();
            running = false;
            try {
                socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    private class OutputThread extends Thread {
        private Scanner scanner = new Scanner(System.in);

        @Override
        public void run() {
            while (running) {
                try {
                    String temp = scanner.nextLine();
                    if (!userNameSet) {
                        username = temp;
                        userNameSet = true;
                    }
                    temp +="\n";

                    System.out.println(temp);

                    socket.getOutputStream().write(temp.getBytes());
                    socket.getOutputStream().flush();
                }catch (IOException e){
                    e.printStackTrace();
                }

            }
        }
    }

    private class InputThread extends Thread {
        @Override
        public void run() {
            while (running) {
                try {
                    if (socket.getInputStream().available() > 0) {
                        byte[] buffer;
                        buffer = new byte[socket.getInputStream().available()];
                        socket.getInputStream().read(buffer);
                        String str = new String(buffer, StandardCharsets.UTF_8);
                        if(str.equals("Username has already been taken")){
                            userNameSet =false;
                        }else if(str.equals("stopped")){
                            running = false;
                            socket.close();
                        }
                        System.out.println(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
