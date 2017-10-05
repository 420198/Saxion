package week_6.Opdracht4;

import java.util.Random;

public class BoundsJava {
    private Random random = new Random();

    public static void main(String[] args) {
        new BoundsJava().run();
    }

    private void run() {
        System.out.println(getRandInBounds(1, 6));
    }

    private String getRandInBounds(int lower, int higher) {
        return String.valueOf(random.nextInt(higher - lower) + lower);
    }
}
