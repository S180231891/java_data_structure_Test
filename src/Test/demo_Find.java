package Test;

import java.util.Arrays;

public class demo_Find {
    public static void main(String[] args) {
        int[] s = {1,8,10,89,1000,1000,1000,9000,1234};
        int z = Binary(s,1000,0,s.length-1);
        System.out.println(z);
    }

    //二分查找：使用递归遍历
    public static int Binary(int[] s, int val, int left, int right) {
        int median = (left + right) / 2;
        int medin_size = s[median];
        if (left > right) {
            return -1;
        }
        if (val > medin_size) {
            return Binary(s, val, median + 1, right);
        } else if (val < medin_size) {
            return Binary(s, val, left, median - 1);
        } else
            return median;
    }

    //插值查找
    public static int insert_data(int[] s, int left, int right, int val){
        int median = left+(right - left)*(val - left)/(s[right] - s[left]);
        int value = s[median];
        if (val<s[0] || val>s[s.length-1] || left>right)
            return -1;
        if (val>value){
            return insert_data(s,median+1,right, val);
        }else if (val<value){
            return insert_data(s, left, median-1, val);
        }else
            return median;
    }

    //斐波那契差值
    public static int maxsize = 20;
    public static int[] fib(){
        int[] f = new int[maxsize];
        f[0] = 1;
        f[1] = 1;
        for (int i=2;i<f.length;i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }
    public static int fibonacci(int[] s, int val){
        int low = 0;
        int top = s.length-1;
        int k = 0;
        int median=0;
        int[] f = fib();
        while (top>f[k]-1){
            k++;
        }
        int[] temp = Arrays.copyOf(s, f[k]);
        for (int i=top+1;i<f[k];i++){
            temp[i] = s[top];
        }
        while (low<top){
            median = low +f[k-1] -1;
            if (val<temp[median]){
                top = median-1;
                k-=1;
            }else if (val>temp[median]){
                low = median+1;
                k-=2;
            }else
                if (median<=top){
                    return median;
                }else
                    return top;
        }
        return -1;
    }
}


