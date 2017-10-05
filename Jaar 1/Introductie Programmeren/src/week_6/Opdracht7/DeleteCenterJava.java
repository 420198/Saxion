package week_6.Opdracht7;

import java.util.Arrays;

public class DeleteCenterJava {
    public static void main(String[] args) {
        new DeleteCenterJava().run();
    }

    private void run() {
        System.out.println(Arrays.toString(deleteCenter(3,2,6,1,0)));
        System.out.println(Arrays.toString(deleteCenter(3,2,6,1,2,0)));
    }

    private int[] deleteCenter(int... nums) {
        int[] arr;
        if(nums.length % 2 == 0){
            nums[nums.length/2-1]=0;
            arr = new int[nums.length-2];
        }else{
            arr = new int[nums.length-1];
        }
        nums[nums.length/2]=0;

        int j = 0;
        for (int num : nums) {
            if (num != 0) arr[j++] = num;
        }
        return arr;
    }
}
