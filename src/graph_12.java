import java.util.ArrayList;
import java.util.Arrays;

public class graph_12 {
    private ArrayList<String> verList;//创建存储节点的集合
    private int[][] edges;//创建图对应的邻接矩阵
    private int numedges;//边的数目
    //定义数组flag[],标记节点是否被访问
    private boolean [] flag;//对应节点的个数

    public static void main(String[] args) {
        int n = 5;//节点的个数
        String VerText[] ={"A","B","C","D","E"};
        //创建图对象
        graph_12 graph = new graph_12(n);
        //循环添加节点
        for (String value: VerText){
            graph.insertVerTex(value);
        }
        //添加边 A-B,A-C,B-C,B-D,B-E
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        //显示邻接矩阵
        graph.showGraph();
    }

    //创建构造器
    public graph_12(int n){
        //初始化矩阵和verList
        edges = new int[n][n];//邻接矩阵
        verList = new ArrayList<String>(n);//创建存储节点的结合
        numedges = 0;//记录边的数目
        flag = new boolean[n];
    }
    //得到第一个邻接节点的下标
    public int getFirst(int index){
        for (int j=0;j<verList.size();j++){
            if (edges[index][j]>0){
                return j;
            }
        }
        return -1;
    }

    //插入节点
    public void insertVerTex(String s){
        verList.add(s);
    }
    //插入边

    /**
     * @param v1：表示第一个顶点对应的下标
     * @param v2：第二个顶点对应的下标
     * @param weight：权值
     */
    public void insertEdge(int v1,int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numedges++;

    }
    //返回节点的方法
    public int getVertex(){
        return verList.size();
    }
    //返回边的数目
    public int getEdges(){
        return numedges;
    }
    //返回节点i对应的数值
    public String getValueIndex(int i){
        return verList.get(i);
    }
    //返回v1和v2的权值
    public int getWeight(int v1, int v2){
        return edges[v1][2];
    }
    //显示图对应的矩阵
    public void showGraph(){
        //System.err.println(Arrays.deepToString(edges));
        for (int[] link: edges)
            System.err.println(Arrays.toString(link));//err使得输出的数据颜色为红色
    }

}
