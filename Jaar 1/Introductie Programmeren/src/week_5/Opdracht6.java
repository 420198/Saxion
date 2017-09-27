package week_5;

public class Opdracht6 {
    public static void main(String[] args) {
        new Opdracht6().run();
    }

    private void run() {
        int[] nums = new int[4];
        nums[0] = 4;
        nums[1] = 2;
        nums[2] = 6;
        nums[3] = 1;

        int lowest = Integer.MAX_VALUE;
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < lowest) {
                lowest = nums[i];
            }
            total += nums[i];
        }
        System.out.println(total - lowest);
    }
}
