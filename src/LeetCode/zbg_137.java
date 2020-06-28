package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//判断数组中只出现一次的数字
public class zbg_137 {
    public static void main(String[] args) {
        int[] n = {2,2,2,5,4,4,4};
        int i = singleNumber(n);
        System.out.println(i);
    }
    //暴力方法
    public int singleNumber1(int[] nums) {
        Arrays.sort(nums);
        for (int i=0;i<nums.length-1;i+=3){
            if (nums[i]!=nums[i+2])
                return nums[i];
        }
        return nums[nums.length-1];
    }
    //使用HashSet解决
    public static int singleNumber(int[] nums) {
        Set<Long> set = new HashSet<>();
        long sumSet = 0, sumArray = 0;
        for(int n : nums) {
            sumArray += n;
            set.add((long)n);
        }
        System.out.println(set);
        for(Long s : set) sumSet += s;
        return (int)((3 * sumSet - sumArray) / 2);
    }

}
