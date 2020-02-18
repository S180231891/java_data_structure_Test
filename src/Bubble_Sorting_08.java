import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
//冒泡排序
public class Bubble_Sorting_08 {
    public static void Bubble(int [] s){
        int temp = 0;

        for (int j = 0; j<s.length-1;j++){
            boolean flag = true;
            for (int i = 0; i < s.length-1-j; i++) {
                if (s[i] > s[i + 1]) {
                    temp = s[i];
                    s[i] = s[i + 1];
                    s[i + 1] = temp;
                    flag = false;
                }
            }
            //当不进行交换操作时，说明数组有序，跳出循环
            if (flag){
                break;
            }
        }
    }
    public static void main(String[] args) {
//        int [] next = {3,9,-1,10,-2};
//        Bubble(next);
        int text[] = new int[80000];
        for (int i=0;i<80000;i++){
            text[i] = (int) (Math.random()*80000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String d1=simpleDateFormat1.format(date1);
        Bubble(text);
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String d2=simpleDateFormat2.format(date2);
//        System.out.println(Arrays.toString(text));
        System.out.println(d1);
        System.out.println(d2);
    }

}
