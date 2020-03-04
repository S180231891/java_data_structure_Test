import java.util.*;

public class Hufuman_Code_11 {
    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        byte[] bytes = str.getBytes();//长度为40，进行字节转码，ej：a-->97
        //System.out.println(Arrays.toString(bytes));
        List<HNode> data =getHNode(bytes);
        HNode tree = HuffmanCode(data);
        PreOrder(tree);//只有叶子节点才会有data，其余节点data为空（NULL）
        System.out.println(data);
        System.out.println("哈夫曼编码表：");
        //getCodes(tree,"",stringBuilder);
        Map<Byte, String> stringMap = getCodes(tree);
        System.out.println(stringMap);
    }

    //方法重载
    public static Map<Byte, String> getCodes(HNode node){
        if (node == null){
            return null;
        }else{
            //处理node的左子树
            getCodes(node.left,"0",stringBuilder);
            //处理右子树
            getCodes(node.right,"1",stringBuilder);
        }
        return stringMap;
    }
    //TODO:代码未完成，之后抽空在写，😅(为完成章节，120-126)
    //编写方法，返回字符串对应的byte[]数组，通过生成的赫夫曼编码表，生成赫夫曼处理后的byte[]数组
    /**
     *
     * @param bytes：原始字符对应的数组
     * @param map：数组生成的赫夫曼编码
     * @return：返回赫夫曼编码处理后的数组
     * 返回的是str对应的byte[]编码数组,8位对应一个byte
     */
    private static byte[] zip(byte[] bytes, Map<Byte,String> map){
        return null;
    }


    //生成赫夫曼树对应的赫夫曼编码
    //将赫夫曼编码表存放在Map<Byte,String>中
    static Map<Byte,String> stringMap = new HashMap<>();
    //在生成赫夫曼编码表时，定义一个StringBuilder，存放某个叶子节点的路径
    static StringBuilder stringBuilder = new StringBuilder();
    /**
     * 作用：将传入的node节点的所有叶子节点的赫夫曼编码，存放在StringMap中
     * @param node：传入的节点
     * @param code：路径上的值，左子节点全为0，右子节点全为1
     * @param sb：用于拼接路径上的值
     */
    public static void getCodes(HNode node, String code, StringBuilder sb){
        StringBuilder sb1 = new StringBuilder(sb);
        sb1.append(code);
        if (node!=null){
            //判断当前节点是叶子节点还是非叶子节点
            if (node.data==null){
                //向左递归
                getCodes(node.left,"0", sb1);
                //向右递归
                getCodes(node.right,"1",sb1);
            }else {
                //找到叶子节点
                stringMap.put(node.data,sb1.toString());
            }
        }
    }

    //前序遍历方法
    public static void PreOrder(HNode node){
        if (node!=null){
            node.PreOrder();
        }else
            System.out.println("哈夫曼树为空！！");
    }
    /**
     *
     * @param bytes：接收字节数组，转成HNode对象
     * @return 输出HNode节点的List
     * 结果无错
     */
    private static List<HNode> getHNode(byte[] bytes){
        //创建ArrayList<HNode>
        Map<Byte,Integer> map = new HashMap<Byte,Integer>();
        List<HNode> list = new ArrayList<HNode>();
        for (byte b:bytes){
            Integer count = map.get(b);
            if (count == null){//判断map中是否存在，若不存在，则添加，存在，则在此基础上加1
                map.put(b,1);
            }else
                map.put(b, count+1);
        }
        //把每个键值对转换成HNode对象，加入到map中
        //遍历map
        for (Map.Entry<Byte,Integer> entry:map.entrySet()){
            list.add(new HNode(entry.getKey(),entry.getValue()));//创建HNode对象
        }
        return list;
    }
    //2.构造赫夫曼树
    public static HNode HuffmanCode(List<HNode> nodes){
        while (nodes.size()>1){
            Collections.sort(nodes);//排序不可避免，必须进行排序
            HNode left = nodes.get(0);
            HNode right = nodes.get(1);
            HNode newTree = new HNode(null,left.weight+right.weight);
            newTree.left = left;
            newTree.right = right;

            nodes.remove(left);
            nodes.remove(right);

            nodes.add(newTree);

        }
        return nodes.get(0);
    }
}

//1、创建带权值的Node
class HNode implements Comparable<HNode>{
    Byte data;//存放数据(字符)本身,存放字符
    int weight;//权值，字符出现的次数
    HNode left;
    HNode right;

    public HNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "HNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(HNode o) {
        //从小到大进行排序
        return this.weight-o.weight;
    }

    //前序遍历
    public void PreOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.PreOrder();
        }
        if (this.right!=null){
            this.right.PreOrder();
        }
    }
}
