package LeetCode;

import java.util.Arrays;

public class zbg_169
{
    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
