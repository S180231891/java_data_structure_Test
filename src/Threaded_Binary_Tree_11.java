public class Threaded_Binary_Tree_11 {
    public static void main(String[] args) {

    }
}
class T_HeroNode{
    private int no;
    private String name;
    private HeroNode left;//默认为null
    private HeroNode right;

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