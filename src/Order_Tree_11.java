public class Order_Tree_11 {
    public static void main(String[] args) {
        int [] s = {1,2,3,4,5,6,7};
        ArrayTree arrayTree = new ArrayTree(s);
        arrayTree.PreOrder(0);
    }
}

class ArrayTree{
    private int [] arr;//存储数据节点的数组

    public ArrayTree(int[] arr) {
        this.arr = arr;
    }

    //编写顺序存储二叉树的前序遍历
    //index：数组下标
    public void PreOrder(int index){
        if (arr==null || arr.length==0){
            System.out.println("数组为空，不能进行遍历");
        }
        System.out.printf("当前插入的元素为：%d\n",arr[index]);
        //向左递归遍历
        if ((index*2+1)<arr.length){
            PreOrder(2*index+1);
        }
        if ((index*2+2)<arr.length){
            PreOrder(2*index+2);
        }
    }
}
