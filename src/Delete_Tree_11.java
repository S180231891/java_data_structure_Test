public class Delete_Tree_11 {
    public static void main(String[] args) {
        BiyTree biyTree = new BiyTree();
        Tree root = new Tree(1, "宋江");
        Tree node2 = new Tree(2, "卢俊义");
        Tree node3 = new Tree(3, "无用");
        Tree node4 = new Tree(4, "林冲");
        Tree node5 = new Tree(5, "关圣");
        //先手动创建二叉树，后面在学习递归创建
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        biyTree.setTree(root);
        System.out.println("删除节点前:");
        biyTree.PreOrder();
        biyTree.Delete(3);
        System.out.println("删除节点后:");
        biyTree.PreOrder();

    }
}
//定义树
class Tree{
    private int no;
    private String name;
    private Tree left;
    private Tree right;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public Tree(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tree{" +
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

    //pre_delete
    public void Pre_Delete(int no){
        if (this.left!=null && this.left.no==no){
            this.left = null;//
            return;
        }
        if (this.right!=null && this.right.no==no){
            this.right = null;
            return;
        }
        if (this.left!=null){
            this.left.Pre_Delete(no);
        }
        if (this.right!=null){
            this.right.Pre_Delete(no);
        }
    }
}

class BiyTree{
    private Tree tree;

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }
    //前序遍历
    public void PreOrder(){
        if (tree!=null){
            this.tree.pre_Tree();
        }else
            System.out.println("当前二叉树为空，无法遍历");
    }

    public void Delete(int no){
        if (tree!=null){
            if (tree.getNo()==no){
                tree=null;
            }else
                tree.Pre_Delete(no);
        }else
            System.out.println("空树，无法删除节点");
    }

}