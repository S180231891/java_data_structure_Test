import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Heap_Sorting_08 {
    //线性复杂度为O(nLog(n))
    public static void main(String[] args) {
        //数组升序排列
//        int [] arr = {4,6,8,5,9};
        int [] arr = new int[8000000];
        for (int i=0;i<arr.length;i++){
            arr[i] = (int) (Math.random()*8000000);
        }
        Date date1= new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String format1 = simpleDateFormat1.format(date1);
        Heap(arr);
        Date date2= new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String format2 = simpleDateFormat2.format(date2);
        System.out.println(format1);
        System.out.println(format2);
    }
    //堆排序
    public static void Heap(int [] arr){
        //最终代码
            //大顶堆构造完成
        for (int i = arr.length/2-1;i>=0;i--){
            JustHeap(arr,i,arr.length);
        }
        //System.out.println(Arrays.toString(arr));//大顶堆输出结果
        //末尾与头进行交换
        for (int j = arr.length-1;j>0;j--){
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            JustHeap(arr,0,j);//交换的数组不在参与遍历，已经是最大的数组
            //System.out.println(Arrays.toString(arr));//(堆排序得到的结果)
        }

    }
    //将数组调整为大顶推

    /**
     *完成将以 i 对应的非叶子节点的树构造成大顶堆
     * @param arr:待调整数组
     * @param i：表示非叶子节点在数组中的索引
     * @param len：对len个元素进行调整
     *
     * TODO：遍历时遵循从左至右、从下到上的原则
     */
    public static void JustHeap(int [] arr, int i, int len){
        int temp = arr[i];//最后一个非叶子节点
        //开始调整
        //调整i节点的左子节点，以及其左子节点的左子节点。。。。。。
        //for循环结束后，已将最大节点放在了以i为父节点的树的最顶上(此处的i不一定是root，只是局部)
        for (int k=i*2+1;k<len; k = k*2+1){
            //若左子节点小于右子节点
            if (k+1<len&& arr[k]<arr[k+1]){
                k++;
            }
            if (arr[k]>temp){
                arr[i] = arr[k];//将较大的值赋值给当前节点
                i = k;//将i指向k，继续循环比较(可能还存在左、右子节点)
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp的值放在调整后的位置

    }
}
