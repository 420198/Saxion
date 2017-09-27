package week_5;

public class Opdracht1 {
    public static void main(String[] args) {
        new Opdracht1().run();
    }

    private void run() {
        int[] nums = new int[4];
        nums[0]=4;
        nums[1]=2;
        nums[2]=6;
        nums[3]=1;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
