package LeetCode;
//搜索插入位置
public class zbg_035 {
    public static void main(String[] args) {
        int[] nums = {2,4,6,8,10};
        int a = 7;
        zbg_35 text = new zbg_35();
        System.out.println(text.searchInsert(nums,a));
    }
}
class zbg_35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
