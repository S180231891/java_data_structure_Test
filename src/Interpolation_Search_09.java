import java.util.Arrays;

public class Interpolation_Search_09 {
    //插值搜索
    public static int InterPolation(int[] s,int left, int right, int val){
        int median = left+(right-left)*(val-s[left])/(s[right]-s[left]);
        int medianValue = s[median];
        System.out.println("执行次数");
        //避免越界，边界必须判断
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
        int t = InterPolation(s,0,s.length-1,99);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        int m = Binary_Search_09.Binary(s,99,0,s.length-1);


    }
}

