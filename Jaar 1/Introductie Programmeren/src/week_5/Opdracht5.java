package week_5;

public class Opdracht5 {
    public static void main(String[] args) {
        new Opdracht5().run();
    }

    private void run() {
        double[] array = new double[4];
        array[0] = 3.0;
        array[1] = 7.5;
        array[2] = 2.5;
        array[3] = 6.0;

        double total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }

        System.out.println(total/array.length);
    }
}
