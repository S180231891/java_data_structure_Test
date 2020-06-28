package LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class text {
    public static void main(String[] args) {
        int[] nums = {3,3,2,4,4};
        int res = majorityElement(nums);
        System.out.println(res);
    }
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

}

class ArrayQuere{
    private int maxsize;
    private int front;
    private int rear;
    private int[] arr;

    //创建列表
    public ArrayQuere(int maxsize){
        maxsize = maxsize;
        arr = new int[maxsize];
        front = -1;
        rear = -1;
    }

    //判man
    public boolean isFull(){
        return rear == maxsize-1;
    }

    //判空
    public boolean isEmpty(){
        return front ==rear;
    }

    //插入数据
    public void add_data(int s){
        if (isFull()){
            throw new RuntimeException("队列满");
        }
        rear++;
        arr[rear] = s;
    }

    //显示数据列表
    public void get_data(){
        if (isFull()){
            System.out.println("列表为空");
        }
        for (int i=0;i<=arr.length;i++){
            System.out.printf("arr[%d] = %d\n",i, arr[i]);
        }
    }

    //查询数据
    public int select_data(){
        if (isEmpty()){
            System.out.println("恐慌");
        }
        return arr[++front];
    }
}