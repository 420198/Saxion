/**
 * Created by sklar on 9/22/2016.
 */
public class Project {
    private int USER_AMOUNT;
    private int DEVELOPER_AMOUNT;

    private ProjectLeader leader;

    private ProgramUser programuser;
    private Developers developer;

    public static void main(String args[]) {
        new Project().run();
    }

    public void run() {
        leader = new ProjectLeader("Jaap");
        leader.start();

        USER_AMOUNT = 10;
        DEVELOPER_AMOUNT = 6;
        for (int i = 0; i < USER_AMOUNT; i++) {
            programuser = new ProgramUser("u" + i);
            programuser.start();
        }
        for (int i = 0; i < DEVELOPER_AMOUNT; i++) {
            developer = new Developers("d" + i);
            developer.start();
        }
    }
}
