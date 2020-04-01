package LeetCode;

/**
 * 将给定的二进制位进行颠倒
 */
public class zbg_190
{
    public static void main(String[] args) {
        int n = 2;
        int t = reverseBits(n );
        System.out.println(t);

    }

    public static int reverseBits(int n) {
        int ans = 0;
        for (int bitsSize = 31; n != 0; n = n >>> 1, bitsSize--) {
            ans += (n & 1) << bitsSize;
        }
        return ans;
    }
}
