/**
 * Created by sklar on 9/22/2016.
 */
public class ProjectLeader extends Person {
    private Semaphores semaphores;

    /**
     * Constructor for projectleader
     *
     * @param myid String
     */
    public ProjectLeader(String myid) {
        super(myid);
        semaphores = Semaphores.getInstance();
    }

    @Override
    public void run() {
        while (true) {
            try {

                semaphores.getpLeader().acquire();

                semaphores.getMutex().acquire();
                if (semaphores.getInvitationsC() > 0) {
                    semaphores.getInvitations().release(semaphores.getInvitationsC());
                    semaphores.setInvitationsC(0);
                }
                semaphores.getMutex().release();

                if (semaphores.getDevelopersC() >= 1 && semaphores.getUsersC() >= 1) {
                    //User consultation??
                    overleg(semaphores.getConsultation().USERS);
                } else if (semaphores.getDevelopersC() == 3) {
                    //Developer consultation???
                    overleg(semaphores.getConsultation().DEVELOPERS);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void overleg(String type) {
        System.out.println(toString() + " has started a consultation of type: " + type);
        semaphores.getConsultation().setType(type);
        try {
            semaphores.getMutex().acquire();

            semaphores.getAccountedDevelopers().release(semaphores.getDevelopersC());
            semaphores.setDevelopersC(0);

            semaphores.getAccountedUsers().release(semaphores.getUsersC());
            semaphores.setUsersC(0);

            semaphores.getMutex().release();

            //Overleg
            sleep(2000);

            System.out.println(toString() + " has ended the consultation");

            semaphores.getConsultationS().release(semaphores.getConsultation().getAllusers());
            semaphores.getConsultation().endConsultation();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
