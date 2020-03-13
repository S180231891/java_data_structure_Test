package LeetCode;
//求最长公共前缀
public class zbg_014 {
    public static void main(String[] args) {
        String [] s = {"flow","flower","flight"};
        Z_14 text = new Z_14();
        String res = text.longestCommonPrefix(s);
        System.err.println(res);

    }
}

//水平扫描法
//ej：s=(a,b,c,d) == (((a,b),c),d)
class Z_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];//前缀
        for (int i = 1; i < strs.length; i++)
            //indexOf：方法返回字符串中首次出现的指定字符的位置
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}
