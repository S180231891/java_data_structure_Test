package LeetCode;
//外观数列？？(题目都要蒙圈了)
public class zbg_038 {
    public static void main(String[] args) {
        int n = 2;
        zbg_38 text = new zbg_38();
        String res = text.countAndSay(n);
        System.out.println(res);
    }
}
class zbg_38 {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        String s = "1";
        for(int i = 2; i <= n; i++) {
            char[] ch = s.toCharArray();//字符数组
            int count = 1;
            StringBuilder result = new StringBuilder();//创建字符串
            for(int j = 1; j < ch.length; j++) {
                if(ch[j] == ch[j-1]) count++;
                else {
                    result.append(String.valueOf(count));//将任何类型的数据转换为字符串形式
                    result.append(ch[j-1]);
                    count = 1;
                }
            }
            result.append(String.valueOf(count));
            result.append(ch[ch.length-1]);
            s = result.toString();
        }
        return s;
    }
}

