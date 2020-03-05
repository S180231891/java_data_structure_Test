//暴力搜索算法
public class Violence_Match_13 {
    public static void main(String[] args) {
        String v1 = "你我你我你我他京津冀";
        String v2 = "你我他";
        int s = Search(v1,v2);
        System.out.println(s);
    }
    public static int Search(String v1, String v2) {
        char[] s1 = v1.toCharArray();
        char[] s2 = v2.toCharArray();
        int t = s1.length;
        int t2 = s2.length;
        int i=0;
        int j=0;
        while (i<t && j<t2){
            if (s1[i] == s2[j]){
                i++;
                j++;
            }else {
                i = i - j + 1;
                j=0;
            }
        }
        if (j == t2){
            return i-j;
        }else
            return -1;

    }
}
