package LeetCode;

public class zbg_028 {
    public static void main(String[] args) {
        String v1 = "AABCB";
        String v2 = "BC";
        zbg_28 text = new zbg_28();
        int res = text.strStr(v1,v2);
        System.out.println(res);
    }
}
//字符串匹配
class zbg_28 {
    //使用滑动窗口的方法
    public int strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        for (int start = 0; start < n - L + 1; ++start) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;
    }

}
