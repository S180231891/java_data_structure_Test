public class Binary_Sort_Tree_11 {
    public static void main(String[] args) {
        Bianry_Tree tree = new Bianry_Tree();

        int [] s = {7,3,10,12,5,1,9,2,8};
        for (int a: s){
            tree.Add(new TNode(a));
        }
        System.out.println("中序遍历二叉树：");
        tree.Min();
        System.out.println("删除有一颗子树的节点后：");
        tree.DelNode(7);

        tree.Min();//只剩头节点
    }

}
class Bianry_Tree{
    private TNode root;


    public void Add(TNode node){
        if (root==null){
            root = node;
        }
        else
            root.add(node);
    }
    //查找删除的节点
    public TNode Search(int value){
        if (root==null){
            System.out.println("Tree Null");
            return null;
        }else
            return root.Search(value);
    }

    //查找删除节点的父节点
    public TNode SearchParent(int value){
        if (root==null){
            return null;
        }else
            return root.SearchParent(value);
    }

    //编写方法
    //1、返回以node为节点的二叉排序树的最小节点的值
    //2、删除node为根节点的二叉排序树的最小节点
    public int delRightTreeMin(TNode node){
        TNode temp = node;
        //循环查找左节点，寻找最小值
        while(temp.left!=null){
                temp = temp.left;
        }
        //删除最小节点
        DelNode(temp.data);
        return temp.data;
    }
    public int delRightTreeMax(TNode node){
        TNode temp = node;
        //循环查找右节点，寻找最大值
        while(temp.right!=null){
            temp = temp.right;
        }
        //删除最大节点
        DelNode(temp.data);
        return temp.data;
    }

    //删除节点
    public void DelNode(int value){
        if (root==null){
            return;
        } else {
            //先找到删除节点
            TNode search = root.Search(value);
            if (search==null){
                return;
            }
            //若该树只有一个节点，直接删除
            if (root.left==null && root.right==null && root.data == search.data){
                root=null;
                return;
            }
            TNode searchParent = root.SearchParent(value);
            //若待删除的节点是叶子节点
            if (search.left==null && search.right==null){
                //判断该节点是父节点的左、右节点
                if (searchParent.left!=null && searchParent.left.data ==search.data){
                    searchParent.left = null;
                }else if (searchParent.right!=null && searchParent.right.data==search.data){
                    searchParent.right =null;
                }

            }
            //若待删除的节点有一颗子树
                //待删除的节点是父节点的左孩子
            if (searchParent!=null) {
                if (searchParent.left != null && searchParent.left.data == search.data) {
                    //带删除的节点有只有左孩子
                    if (search.left != null && search.right == null) {
                        search.data = search.left.data;
                        search.left = null;
                    } else if (search.right != null && search.left == null) {
                        //待删除的节点有只有右孩子
                        search.data = search.right.data;
                        search.right = null;
                    }
                    //待删除的节点是父节点的右孩子
                }
            }else
                root =search.left;
            if (searchParent!=null) {
                if (searchParent.right != null && searchParent.right.data == search.data) {
                    //待删除的节点有只有左孩子
                    if (search.left != null && search.right == null) {
                        search.data = search.left.data;
                        search.left = null;
                    } else if (search.right != null && search.left == null) {
                        //待删除的节点有只有右孩子
                        search.data = search.right.data;
                        search.right = null;
                    }
                }
            }else
                root = search.right;
            if (search.left!=null&&search.right!=null){
                int max = delRightTreeMax(search);
                search.data = max;
            }
        }

    }


    public void Min(){
        if (root!=null){
            root.MinOrder();
        }else
            System.out.println("空树，无法遍历");
    }
}
class TNode{
    @Override
    public String toString() {
        return "TNode{" +
                "data=" + data +
                '}';
    }

    int data;
    TNode left;
    TNode right;

    public TNode(int data) {
        this.data = data;
    }

    public void add(TNode node){
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
    }

    //查找待删除的节点

    /**
     *
     * @param value：删除节点的值
     * @return：若存在，返回节点，否则null
     */
    public TNode Search(int value){
        if (value == this.data) {
            return this;
        }else if (value<this.data) {
            if (this.left == null)
                return null;
            return this.left.Search(value);
        }else{
            if (this.right == null)
                return null;
            return this.right.Search(value);
        }
    }

    //查找待删除节点的父节点
    public TNode SearchParent(int value){
        if (this.left!=null&&this.left.data == value || this.right!=null&&this.right.data == value){
            return this;
        }else{
            //若查找的值小于当前值，且当前节点的左子节点不为空，左递归
            if (value<this.data&& this.left!=null){
                return this.left.SearchParent(value);
            }else if (value>=this.data&& this.right!=null){
                return this.right.SearchParent(value);
            }else
                return null;
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
