// 线性查找
public class Linear_Search_09 {
    public static int Linear(int [] s, int var){
        //查找到首位数就返回
        for (int i=0;i<s.length;i++){
            if (s[i] == var){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] s = {1,9,11,-1,34,89};
        int t = Linear(s,34);
        if (t==-1)
            System.out.printf("在数组中未找到相应的数值");
        System.out.println(t);
    }
}
