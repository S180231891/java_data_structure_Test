package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class zbg_001 {
    public static class Solution {
        public int[] twoSum(int[] nums, int target) {  // 返回数组
            Map<Integer, Integer> map = new HashMap<>();  // 创建集合

            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {  // 判断map集合中是否包含指定的键名
                    return new int[] { map.get(complement), i };  //map.get(complement)获取value
                }
                map.put(nums[i], i);  // 第一位为数值，第二位为索引下标
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        Solution solution = new Solution();
        int[] data;
        data = solution.twoSum(nums,target);
        for(int text: data){
            System.out.println(text);
        }

    }

}
