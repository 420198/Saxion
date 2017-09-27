package week_5;

public class Opdracht3 {
    private int[] nums = new int[4];
    public static void main(String[] args) {
        new Opdracht3().run();
    }

    private void run() {
        nums[0] = 4;
        nums[1] = 2;
        nums[2] = 6;
        nums[3] = 1;

        System.out.println("\r\nbefore swap");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        swap(0,3);

        System.out.println("\r\nAfter swap");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    private void swap(int indexOne, int indexTwo){
        int temp = nums[indexTwo];
        nums[indexTwo] = nums[indexOne];
        nums[indexOne] = temp;
    }
}
