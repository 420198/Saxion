package Model;

import java.util.ArrayList;

/**
 * Created by sklar on 3/16/2017.
 */
public class Channel {
    private ArrayList<User> users;
    private ArrayList<Message> messages;
    private String name;
    private boolean friend = false;

    /**
     * Constructor for channel with 1 user
     * @param users users
     */
    public Channel(ArrayList<User> users) {
        this.users = users;
        this.name = users.get(0).getUsername();
        messages = new ArrayList<>();
    }

    /**
     * Constructor for channel with multip;le users
     * @param users user
     * @param name name
     */
    public Channel(ArrayList<User> users, String name) {
        this.users = users;
        this.name = name;
        messages = new ArrayList<>();
    }


    /**
     * Setters
     */
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    /**
     * Getters
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public String getName() {
        return name;
    }

    public boolean isFriend() {
        return friend;
    }


    /**
     * Add message
     */
    public void addMessage(Message message){
        messages.add(message);
    }
}
