package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class zbg_1481 {
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        //排序，找出重复项
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        int tip = 1;
        for (int i=0;i<arr.length-1;i++){
            if (arr[i]==arr[i+1]){
                tip++;
            }else {
                map.put(arr[i],tip);
                tip = 1;
            }
        }
        map.put(arr[arr.length-1],tip);
        int size = map.size();
        int m = 0;
        int [] test = new int[size];
        for(int key : map.keySet()){
            test[m++] = map.get(key);
        }
        Arrays.sort(test);
        for(int c : test){
            if(k >= c){
                k -= c;
                size--;
            }else{
                break;
            }
        }
        return size;
    }


    public static void main(String[] args) {
        System.out.println("寻找最少的不相同的元素");
    }
}


