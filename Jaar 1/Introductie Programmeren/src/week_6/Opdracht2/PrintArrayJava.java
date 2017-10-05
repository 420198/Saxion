package week_6.Opdracht2;

public class PrintArrayJava {
    public static void main(String[] args) {
        double[] arr = new double[4];
        arr[0] = 8.5;
        arr[1] = 4.5;
        arr[2] = 5.5;
        arr[3] = 6.5;
        new PrintArrayJava().printArray(arr);
    }

    private void printArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(String.valueOf(arr[i]));
        }
    }
}
