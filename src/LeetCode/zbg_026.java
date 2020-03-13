package LeetCode;
//删除排序数组中的重复项
public class zbg_026 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,3,4,4,5,7};
        zbg_26 text = new zbg_26();
        int x = zbg_26.removeDuplicates(nums);
        System.out.println(x);
    }
}
//双指针法
class zbg_26 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length==0) return 0;
        int temp = 0;
        for (int i=1;i<nums.length;i++){
            if (nums[i]!=nums[temp]){
                temp++;
                nums[temp] = nums[i];
            }
        }
        return ++temp;
    }
}
