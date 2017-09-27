package week_5;

public class Opdracht4 {
    public static void main(String[] args) {
        new Opdracht4().run();
    }

    private void run() {
        int[] nums = new int[4];
        nums[0]=4;
        nums[1]=2;
        nums[2]=6;
        nums[3]=1;

        int highest = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>highest){
                highest = nums[i];
            }
        }
        System.out.println(highest);
    }
}
