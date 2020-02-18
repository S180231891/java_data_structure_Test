import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Select_Sorting_08 {
    public static void Select(int [] s){
        for (int i=0;i<s.length-1;i++){
            int top = i;
            int temp = s[i];
            boolean flag = true;
            for (int j=i+1; j<s.length;j++) {
                if (temp<s[j]){//从大到小排序
                    temp = s[j];
                    top = j;
                    flag = false;
                }
            }
            s[top] = s[i];
            s[i] = temp;
            if (flag){
                break;
            }
//            System.out.println(Arrays.toString(s));

        }

    }
    public static void main(String[] args) {
        int [] s = {101, 34, 119, 1};
        Select(s);
        int text[] = new int[80000];
        for (int i=0;i<80000;i++){
            text[i] = (int) (Math.random()*80000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String d1=simpleDateFormat1.format(date1);
        Select(text);
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String d2=simpleDateFormat2.format(date2);
        System.out.println(Arrays.toString(text));
        System.out.println(d1);
        System.out.println(d2);
    }
}
