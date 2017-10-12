/**
 * Created by sklar on 9/22/2016.
 */
public class Developers extends Person {
    private Semaphores semaphores;
    private boolean readyForConsultation;

    public Developers(String myid) {
        super(myid);
        semaphores = Semaphores.getInstance();
    }

    @Override
    public void run() {
        while (true) {
            work();
            try {
                semaphores.getMutex().acquire();
                if (semaphores.getDevelopersC() < 3) {
                    semaphores.addDeveloper();
                    readyForConsultation = true;
                }
                semaphores.getMutex().release();
                if (readyForConsultation) {
                    readyForConsultation = false;
                    semaphores.getAccountedDevelopers().acquire();
                    semaphores.getMutex().acquire();

                    if (semaphores.getConsultation().addDeveloper(this)) {
                        System.out.println(toString() + " is in consultation");
                        semaphores.getMutex().release();
                        semaphores.getConsultationS().acquire();
                    } else {
                        semaphores.getMutex().release();
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void work() {
        sleep(2000);
    }
}
