import java.util.Arrays;
//斐波那契数列查找
public class Fibonacci_Search_09 {
    public static int maxSize = 20;
    public static int[] fib(){
        //斐波那契数列
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i=2;i<maxSize;i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }
    public static int Fibonacci(int [] s, int val){
        int low = 0;
        int hight = s.length-1;
        int k = 0;//斐波那契数列分割数值的下标
        int median=0;
        int[] f = fib();//获取斐波那契数列
        while (hight>f[k]-1){//寻找黄金分割点
            k++;
        }
        //f[k]的值可能大于s的长度，因此需构造一个新的数组Arrays，使其指向s
        //若存在不足，则以0补充
        int[] temp = Arrays.copyOf(s,f[k]);
        //实际上使用s.height来完成对数组的填充
        for (int i=hight+1;i<temp.length;i++){
            temp[i] = s[hight];
        }
        //while循环查找key
        while (low<=hight){
            median = low+f[k-1]-1;
            if (val< temp[median]){
                hight = median-1;
                //继续拆分f[k],因为f[k] = f[k-1]-f[k-2],前面有f[k-1]个元素，所以k-=1
                k--;
            }else if (val>temp[median]){
                low = median+1;
                //继续拆分f[k],因为f[k] = f[k-1]-f[k-2],后面有f[k-2]个元素，所以k-=2
                //f[k-1] = f[k-3]+f[k-4]
                k-=2;
            }else {
                //需要确定返回的是哪一个下标
                if (median <= hight) {
                    return median;
                } else
                    return hight;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] s = {1,8,10,89,1000,1234};
        System.out.println(Fibonacci(s,0));
    }
}
