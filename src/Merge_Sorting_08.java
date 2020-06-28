import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
// 效率高
//归并排序算法实现
public class Merge_Sorting_08 {
    //算法划分
    public static void Merge_Divide(int [] s, int left, int right,int [] temp){
        if (left<right){
            int median = (left+right)/2;
            //向左递归进行划分
            Merge_Divide(s,left,median,temp);
            //向右递归进行划分
            Merge_Divide(s,median+1,right,temp);
            //合并
            Merge(s,left,right, median,temp);
        }
    }

    //算法合并(有序的子数组合并)
    public static void Merge(int [] s, int left, int right, int median, int [] temp){
        int i = left;//左边有序序列的初始索引
        int j = median+1;//右边有序序列的初始索引
        int t = 0;//指向temp索引的当前位置

        /*
            算法合并
            1、先将左右两边的有序数据按照规则添加到temp中，直到两边的有序数列有一方填充完毕为止
            2、若有剩余数据，直接将剩余数据依次加入temp即可
            3、将temp数据copy给s
         */
        //升序排列
        while (i<=median && j<=right){
            if (s[i]<=s[j]){
                temp[t++] = s[i++];
            }else if (s[i]>=s[j]){
                temp[t++] = s[j++];
            }
        }
        //若有一方还有数据，直接加入temp中
        while (i<=median) {
            temp[t++] = s[i++];
        }
        while (j<=right) {
            temp[t++] = s[j++];
        }

        /*
            copy temp -->  s
            TODO:并不是每一次都需要拷贝
         */
        t = 0;
        int tempLeft = left;
        while (tempLeft<=right){
            s[tempLeft++] = temp[t++];
        }
        System.out.println(Arrays.toString(s));
    }
    public static void main(String[] args) {
         int [] next = {8,4,5,7,1,3,6,2};
//        int [] next = new int[8000000];
//        for (int i=0;i<8000000;i++){
//            next[i] =(int)(Math.random()*8000000);
//        }
        int [] temp = new int[next.length];
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String t1 = simpleDateFormat1.format(date1);
        Merge_Divide(next,0,next.length-1, temp);
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String t2 = simpleDateFormat1.format(date2);
        System.out.println(t1);
        System.out.println(t2);
//        System.out.println(Arrays.toString(next));
    }
}
