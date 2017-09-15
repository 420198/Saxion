package GUI.Threads;

import Model.DataHolder;
import Model.User;

import java.io.IOException;
import java.net.*;

/**
 * Created by sklar on 3/29/2017.
 */
public class OnlineAwareness extends Thread {
    private DataHolder holder;
    private DatagramSocket socket;
    public OnlineAwareness() throws SocketException {
        holder = DataHolder.getInstance();
        socket = new DatagramSocket();
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(holder.getUsers().size());
            for (User u : holder.getUsers()) {

                try {
                    InetAddress ip = InetAddress.getByName(u.getIp());
                    String message = "\"sender\":\"" + holder.getMainUser().getUsername() + "\",\"ip\":\"" + holder.getMainUser().getIp() + "\",\"areyouonline\":\"true\"";
                    byte[] buf = message.getBytes();
                    DatagramPacket packet = new DatagramPacket(buf, buf.length, ip, 27015);
                    socket.send(packet);
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }try {
                sleep(120000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
