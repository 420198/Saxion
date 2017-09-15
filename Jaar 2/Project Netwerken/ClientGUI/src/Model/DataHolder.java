package Model;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;

/**
 * Created by sklar on 3/13/2017.
 */
public class DataHolder {
    private static DataHolder instance = new DataHolder();

    private ArrayList<Node> nodes;
    private LinkedHashMap<String, Channel> channels;
    private ArrayList<User> users;
    private LinkedHashMap<String, Channel> groups;

    private User mainUser;
    private int buflen;

    private DataHolder() {

        nodes = new ArrayList<>();
        nodes.add(new Node("192.0.0.1"));
        nodes.add(new Node("192.0.0.2"));
        nodes.add(new Node("192.0.0.3"));
        nodes.add(new Node("192.0.0.4"));
        nodes.add(new Node("192.0.0.5"));
        nodes.add(new Node("192.120.10.5"));

        channels = new LinkedHashMap<>();
        users = new ArrayList<>();
        users.add(new User("Stijn", "localhost"));
        users.add(new User("Frank", "localhost"));
        users.add(new User("LJ", "localhost"));
        users.add(new User("Brownie", "localhost"));
        users.add(new User("Robbin", "localhost"));
        users.add(new User("Lars", "localhost"));
        users.add(new User("Tom", "localhost"));
        users.add(new User("Aram", "localhost"));
        groups = new LinkedHashMap<>();
        buflen = 1024;
    }

    /***
     * Getters
     */
    public static DataHolder getInstance() {
        return instance;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public User getMainUser() {
        return mainUser;
    }

    public LinkedHashMap<String, Channel> getChannels() {
        return channels;
    }

    public LinkedHashMap<String, Channel> getGroups() {
        return groups;
    }

    public int getBuflen() {
        return buflen;
    }

    public ArrayList<User> getUsers() {
        return users;
    }


    /**
     * Setters
     */
    public void setMainUser(User mainUser) {
        this.mainUser = mainUser;
    }


    /**
     * User handelingen
     */
    public boolean addUser(User user){
        for (User u : users) {
            if(u.getUsername().equals(user.getUsername())){
                return false;
            }
        }
        return users.add(user);
    }

    public User getUserByIp(String ip){
        for(User u :users){
            if(u.getIp().equals(ip)){
                return u;
            }
        }
        return null;
    }


    /**
     * Channel handelingen
     */
    public void addChannelMultipleUsers(Channel channel) {
        channels.put(channel.getName(), channel);
    }

    public Channel getChannelByname(String name) {
        return channels.get(name);
    }

    public void addGroup(Channel channel) {
        groups.putIfAbsent(channel.getName(),channel);
    }

    public Channel getGroupByName(String name){
        return groups.get(name);
    }


    /**
     * Node handelingen
     */
    /**
     * Add nodes to the arraylist
     *
     * @param node
     */
    public boolean addNode(Node node) {
        if(!nodeExists(node.getIp()) && validIp(node.getIp())){
            nodes.add(node);
            return true;
        }
        return false;
    }

    /**
     * get a node by ip
     */
    public Node getByIp(String ip){
        for (Node node: nodes) {
            if(node.getIp().equals(ip)){
                return node;
            }
        }
        return null;
    }

    /**
     * algorithm for generating a random nodepath
     */
    public Node[] getNodePath(int counter, int nrOfNodes) {
        Node[] nodePath = new Node[nrOfNodes];
        boolean[] used = new boolean[nodes.size()];
        Random random = new Random();

        //Loop waarin pad med nrOfNodes wordt
        while (counter<nrOfNodes) {
            //Random nummer uit lijst en kijk of hij beschikbaar is
            int num = random.nextInt(nodes.size());
            if (!used[num] && available(num)) {
                //Beschikbaar: voeg toe
                nodePath[counter] = nodes.get(num);
                counter++;
            }
            used[num] = true;
        }
        return nodePath;
    }

    /**
     * Check of node beschikbaar is
     *
     * @param nodeNr node nummer
     * @return beschikbaar
     */
    private boolean available(int nodeNr) {
        return true;
    }

    /**
     * Check of node bestaat
     *
     * @param node ip
     * @return bestaat
     */
    public boolean nodeExists(String node) {
        for (Node no : nodes) {
            if(no.getIp().equals(node)){
                return true;
            }
        }
        return false;
    }

    /**
     * Check voor valid ip
     *
     * @param node ip
     * @return valid
     */
    public boolean validIp(String node) {
        String[] split = node.split("[.]");
        if (split.length == 4) {
            for (int i = 0; i < split.length - 1; i++) {
                int num = Integer.parseInt(split[i]);
                if (num < 0 || num > 255) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public Pair<String, String> nodeEncryption(StringBuilder builder) {

        Node[] path = getNodePath(0, 3);
        //TODO:: stringbuilder to string, clear builder
        //TODO:: ENCRYPT using encrypt(path[path.length])
        //TODO:: insert into builder

        for (int i = path.length; i >1; i--) {

            String m = path[i-1].getIp();
            int l = 16-m.length();
            for (int j = 0; j < l; j++) {
                m+=" ";
            }
            String toEncrypt =m+ builder.toString();
            builder.delete(0,builder.length());

            //TODO::ENCRYPT USING encrypt(path[i-1].getKey())
            builder.insert(0,toEncrypt);
        }
        return new Pair<>(path[0].getIp(), builder.toString());
    }
}