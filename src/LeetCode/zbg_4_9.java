package LeetCode;

import java.util.Arrays;

/**
 * 给定数组，编写函数，找出索引m,n
 * 只要[m,n]中元素排好序，该数组就是有序的
 * 查找符合条件的索引[m,n]
 */
public class zbg_4_9 {
    public static void main(String[] args) {
        int [] n = {1,3,5,7,9};
        int[] ints = subSort(n);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] subSort(int[] array) {
        if(array == null || array.length == 0) return new int[]{-1, -1};
        int last = -1, first = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = array.length;
        for(int i = 0; i < len; i++){
            if(array[i] < max){
                last = i;
            }else{
                max = Math.max(max, array[i]);
            }

            if(array[len - 1 - i] > min){
                first = len - 1 - i;
            }else{
                min = Math.min(min, array[len - 1 - i]);
            }
        }
        return new int[] {first, last};
    }
}
