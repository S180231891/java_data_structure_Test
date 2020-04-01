package LeetCode;

import java.util.Arrays;

/**
 * TODO：合并两个有序整数数组
 * 初始化元素num1和num2的元素数量分别为m、n
 * 假设num1有足够大的空间保存num2
 */
public class zbg_088
{
    public static void main(String[] args) {

    }
}
// 从小到大顺序排列
class zbg_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m+n];
        int i=0;
        int j=0;
        int t=0;
        while (i<m && j<n){
            if (nums1[i]<nums2[j]){
                temp[t++] = nums1[i++];
            }else {
                temp[t++] = nums2[j++];
            }
        }
        while (i<m) {
            temp[t++] = nums1[i++];
        }
        while (j<n) {
            temp[t++] = nums2[j++];
        }
        for (i=0;i<temp.length;i++)
            nums1[i] = temp[i];
    }

    /**
     * TODO：使用双指针法进行排序
     * TODO：System.arraycopy(a,b,c,d,e)将一个数组的某一段字节数据放入另一个数组中
     * 参数a：原数组
     * 参数b：原数组要复制的起始位置
     * 参数c：目的数组
     * 参数d: 目的数组放置的起始位置
     * 参数e：复制的长度
     */
    public void Merge(int[] nums1, int m, int[] nums2, int n) {
        int [] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while ((p1 < m) && (p2 < n))
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
        if (p1 < m)
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }

    /**
     * 方法三：先合并，在进行排序
     * System.arraycopy(nums2, 0, nums1, m, n);
     * Arrays.sort(nums1);
     */
}
