//Tree的三种查找方式：Pre，Mind，Post
//前序、中序、后序
public class Tree_11 {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "卢俊义");
        HeroNode node3 = new HeroNode(3, "无用");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关圣");
        //先手动创建二叉树，后面在学习递归创建
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        tree.setRoot(root);

        //前序遍历
        System.out.println("PreOrder: ");
        tree.PreOrder();
        //中序遍历
        System.out.println("MidOrder: ");
        tree.MidOrder();
        //后序遍历
        System.out.println("PostOrder: ");
        tree.PosOrder();
    }
}

//1、创建节点HeroNode节点(树的节点)
class HeroNode
{
    private int no;
    private String name;
    private HeroNode left;//默认为null
    private HeroNode right;//默认为null

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public HeroNode getRight() {
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

//创建树
class BinaryTree{
    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    private HeroNode root;

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

