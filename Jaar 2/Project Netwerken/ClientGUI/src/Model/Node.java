package Model;

/**
 * Created by sklar on 3/13/2017.
 */
public class Node {
    private String ip;
    private String key;

    public Node(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
