package week_5;

public class Opdracht9 {
    public static void main(String[] args) {
        new Opdracht9().run();
    }

    private void run() {
        int[] noDuplicates = new int[5];
        noDuplicates[0] = 1;
        noDuplicates[1] = 2;
        noDuplicates[2] = 3;
        noDuplicates[3] = 4;
        noDuplicates[4] = 5;

        //Unsorted array
        int[] duplicates = new int[5];
        duplicates[0] = 1;
        duplicates[1] = 2;
        duplicates[2] = 3;
        duplicates[3] = 4;
        duplicates[4] = 4;

        System.out.println(isItSorted(noDuplicates));
        System.out.println(isItSorted(duplicates));
    }

    private boolean isItSorted(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i + 1 < array.length) {
                // If curr position equals next position
                if (array[i] == array[i + 1]) {
                    return true;
                }
            }
        }
        //No returns means it was sorted
        return false;
    }
}
