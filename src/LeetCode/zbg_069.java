package LeetCode;
//计算x的平方根
public class zbg_069 {
    public static void main(String[] args) {
        int x = 9;
        zbg_69 text = new zbg_69();
        System.out.println(text.Sqrt(x));
    }
}
class zbg_69 {
    public int mySqrt(int x) {
        int sqrt = (int)Math.sqrt(x);
        return sqrt;
    }
    //使用牛顿法计算平方根
    //TODO：计算公式：X(k+1) = 1/2(Xk+X/Xk)
    public int Sqrt(int x) {
        if (x < 2) return x;

        double x0 = x;
        double x1 = (x0 + x / x0) / 2.0;
        while (Math.abs(x0 - x1) >= 1) {//误差相差1
            x0 = x1;
            x1 = (x0 + x / x0) / 2.0;
        }

        return (int)x1;
    }
}
