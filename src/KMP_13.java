import java.util.Arrays;

public class KMP_13 {
    public static void main(String[] args) {
        String v1 = "BBC ABCDAB ABCDABCDABDE";
        String v2 = "ABCDABD";
        int [] next = kmpNext("ABCDABD");
        System.out.println(Arrays.toString(next));
        int result = SearchKmp(v1, v2, next);
        System.out.println(result);


    }
    //编写kmp搜索算法

    /**
     * @param s1：原字符串
     * @param s2：子串
     * @param text：子串对应的部分匹配表
     * @return：-1 无，否则返回第一个匹配的位置
     */
    public static int SearchKmp(String s1,String s2,int[] text){
        for (int i=0,j=0;i<s1.length();i++){
            //当不相等时：s1.charAt(i) ！= s2.charAt(j) 调整j的大小
            while (j>0&&s1.charAt(i)!=s2.charAt(j)){
                j = text[j-1];
            }
            if (s1.charAt(i) == s2.charAt(j)){
                j++;
            }
            if (j==s2.length()){
                return i-j+1;
            }else{

            }
        }
        return -1;
    }

    //获取字符串的部分匹配值
    public static int[] kmpNext(String s){
        //s：子串
        //创建数组保存部分匹配值
        int [] text = new int [s.length()];
        text[0] = 0;//若字符串长度为1，则匹配值为0
        for (int i=1,j=0;i<s.length();i++){
            //当s.charAt(i) ！= s.charAt(j)时，从text[j-1]获取新的j，直到s.charAt(i) == s.charAt(j)相等退出
            while (j>0&& s.charAt(i) != s.charAt(j)){
                //TODO：牛逼 算法的核心
                j=text[j-1];
            }
            if (s.charAt(i) == s.charAt(j)){
                //部分匹配值加1
                j++;
            }
            text[i] =j;
        }
        return text;
    }
}
