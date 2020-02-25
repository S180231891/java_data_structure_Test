import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Insert_Sorting_08 {
    public static void Insert(int [] s ){
        int temp = 0;
        //只用一个数组，节省空间的同时没有浪费时间
        //直接插入
        for (int i=1;i<s.length;i++){
            for (int j =0;j<i;j++){
                if (s[j]>s[i]){//构造升序数组
                    temp = s[j];
                    s[j] = s[i];
                    s[i] = temp;
                }
            }
//            System.out.println(Arrays.toString(s));

        }
    }

    public static void main(String[] args) {
        int [] s = {17,3,-4,54,-7,5,14,20,9};
        Insert(s);
        int [] next = new int[80000];
        for (int i=0;i<80000;i++){
            next[i] = (int)(Math.random()*80000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String t1 = simpleDateFormat1.format(date1);
//        Insert(next);
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String t2 = simpleDateFormat1.format(date2);
//        System.out.println(t1);
//        System.out.println(t2);
//        System.out.println(Arrays.toString(next));

    }
}
