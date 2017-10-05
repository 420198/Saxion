package week_6.Opdracht6;

public class AverageJava {
    public static void main(String[] args) {
        new AverageJava().run();
    }

    private void run() {
        average(6.0,1.0,2.0,6.0,8.0,9.0,12.0,3.0);
        average(6.0,1.0,2.0,6.0,8.0,9.0,12.0,13.0);
    }

    private void average(double... nums) {
        int tot = 0;
        for (double i: nums) {
            tot+=i;
        }
        System.out.println("Average: " + (double)tot/nums.length);
    }
}
