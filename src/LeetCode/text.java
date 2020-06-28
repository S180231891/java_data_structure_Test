package LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class text {
    public static void main(String[] args) {
        int[] nums = {3,3,2,4,4};
        int res = majorityElement(nums);
        System.out.println(res);
    }
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}