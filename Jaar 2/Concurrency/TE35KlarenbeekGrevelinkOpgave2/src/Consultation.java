import java.util.ArrayList;

/**
 * Created by sklar on 9/22/2016.
 */
public class Consultation {
    public static String USERS = "USERS";
    public static String DEVELOPERS = "DEVELOPERS";
    
    private String type;
    private ArrayList<Developers> developers;
    private ArrayList<ProgramUser> programUsers;

    public Consultation() {
        this.developers = new ArrayList<>();
        this.programUsers = new ArrayList<>();
    }

    public void setType(String type) {
        assert type != null : "type is null";
        assert !type.isEmpty() : "type is empty";
        assert (type.equals(USERS) || type.equals(DEVELOPERS)) : "Invalid type";
        this.type = type;
    }

    public boolean addUser(ProgramUser programUser) {
        assert programUser != null : "programuser is null";
        return programUsers.add(programUser);
    }

    public boolean addDeveloper(Developers developer) {
        assert developer != null : "developers = null";
        if (type.equals(USERS) && developers.size() == 0) {
            return developers.add(developer);
        } else if (type.equals(DEVELOPERS)) {
            return developers.add(developer);
        } else {
            return false;
        }
    }

    public int getAllusers() {
        assert developers.size() + programUsers.size() != 0 : "size of both lists is 0";
        return developers.size() + programUsers.size();
    }

    public void endConsultation() {
        if (type.equals(DEVELOPERS)) {
            developers.clear();
        } else {
            developers.clear();
            programUsers.clear();
        }

        System.out.println("---------------------");
    }
}
