package LeetCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class zbg_4_7 {
    public static void main(String[] args) {

    }
    int m,n,k;
    public  int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        //标记已访问过的位置
        boolean[][] visited=new boolean[m][n];
        return dfs(0,0,0,visited);

    }
    //使用深度搜索算法
    private int dfs(int i, int j, int sum, boolean[][] visited) {
        //如果 坐标越界 或者 数位和大于k 或者 已经访问过，则停止当前方向的深搜
        if (i==m||j==n||sum>k||visited[i][j])return 0;
        //标记为已访问
        visited[i][j]=true;
        //向下或者向右深搜
        return 1+dfs(i+1,j,sum(i+1,j),visited)+dfs(i,j+1,sum(i,j+1),visited);
    }

    public int sum(int x,int y){
        int temp = 0;
        while (x!=0){
            temp += x%10;
            x = x/10;
        }
        while (y!=0){
            temp += y%10;
            y = y/10;
        }
        return temp;
    }
}
