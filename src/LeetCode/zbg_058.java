package LeetCode;
//最后一个单词的长度
public class zbg_058 {
    public static void main(String[] args) {
        String s = "        ";
        zbg_58 text = new zbg_58();
        int res = text.lengthOfLastWord(s);
        System.out.println(res);
    }
}
class zbg_58 {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        int count = 0;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == ' '){
                if(count == 0) continue;
                break;
            }
            count++;
        }
        return count;
    }
}
