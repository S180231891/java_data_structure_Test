package LeetCode;

/**
 * 爬楼梯
 * 每次爬1或2层台阶，计算有多少种方法爬到指定的楼层
 * 解法：使用斐波那契数列进行求解
 */
public class zbg_070 {
    public static void main(String[] args) {
        int n = 5;
        zbg_70 text = new zbg_70();
        System.out.println(text.climbStairs(n));
    }
}

class zbg_70 {
    public int climbStairs(int n) {
        if (n<=2)
            return n;
        int x1 = 1;
        int x2 = 2;
        int X = 0;
        for (int i=3;i<=n;i++){
            X= x1+x2;
            x1=x2;
            x2=X;
        }
        return X;
    }
}
