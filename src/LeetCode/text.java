package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class text {
    public static void main(String[] args) {
        String s = "abcba";
        String res= Palindrome(s);
        System.err.println();
    }
    //以时间换空间
    public static String Long(String s){
        int length = s.length();
        int maxLen=0;
        String maxP = "";
        boolean[][] P = new boolean[length][length];
        for (int len=1;len<=length;len++){
            for (int start=0;start<length;start++){
                int end = start+len-1;
                if (end>=length){
                    break;
                }
                P[start][end] = (len==1 ||len==2||P[start+1][end-1]) && s.charAt(start)==s.charAt(end);
                if (P[start][end]&&len>maxLen){
                    maxP = s.substring(start, end+1);
                }
            }
        }
        return maxP;
    }

    //减少空间复杂度
    public static String Palindrome(String s) {
        int n = s.length();
        String res = "";
        boolean[] P = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                P[j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || P[j - 1]);
                if (P[j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }


}