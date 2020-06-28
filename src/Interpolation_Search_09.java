import java.util.Arrays;

public class Interpolation_Search_09 {
    //TODO:插值搜索:median = left+(right-left)*(var-s[left])/(s[right]-s[left])

    public static int InterPolation(int[] s,int left, int right, int val){

        int median = left+(right-left)*(val-s[left])/(s[right]-s[left]);
        int medianValue = s[median];
        System.out.printf("median = %d",median);
        //避免越界，边界必须判断(有序数组，进行插值)
        if (left>right || val<s[0] || val>s[s.length-1])
            return -1;
            if (val<medianValue){
                return InterPolation(s,left,median-1,val);
            }else if (val>medianValue){
                return InterPolation(s,median+1,right,val);
            } else
                return median;
    }
    public static void main(String[] args) {
        int[] s = new int[100];
        for (int i=0;i<s.length;i++){
            s[i]=i+1;
        }
        int t = InterPolation(s,0,s.length-1,23);
//        int m = Binary_Search_09.Binary(s,99,0,s.length-1);//输出查找值的下标
    }
}

