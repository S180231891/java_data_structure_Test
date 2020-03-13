import java.util.Arrays;

public class Prism_13 {
    public static void main(String[] args) {
        //创建图
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int vex = data.length;
        //使用二维数组表示邻接矩阵的关系
        int [][] weight = new int[][]{
                {1000,5,7,1000,1000,1000,2},
                {5,1000,1000,9,1000,1000,3},
                {7,1000,1000,1000,8,1000,1000},
                {1000,9,1000,1000,1000,4,1000},
                {1000,1000,8,1000,1000,5,4},
                {1000,1000,1000,4,5,1000,6},
                {2,3,1000,1000,4,6,1000}
        };
        Graph graph = new Graph(vex);
        MTree mTree = new MTree();
        mTree.createGraph(graph,vex,data,weight);
        mTree.show(graph);
        mTree.prism(graph,6);

    }
}
//构建Prism图
class Graph{
    int vex;//表示图的节点个数
    char[] data;//存放节点数据
    int[][]weight;//存放边，邻接矩阵

    public Graph(int vex){
        this.vex = vex;
        data = new char[vex];
        weight = new int[vex][vex];
    }
}

//创建最小生成树
class MTree{
    //创建图的邻接矩阵

    /**
     *
     * @param graph：图对象
     * @param vex：顶点个数
     * @param data：顶点值
     * @param weight：邻接矩阵
     */
    public void createGraph(Graph graph, int vex,char[] data, int[][] weight){
        int i,j;
        for (i=0;i<vex;i++){
            graph.data[i] = data[i];
            for (j=0;j<vex;j++){
                graph.weight[i][j] =weight[i][j];
            }
        }
    }
    //显示图的方法
    public void show(Graph graph){
        for (int[] link: graph.weight){
            System.out.println(Arrays.toString(link));
        }
    }
    //编写prism算法，得到最小生成树
    /**
     * @param graph：图
     * @param t：表示从图的第几个顶点开始生成
     */
    public void prism(Graph graph,int t){
        //标记顶点是否被访问，默认为0
        int visited[] = new int[graph.vex];
        //最优路径长度
        int size = 0;
        //将当前的节点标记已访问
        visited[t] =1;
        //记录两个顶点的下标
        int h1=-1;
        int h2=-1;
        int minWeight = 10000;//在之后遍历的过程中会被替换
        //最小生成树有n个节点，n-1条边
        for (int k=1;k<graph.vex;k++){
            //确定每一次生成的子图和哪个节点的距离最近
            for (int i=0;i<graph.vex;i++){//i表示被访问过的节点
                for (int j=0;j<graph.vex;j++){//j表示未被访问的节点
                    if (visited[i] ==1 && visited[j] == 0 && graph.weight[i][j]<minWeight){
                        //替换minWeight(寻找已经访问过和为访问过权值最小的边)
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;

                    }
                }
            }
            System.out.println("边<"+graph.data[h1]+","+graph.data[h2]+"> 权值:"+minWeight);
            visited[h2] =1;
            size+=minWeight;
            //重置minWeight
            minWeight = 1000;
        }
        System.out.println("最小路径的权值为："+size);
    }
}
