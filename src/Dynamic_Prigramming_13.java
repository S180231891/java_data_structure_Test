import java.util.Arrays;

//动态规划实现背包问题
public class Dynamic_Prigramming_13 {
    public static void main(String[] args) {
        int[] w = {1,4,3};//物品容量
        int[] v = {1500,3000,2000};//物品价值
        int m = 4;//背包容量
        int n = v.length;
        //记录背包最终的选择方案
        int[][] path = new int[n+1][m+1];

        //创建二维数组,行列加1的原因是有全0行全0列存在
        //V[i][j]:表示在前i个物品中，能够装入容量为j的背包的最大价值
        int[][] V  = new int[n+1][m+1];
        //初始化第1行第1列
        for (int i=0;i<V.length;i++){
            V[i][0] = 0;//将第1列置为0
        }
        for (int j=0;j<V[0].length;j++){
            V[0][j] = 0;//将第1行置为0
        }
        //动态规划实现
        for (int i=1;i<V.length;i++){
            for (int j=1;j<V[0].length;j++){
                if (w[i-1]>j){
                    V[i][j] = V[i-1][j];
                }else{
                    //在编程时，下标从0开始，所以，w、v均需要减1
                    //V[i][j] =Math.max(V[i-1][j],V[i-1][j-w[i-1]]+v[i-1]);
                    if (V[i-1][j]<V[i-1][j-w[i-1]]+v[i-1]){
                        V[i][j] = V[i-1][j-w[i-1]]+v[i-1];
                        path[i][j] = 1;
                    }else
                        V[i][j] = V[i][j-1];
                }

            }
        }

        //输出数组
        int i = path.length-1;//行下标
        int j = path[0].length-1;//列下标
        while (i > 0 && j > 0){
            if (path[i][j] == 1){
                System.out.printf("第%d个商品进入背包\n",i);
                j-=w[i-1];//调整背包容量
            }
            i--;
        }

    }

}
