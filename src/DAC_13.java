//TODO：分治算法解决汉诺塔问题
public class DAC_13 {
    public static void main(String[] args) {
        HanNuoTa(5,'A','B','C');
    }
    //分治方法
    public static void HanNuoTa(int num, char a,char b, char c){
        if (num == 1){
            System.out.println("第1个盘从"+a+"->"+c);
        }else{
            //num>=2,将其总是看作两个盘，1：最下边的盘；2：其余的所有盘
            //1、先将最上边的所有盘由A-B,移动过程使用到C
            HanNuoTa(num-1,a,c,b);
            //2、将最下面的盘从A-C
            System.out.println("第"+num+"个盘从"+a+"->"+c);
            //3、将B上的所有盘移动到C，移动过程使用到A
            HanNuoTa(num-1,b,a,c);
        }

    }
}
