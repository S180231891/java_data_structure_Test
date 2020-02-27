public class Find_Tree_11 {
    //代码实现前中后序查找
    public static void main(String[] args) {
        BianryTree tree = new BianryTree();
        HeNo root = new HeNo(1, "宋江");
        HeNo node2 = new HeNo(2, "卢俊义");
        HeNo node3 = new HeNo(3, "无用");
        HeNo node4 = new HeNo(4, "林冲");
        HeNo node5 = new HeNo(5, "关圣");
        //先手动创建二叉树，后面在学习递归创建
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        tree.setRoot(root);

        //Mid
        HeNo res =tree.Mid(6);//判断是否找到该节点
        if (res!=null){
            System.out.println("找到该节点："+res);
        }else
            System.out.println("不存在");
    }
}
//1.定义节点
class HeNo{
    private int no;
    private String name;
    private HeNo left;
    private HeNo right;

    public HeNo(int no, String name) {
        this.no = no;
        this.name = name;
    }

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

    public HeNo getLeft() {
        return left;
    }

    public void setLeft(HeNo left) {
        this.left = left;
    }

    public HeNo getRight() {
        return right;
    }

    public void setRight(HeNo right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeNo{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
    //遍历查找:pre
    public HeNo Find_Pre(int no){
        System.out.println("进行前序查找");
        if (this.no == no){
            return this;
        }
        HeNo temp = null;
        if (this.left!=null){
            temp = this.left.Find_Pre(no);
        }
        if (temp!=null){
            return temp;
        }
        if (this.right!=null){
            temp = this.right.Find_Pre(no);
        }
        return temp;
    }
    //Mid
    public HeNo Find_Mid(int no){
        HeNo temp = null;
        if (this.left!=null){
            temp = this.left.Find_Mid(no);
        }
        if (temp!=null){
            return temp;
        }
        System.out.println("开始中序查找");
        if (this.no==no){
            return this;
        }
        if (this.right!=null){
            temp = this.right.Find_Mid(no);
        }
        return temp;
    }

    //Post
    public HeNo Find_Pos(int no){
        HeNo temp = null;
        if (this.left!=null){
            temp = this.left.Find_Pos(no);
        }
        if (temp!=null){
            return temp;
        }
        if (this.right!=null){
            temp = this.right.Find_Pos(no);
        }
        if (temp!=null){
            return temp;
        }
        System.out.println("进行后序查找");
        if (this.no==no){
            return this;
        }
        return temp;
    }
}

//2、定义树
class BianryTree{
    private HeNo root;

    public HeNo getRoot() {
        return root;
    }

    public void setRoot(HeNo root) {
        this.root = root;
    }
    //Pre
    public HeNo pre(int no){
        if (root!=null){
            return root.Find_Pre(no);
        }else
            return null;
    }

    //Mid
    public HeNo Mid(int no){
        if (root!=null){
            return root.Find_Mid(no);
        }else
            return null;
    }

    //Post
    public HeNo Post(int no){
        if (root!=null){
            return root.Find_Pos(no);
        }else
            return null;
    }
}

