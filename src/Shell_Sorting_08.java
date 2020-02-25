import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Shell_Sorting_08 {
    //交换法进行希尔排序
    public static void Shell(int [] s){
        int temp = 0;
        int top = (int)s.length/2;
        boolean flag = true;
        //也可使用for循环进行遍历
        while (flag){
            for (int i=top;i<s.length;i++){
                for (int j =i-top;j>=0;j-=top){
                    if (s[j]>s[j+top]){
                        //TODO：此处代码有待优化
                        temp = s[j];
                        s[j]=s[j+top];
                        s[j+top]=temp;
                        System.out.println(Arrays.toString(s));
                    }
                }
            }
//            System.out.println(Arrays.toString(s));
            if (top==1){
                flag = false;
            }
            top/=2;
        }

    }
    //移动法进行希尔排序
    //TODO:效率非常高，速度非常快
    public static void Shell_2(int [] s){
        for (int top=s.length/2;top>0;top/=2){
            for (int i=top;i<s.length;i++){
                int j = i;
                int temp = s[j];
                while((j-top)>=0 && temp<s[j-top]){
                    s[j] = s[j-top];
                    j-=top;
                }
                s[j]= temp;
                System.out.println(Arrays.toString(s));
                }
        }
    }
    public static void main(String[] args) {
        //,2,3,5,4,6,0
        //int [] s = {8,9,1,7};
        int [] s = {2,5,1,3,8};
        Shell(s);
//        int [] next = new int[80000];
//        for (int i=0;i<80000;i++){
//            next[i] = (int)(Math.random()*80000);
//        }
//        Date date1 = new Date();
//        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
//        String t1 = simpleDateFormat1.format(date1);
//        Shell_2(next);
//        Date date2 = new Date();
//        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
//        String t2 = simpleDateFormat1.format(date2);
//        System.out.println(t1);
//        System.out.println(t2);
//        System.out.println(Arrays.toString(next));
    }
}
