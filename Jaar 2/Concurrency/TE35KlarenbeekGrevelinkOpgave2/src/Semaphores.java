import java.util.concurrent.Semaphore;

/**
 * Created by sklar on 9/22/2016.
 */
public class Semaphores {
    private static Semaphores instance;
    private Semaphore pLeader, mutex, consultationS, accountedUsers, accountedDevelopers, invitations;
    private int usersC, invitationsC, developersC;
    private Consultation consultation;

    private Semaphores() {
        mutex = new Semaphore(1);
        consultationS = new Semaphore(0);
        invitations = new Semaphore(0, true);
        accountedDevelopers = new Semaphore(0, true);
        accountedUsers = new Semaphore(0, true);
        pLeader = new Semaphore(0);

        usersC = invitationsC = developersC = 0;
        consultation = new Consultation();
    }

    public static Semaphores getInstance() {
        if (instance == null) {
            instance = new Semaphores();
        }
        return instance;
    }

    public Semaphore getpLeader() {
        return pLeader;
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public Semaphore getConsultationS() {
        return consultationS;
    }

    public Semaphore getAccountedUsers() {
        return accountedUsers;
    }

    public Semaphore getAccountedDevelopers() {
        return accountedDevelopers;
    }

    public Semaphore getInvitations() {
        return invitations;
    }

    public int getUsersC() {
        return usersC;
    }

    public void setUsersC(int usersC) {
        this.usersC = usersC;
    }

    public int getInvitationsC() {
        return invitationsC;
    }

    public void setInvitationsC(int invitationsC) {
        this.invitationsC = invitationsC;
    }

    public int getDevelopersC() {
        return developersC;
    }

    public void setDevelopersC(int developersC) {
        this.developersC = developersC;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void addInvitationsC() {
        this.invitationsC++;
    }

    public void addUser() {
        this.usersC++;
    }

    public void addDeveloper() {
        this.developersC++;
    }
}