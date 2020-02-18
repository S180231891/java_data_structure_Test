public class recursion_demo_7
{
    public static void test(int n)
    {
        if(n>3){
            test(n-1);

        }//当n=3的时候结束递归，但要输出n的数值
        System.out.println(n);
    }

    public static int function(int n){
        if (n == 1){
            return n;
        }else {
            return function(n-1)*n;
        }


    }

    public static void main(String[] args) {
//        test(7);
        int res =function(3);
        System.out.println(res);
    }
}
