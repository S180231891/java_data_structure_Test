import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Huffman_Tree_11 {
    public static void main(String[] args) {
        int [] arr = {13,7,8,3,29,6,1};
        Node tree = Huffman(arr);
        PreOrder(tree);
    }
    //编写前序遍历的方法
    public static void PreOrder(Node node){
        if (node!=null){
            node.PreOrder();
        }else
            System.out.println("Tree Null");
    }
    //2、创建Huffman树
    public static Node Huffman(int [] arr) {
        //为操作方便，需遍历数组
        //将数组的每个元素构建成Node
        //将Node放入到ArrayList中
        List<Node> nodeList = new ArrayList<Node>();
        for (int value:arr){
            nodeList.add(new Node(value));//将数组中每个元素添加到构建的Node中，将Node存入ArrayList
        }
        //取出权值最小的两颗二叉树
        while (nodeList.size()>1) {
            Collections.sort(nodeList);//排序不可避免，必须进行排序，升序排列
            //取出最小的两个值
            Node left = nodeList.get(0);
            Node right = nodeList.get(1);

            //构建新的二叉树
            Node newTree = new Node(left.value + right.value);
            newTree.left = left;
            newTree.right = right;

            //从ArrayList中删除处理过的二叉树（节点）
            nodeList.remove(left);
            nodeList.remove(right);

            //将新的节点newTree加入到noList中
            nodeList.add(newTree);
//            System.out.println(nodeList);
        }
        return nodeList.get(0);
    }
}

//1、创建node节点
//使Node对象进行排序Collections，需创建并实现Comparable接口
class Node implements Comparable<Node>{
    int value;//节点权值
    Node left;//指向左节点
    Node right;//指向右节点

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public void PreOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.PreOrder();
        }
        if (this.right!=null){
            this.right.PreOrder();
        }
    }

    @Override
    //Comparable必须实现的接口
    public int compareTo(Node o) {
        //从小到大进行排序，反之，从大到小
        return this.value-o.value;//
    }
}
