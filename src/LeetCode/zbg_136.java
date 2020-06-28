package LeetCode;

import java.util.Arrays;

public class zbg_136 {
    public static void main(String[] args) {
        int[] a = {2,5,1,4,3};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i=0;i<nums.length-1;i+=2){
            if (nums[i]!=nums[i+1])
                return nums[i];
        }
        return nums[nums.length-1];
    }
}
