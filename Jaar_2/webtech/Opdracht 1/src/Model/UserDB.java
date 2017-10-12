package Model;

import java.util.ArrayList;

/**
 * Created by sklar on 8/31/2016.
 */
public class UserDB {
    private ArrayList<User> users;
    private boolean loggedIn;

    /**
     * Constructor voor nieuwe user database
     */
    public UserDB(){
        users = new ArrayList<>();
    }

    /**
     * Registreren van nieuwe gebruiker
     * @param user String
     * @return boolean, wel of niet gelukt
     */
    public boolean register(User user){
        boolean registerSucces;
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getUsername().equals(user.getUsername())){
                registerSucces = false;
                return registerSucces;
            }
        }
        users.add(user);
        registerSucces = true;
        return registerSucces;
    }
    public boolean login(User user){
        String username = user.getUsername();
        String password = user.getPassword();
        for (int i = 0; i < users.size(); i++) {
            if(username.equals(users.get(i).getUsername())){
                if(password.equals(users.get(i).getPassword())){
                    loggedIn = true;
                    return loggedIn;
                }else{
                    loggedIn = false;
                }
            } else{
                loggedIn = false;
            }
        }

        return loggedIn;
    }

    public void logout(){
        loggedIn = false;
    }

    public String printHuurders(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i) instanceof Huurder) {
                builder.append(users.get(i).getUsername() + ", ");
            }
        }
        return builder.toString();
    }

    public String printVerhuurders(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i) instanceof Verhuurder) {
                builder.append(users.get(i).getUsername() + ", ");
            }
        }
        return builder.toString();
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
