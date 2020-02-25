import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Binary_Search_09 {
    public static int Binary(int[] s, int val, int left, int right){

        /*
        二分查找算法
            核心思想：
            1、确定数组的中心下标median
            2、s[median]与val进行比较
                s[median]>val:则在[left, median-1]之间进行查找
                s[median]<val:则在[median+1, right]之间进行查找
                s[median]==val:查找结束
            3、left>right时，退出程序
         */
        //确定查找不到的状况
        System.out.println("执行次数");
        if (left>right)
            return -1;
        int median = (right + left)/2;
        int medianValue = s[median];
        if (val>medianValue){
           return Binary(s,val,median+1,right);
        }else if (val<medianValue){
            return Binary(s,val,left,median-1);
        }else
            return median;

    }
    //查找多个相同的数值
    public static ArrayList<Integer> Binary_Double(int[] s, int val, int left, int right) {
        if (left > right)
            return new ArrayList<Integer>();
        int median = (right + left) / 2;
        int medianValue = s[median];
        if (val > medianValue) {
            return Binary_Double(s, val, median + 1, right);
        } else if (val < medianValue) {
            return Binary_Double(s, val, left, median - 1);
        } else {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int temp = median - 1;
            while (s[temp] == val) {
                list.add(temp--);
            }
            list.add(median);

            temp = median + 1;
            while (s[temp] == val && temp <= s.length - 1) {
                list.add(temp++);
            }
            return list;
        }
    }

    public static void main(String[] args) {
        int[] s = {1,8,10,89,1000,1000,1000,9000,1234};
        int z = Binary(s,1000,0,s.length-1);
         ArrayList<Integer> t = Binary_Double(s,9,0,s.length-1);
         System.out.println(z);
        System.out.println(t);
    }
}
