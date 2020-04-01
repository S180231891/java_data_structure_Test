package LeetCode;

/**
 * 编写函数，求无符号整数的二进制中1的个数
 */
public class zbg_191
{
    public static void main(String[] args) {

    }
}

class z_191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        char[] x =s.toCharArray();
        int temp=0;
        for (int i=0;i<x.length;i++){
            if (x[i]!=0){
                temp++;
            }
        }
        return temp;
    }

    //官方代码：位操作
    public int HammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
