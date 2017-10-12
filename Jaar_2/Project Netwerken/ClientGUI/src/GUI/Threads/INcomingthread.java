package GUI.Threads;

import GUI.Controllers.MainViewController;
import GUI.Controllers.MessageHandleI;
import Model.DataHolder;
import javafx.util.Pair;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sklar on 3/27/2017.
 */
public class INcomingthread extends Thread {

    private List<MessageHandleI> messageHandleIS = new ArrayList<>();
    private DatagramSocket socket;
    private byte[] buff;
    private DataHolder holder;

    public INcomingthread() throws SocketException {
        socket = new DatagramSocket(27015);
        holder = DataHolder.getInstance();
        buff = new byte[holder.getBuflen()];

    }

    public void addListener(MessageHandleI mhi) {
        messageHandleIS.add(mhi);
    }

    @Override
    public void run() {
        while (true) {
            try {
                DatagramPacket packet = new DatagramPacket(buff, holder.getBuflen());
                socket.receive(packet);

                String message = new String(packet.getData(), 0, packet.getLength());
                if (message.contains("\"sender\":\"") && message.contains("\"ip\":\"") && message.contains("\"areyouonline\":\"true\"")) {
                    onlineAwarenessAsked(message);
                } else if (message.contains("\"iamonline\":\"true\"")) {
                    onlineAwarenessReceveid(message);
                } else if (message.contains("\"keynode\":\"")) {
                    keyNode(message);
                } else if (message.contains("\"sender\":\"") &&
                        message.contains("\",\"ip\":\"") &&
                        message.contains("\",\"mykey\":\"") &&
                        message.contains("\",\"keyclient\":\" true\"")) {
                    clientKeyRequest(message);
                } else if (message.contains("\"ip\":\"") && message.contains("\",\"key\":\"")) {
                    incomingKeyClient(message);
                } else if (message.contains("\"sender\":\"") &&
                        message.contains(",\"groupname\":\"") &&
                        message.contains(",\"members\":\"") &&
                        message.contains(",\"body\":\"") &&
                        message.contains(",\"message\":\"true\"")) {
                    handleGroupMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Handles being asked if you are online
     */
    private void onlineAwarenessAsked(String string) throws IOException {
        String[] strings = string.split("[\"]");

        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName(strings[7]);
        String message = "\"iamonline\":\"true\"";
        byte[] buf = message.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, ip, 27015);
        socket.send(packet);
        socket.close();

    }

    private void onlineAwarenessReceveid(String string) {
        System.out.println("Yay, people are online");
    }

    /**
     * Received key from node, what now?
     *
     * @param string
     */
    private void keyNode(String string) {
        //TODO:: implement
        String[] strings = string.split("[\"]");
        if (holder.nodeExists(strings[3])) {
            holder.getByIp(strings[3]).setKey(strings[7]);
        }
    }

    private void clientKeyRequest(String message) throws GeneralSecurityException, IOException {
        String[] split = message.split("[\"]");
        for (int i = 0; i < split.length; i++) {
            System.out.println(i + split[i]);
        }
        if (holder.getByIp(split[7]) != null) {
            holder.getUserByIp(split[7]).storePublicKey(split[11]);
            String mu = "\"ip\":\"" + holder.getMainUser().getIp() +
                    "\",\"key\":\"" + holder.getMainUser().getPb() + "\"";
            String ipu = split[7];
            int l = 16 - ipu.length();
            for (int i = 0; i < l; i++) {
                ipu += " ";
            }
            Pair<String, String> pair = holder.nodeEncryption(new StringBuilder(ipu + mu));

            DatagramSocket socket = new DatagramSocket();
            InetAddress ip = InetAddress.getByName(pair.getKey());
            byte[] buf = pair.getValue().getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, ip, 27015);
            socket.send(packet);
            socket.close();
        }
    }

    private void incomingKeyClient(String message) throws GeneralSecurityException {
        String[] split = message.split("[\"]");
        holder.getUserByIp(split[2]).storePublicKey(split[6]);
    }

    private void handleGroupMessage(String message) {
        for (MessageHandleI mi : messageHandleIS) {
            mi.handleGroupMessage(message);
        }
    }

}
