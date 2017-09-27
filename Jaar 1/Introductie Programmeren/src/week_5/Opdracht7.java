package week_5;

public class Opdracht7 {
    public static void main(String[] args) {
        new Opdracht7().run();
    }

    private void run() {
        int[] sorted = new int[4];
        sorted[0] = 1;
        sorted[1] = 2;
        sorted[2] = 4;
        sorted[3] = 6;

        //Unsorted array
        int[] unsorted = new int[4];
        unsorted[0] = 1;
        unsorted[1] = 2;
        unsorted[2] = 6;
        unsorted[3] = 4;

        System.out.println(isItSorted(sorted));
        System.out.println(isItSorted(unsorted));
    }

    private boolean isItSorted(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i + 1 < array.length) {
                //If curr position > next position, immediatly return false. No need to go on cause it is already unsorted.
                if (array[i] > array[i + 1]) {
                    return false;
                }
            }
        }
        //No returns means it was sorted
        return true;
    }
}
