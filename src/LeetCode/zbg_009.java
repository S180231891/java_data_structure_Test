package LeetCode;

public class zbg_009 {
    public static void main(String[] args) {
        int s = 1234321;
        Z_9 text = new Z_9();
        boolean t = text.isPalindrome(s);
        System.out.println(t);
    }
}
class Z_9 {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int cur = 0;
        int num = x;
        while(num != 0) {
            cur = cur * 10 + num % 10;  //数字反转
            num /= 10;
        }
        return cur == x;//反转以后的值是否和原数相等
    }
}
