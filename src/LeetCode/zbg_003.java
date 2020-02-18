package LeetCode;

import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0)    return -1;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length();
        int result = map.get(s.charAt(len - 1));
        for(int i = len-2;i>=0;i--){
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)))
                result += map.get(s.charAt(i));
            else
                result -= map.get(s.charAt(i));
        }
        return result;
    }
}

public class zbg_003 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int t = s.romanToInt("IXLVIII");
        System.out.println(t);
    }

}
