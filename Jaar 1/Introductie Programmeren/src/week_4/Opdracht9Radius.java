package week_4;

import java.util.Scanner;

public class Opdracht9Radius {
    public static void main(String[] args) {
        new Opdracht9Radius().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int radius;

        System.out.print("Enter radius: ");
        do {
            radius = scanner.nextInt();
            if (radius < 0) {
                System.out.println("Invalid radius, try again!");
                System.out.print("\r\nEnter radius: ");
                continue;
            } else if (radius == 0) {
                System.out.println("That's all, folks!");
                break;
            } else {
                System.out.println("Circumference of a circle with radius " + radius + ": " + ((Math.PI * 2) * radius));
                System.out.println("Surface area of a circle with radius " + radius + ": " + (Math.PI * Math.pow(radius, 2)));
                System.out.println("Surface area of a sphere with radius " + radius + ": " + ((Math.PI * 4) * Math.pow(radius, 2)));
                System.out.println("Enclosed volume of a sphere with radius " + radius + ": " + ((Math.PI * 1.3333333333333333334) * Math.pow(radius, 3)));

                System.out.print("\r\nEnter radius: ");
            }
        } while (scanner.hasNextInt());
    }
}
