//AVL树左右旋转
public class AVL_Tree_11 {
    public static void main(String[] args) {
        //int [] arr = {4,3,6,5,7,8};//左旋数列
        //int [] arr = {10,12,8,9,7,6};//右旋数列
        int [] arr = {10,11,7,6,8,9};//双螺旋
        AVL_Tree tree = new AVL_Tree();
        for (int i=0;i<arr.length;i++){
            tree.Add(new tNode(arr[i]));
        }
        System.out.println("中序遍历：");
        tree.Min();
        int h = tree.getRoot().height();
        System.out.println("节点的高度："+h);
        System.out.println("节点左子树的高度："+tree.getRoot().leftHeight());
        System.out.println("节点右子树的高度："+tree.getRoot().rightHeight());
//        System.out.println(tree.getRoot());

    }
}
class AVL_Tree{
    public tNode getRoot() {
        return root;
    }

    public void setRoot(tNode root) {
        this.root = root;
    }

    private tNode root;


    public void Add(tNode node){
        if (root==null){
            root = node;
        }
        else
            root.add(node);
    }
    public void Min(){
        if (root!=null){
            root.MinOrder();
        }else
            System.out.println("空树，无法遍历");
    }
}
class tNode{
    int data;
    tNode left;
    tNode right;

    @Override
    public String toString() {
        return "tNode{" +
                "data=" + data +
                '}';
    }

    public tNode(int data) {
        this.data = data;
    }

    //返回左子树的高度
    public int leftHeight(){
        if (left==null){
            return 0;
        }else
            return left.height();
    }
    //返回右子树的高度
    public int rightHeight(){
        if (right==null){
            return 0;
        }else
            return right.height();
    }
    //返回当前节点的高度
    public int height(){
        return Math.max(left == null ? 0:left.height(),right==null? 0:right.height())+1;
    }

    //左旋转方法：
    public void LeftRotate(){
        //创建新的节点
        tNode newNode = new tNode(data);
        //把新的节点的左子树设置成当前节点的左子树
        newNode.left = left;
        //把新的节点的右子树设置成当前节点的右子树的左子树
        newNode.right = right.left;
        //把当前节点的值替换成右子树的值
        data = right.data;
        //把当前节点的右子树设置成当前节点的右子树的右子树
        right =right.right;
        //把当前节点的左子树设置成新的节点
        left = newNode;
    }

    //右旋转方法
    private void RightRotate(){
        tNode NewNode = new tNode(data);
        NewNode.right = right;
        NewNode.left = left.right;
        data = left.data;
        left = left.left;
        right= NewNode;

    }


    public void add(tNode node){
        if (node == null)
            return;
        if (node.data<this.data){
            if (this.left==null){
                this.left= node;
            }else
                //递归操作
                this.left.add(node);
        }
        if (node.data>this.data){
            if (this.right==null){
                this.right = node;
            }else
                this.right.add(node);
        }
        //当添加完节点后，如果右子树的高度-左子树的高度>1,则进行左旋转
        if (rightHeight()-leftHeight()>1){
            // 节点右子树的左子树的高度大于节点左子树的高度,先右后左
            if (right!=null&& right.leftHeight()>right.rightHeight()){
                right.RightRotate();
                LeftRotate();
            }else
                LeftRotate();
            return;
        }

        if (leftHeight()-rightHeight()>1){
            // 节点左子树的右子树的高度大于节点左子树的高度,先左后右
            if (left!=null && left.rightHeight()>left.leftHeight()){
                left.LeftRotate();
                RightRotate();
            }else
            RightRotate();
        }

    }


    public void MinOrder(){
        if (this.left!=null){
            this.left.MinOrder();
        }
        System.out.println(this);
        if (this.right!=null){
            this.right.MinOrder();
        }
    }
}
