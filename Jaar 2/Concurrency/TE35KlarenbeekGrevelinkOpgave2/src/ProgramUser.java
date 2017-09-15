/**
 * Created by sklar on 9/22/2016.
 */
public class ProgramUser extends Person {
    private Semaphores semaphores;

    public ProgramUser(String myid) {
        super(myid);
        semaphores = Semaphores.getInstance();
    }

    @Override
    public void run() {
        while (true) {
            softwareTest();
            try {
                semaphores.getpLeader().release();
                semaphores.getMutex().acquire();
                semaphores.addInvitationsC();
                semaphores.getMutex().release();

                semaphores.getInvitations().acquire();

                gotoCompany();

                semaphores.getpLeader().release();

                semaphores.getMutex().acquire();
                semaphores.addUser();
                semaphores.getMutex().release();

                semaphores.getAccountedUsers().acquire();

                //add gebruiker here
                semaphores.getMutex().acquire();
                semaphores.getConsultation().addUser(this);
                System.out.println(toString() + " is in consultation");
                semaphores.getMutex().release();

                semaphores.getConsultationS().acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void gotoCompany() {
        sleep(5000);
    }

    private void softwareTest() {
        sleep(2000);
    }
}