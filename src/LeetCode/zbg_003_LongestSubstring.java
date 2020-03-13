package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class zbg_003_LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        int end=0,start=0;
        Set<Character> set=new HashSet<>();
        while(start<n && end<n){
            if(set.contains(s.charAt(end))){
                set.remove(s.charAt(start++));//优秀
            }else{
                set.add(s.charAt(end++));
                res=Math.max(res,end-start);//优秀
            }
        }
        return res;
    }
}
