package Model;

/**
 * Created by sklar on 8/31/2016.
 */
public class User {
    private String username;
    private String password;

    /**
     * Constructor voor nieuwe user
     * @param username String
     * @param password String
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
