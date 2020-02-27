public class Threaded_Binary_Tree_11 {
    public static void main(String[] args) {
        T_HeroNode root = new T_HeroNode(1, "a");
        T_HeroNode n2 = new T_HeroNode(3, "b");
        T_HeroNode n3 = new T_HeroNode(6, "c");
        T_HeroNode n4 = new T_HeroNode(8, "d");
        T_HeroNode n5 = new T_HeroNode(10, "e");
        T_HeroNode n6 = new T_HeroNode(14, "f");

        //创建二叉树
        root.setLeft(n2);
        root.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        //中序线索化测试
        T_BinaryTree tree = new T_BinaryTree();
        tree.setRoot(root);
        tree.threadTree();
        //进行测试
        T_HeroNode leftNode = n2.getLeft();
        T_HeroNode rightNode = n2.getRight();
        System.out.println(leftNode);
        System.out.println(rightNode);

        System.out.println("线索化方式遍历线索二叉树：");
        tree.threadTreeList();



    }
}
//创建节点
class T_HeroNode{
    private int no;
    private String name;
    private T_HeroNode left;//默认为null
    private T_HeroNode right;
    //type值有0、1两种，进行线索化节点和子树的区分
    // 0：表示指向子树；
    //1：表示指向线索化节点
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public T_HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeft(T_HeroNode left) {
        this.left = left;
    }

    public void setRight(T_HeroNode right) {
        this.right = right;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public T_HeroNode getLeft() {
        return left;
    }

    public T_HeroNode getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void pre_Tree(){
        System.out.println(this);//输出父节点
        if (this.left!=null){
            this.left.pre_Tree();
        }
        if (this.right!=null){
            this.right.pre_Tree();
        }
    }

    //中序遍历
    public void MiddleOrder_Tree(){
        if (this.left!=null){
            this.left.MiddleOrder_Tree();
        }
        System.out.println(this);//输出父节点
        if (this.right!=null){
            this.right.MiddleOrder_Tree();
        }
    }

    //后序遍历
    public void PostOrder_Tree(){
        if (this.left!=null){
            this.left.PostOrder_Tree();
        }
        if (this.right!=null){
            this.right.PostOrder_Tree();
        }
        System.out.println(this);//输出父节点
    }
}


//中序线索化二叉树
class T_BinaryTree{
    private T_HeroNode root;
    //创建指向当前节点的前驱节点指针
    //在线索化时，始终指向当前节点的前一个节点
    private T_HeroNode pre=null;
    //创建指向当前节点的后继节点指针
    private T_HeroNode next=null;


    public T_HeroNode getRoot() {
        return root;
    }

    public void setRoot(T_HeroNode root) {
        this.root = root;
    }

    public void threadTree(){
        this.threadTree(root);
    }

    //TODO：遍历中序线索化二叉树
    public void threadTreeList(){
        //定义变量，存储当前的节点，从root开始
        T_HeroNode node = root;
        while (node!=null){
            //循环找到leftType值为1的节点
            while (node.getLeftType()==0){
                node = node.getLeft();
            }
            //打印当前的节点
            System.out.println(node);
            //若当前节点的右子针指向的是后继节点，就一直输出
            while (node.getRightType()==1){
                node = node.getRight();
                System.out.println(node);
            }
            //替换遍历的节点
            node = node.getRight();
        }
    }

    //TODO：编写中序线索化的方法
    public void threadTree(T_HeroNode node){
        if (node==null){
            return;
        }
        //线索化左子树
        threadTree(node.getLeft());
        //线索化当前节点[重点]
            //1.先处理当前节点的前驱节点
        if (node.getLeft()==null){
            //使得当前节点的左指针指向前驱节点
            node.setLeft(pre);
            //修改当前左指针的类型，表示指向前驱
            node.setLeftType(1);

        }
            //处理后继节点
        if (pre!=null && pre.getRight()==null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        //线索化右子树
        threadTree(node.getRight());
    }

    //前序遍历
    public void PreOrder(){
        if (root!=null){
            this.root.pre_Tree();
        }else
            System.out.println("当前二叉树为空，无法遍历");
    }

    //中序遍历
    public void MidOrder(){
        if (root!=null){
            this.root.MiddleOrder_Tree();
        }else
            System.out.println("当前二叉树为空，无法遍历");
    }

    //后序遍历
    public void PosOrder(){
        if (root!=null){
            this.root.PostOrder_Tree();
        }else
            System.out.println("当前二叉树为空，无法遍历");
    }
}