import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
//快速排序
public class Quick_Sorting_08 {
    public static void Quick(int [] s,int left, int right){
        int l = left;
        int r = right;
        int median = s[(left + right)/2];
        int temp = 0;
        // 目的是将小于median的值置于左边，大于median的值置于右边
        //可用断点进行调试
        while (l<r){
            while (s[l]<median){
                l++;
            }
            while (s[r] > median){
                r--;
            }
            if (l >= r){
                break;
            }
            //数值交换
            temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            if (s[l] == median){
                r--;
            }
            if (s[r] == median){
                l++;
            }
        }
        /*
        [-9,78,40,23,-567,70]
        [-9, -567, 23, 40, 78, 70]
        [-567, -9, 23, 40, 78, 70]
        [-567, -9, 23, 40, 78, 70]
        [-567, -9, 23, 40, 70, 78]
         */
         // System.out.println(Arrays.toString(s));
        /*
          [-9, 78, 5, 23, -567, 70]
          [-9, -567, 5, 23, 78, 70]
          [-567, -9, 5, 23, 78, 70]
          [-567, -9, 5, 23, 70, 78]
          [-567, -9, 5, 23, 70, 78]
         */
        if (l==r){
            l = l+1;
            r = r-1;
        }
        System.out.println(Arrays.toString(s));
        //调用递归操作
        if (left < r){
            Quick(s,left,r);
        }
        if (right>l){
            Quick(s,l,right);
        }
    }

    public static void main(String[] args) {
        int [] s = {-9,78,40,23,-567,70} ;
        Quick(s,0,s.length-1);
//        int [] next = new int[80000];
//        for (int i=0;i<80000;i++){
//            next[i] = (int)(Math.random()*80000);
//        }
//        Date date1 = new Date();
//        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
//        String t1 = simpleDateFormat1.format(date1);
//        Quick(next,0,next.length-1);
//        Date date2 = new Date();
//        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
//        String t2 = simpleDateFormat1.format(date2);
//        System.out.println(t1);
//        System.out.println(t2);
//        System.out.println(Arrays.toString(s));
    }
}
