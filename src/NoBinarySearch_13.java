public class NoBinarySearch_13 {
    public static void main(String[] args) {
        int [] s = {1,3,8,10,11,67,100};
        int lin = NoSearch(s,3);
        System.out.println(lin);
    }
    //二分查找非递归

    /**
     * @param s：待查找的数组
     * @param tag：待查找的数
     * @return：未找到：-1，找到：返回下标
     */
    public static int NoSearch(int [] s, int tag){
        int left = 0;
        int right = s.length-1;
        while (left<=right){
            int center = (left+right)/2;
            if (s[center]==tag){
                return center;
            }else if (s[center]>tag){
                right = center-1;//向左边查找
            }else
                left = center+1;
        }
        return -1;
    }
}
