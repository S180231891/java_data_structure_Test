import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Radix_Sorting {
    public static void Radix(int [] s){
        //为防止数据溢出，则每个数组的大小为s.length
        //基数排序是典型的以时间换空间的排序方法
        int[][] bix = new int[10][s.length];
        //为记录每个桶中实际存放的数据，定义一个一维数组来记录各个桶中每次放入的个数
        int[] temp = new int[10];//数组默认初始值为0
        for (int t=1;t<Arrays.stream(s).max().getAsInt();t*=10){
            for (int i=0;i<s.length;i++){
                int Element = s[i]/t%10;
                bix[Element][temp[Element]++] = s[i];
            }
            //按照桶中的数据，依次取出数组
            int index = 0;
            //遍历每一个桶，并将桶中的数据放入到原数组中
            for (int k=0;k<temp.length;k++){
                if (temp[k]!=0){
                    for (int j = 0;j<temp[k];j++){
                        s[index++] = bix[k][j];

                    }
                    temp[k] = 0;
                }

            }
            //System.out.println(Arrays.toString(s));
        }
    }

    public static void main(String[] args) {
        int [] s = {53, 3, 542,748,14,214};
        //TODO:可直接获取数组中的最值
        System.out.println(Arrays.stream(s).max().getAsInt());
        //Radix(s);
        int[] next = new int[80000];
        for (int i=0;i<80000;i++){
            next[i] =(int)(Math.random()*80000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat1= new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String t1=simpleDateFormat1.format(date1);
        Radix(next);
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2= new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String t2=simpleDateFormat1.format(date2);
        System.out.println(t1);
        System.out.println(t2);
    }
}
