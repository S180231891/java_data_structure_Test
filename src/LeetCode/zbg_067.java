package LeetCode;
//二进制求和
//TODO：不想看了 记录位置
public class zbg_067 {
    public static void main(String[] args) {
        zbg_67 text = new zbg_67();
        String a="1101011";
        String b ="110011011";
        System.out.println(text.addBinary(a,b));
    }
}
class zbg_67 {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }
}