package LeetCode;
//整数反转
public class zbg_007 {
    public static void main(String[] args) {
        int x = -1234;
        Z_7 text = new Z_7();
        int t = text.reverse(x);
        System.out.println(t);
    }
}
class Z_7 {
    //反转算法实现
    public int reverse(int x) {
        int a = 0;
        // 直接对数字进行操作
        while (x != 0)
        {
            // 记录x的值
            int sum = a*10 + x%10;
            if ((sum - x%10)/10 != a) {return 0;}
            a = sum;
            x = x/10;
        }
        return a;
    }
}
