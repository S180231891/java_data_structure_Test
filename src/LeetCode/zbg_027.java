package LeetCode;

public class zbg_027 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,3,4,4,5,7};
        int val=4;
        zbg_27 text = new zbg_27();
        int res = text.removeElement(nums,val);
        System.out.println(res);
    }
}
class zbg_27 {
    public int removeElement(int[] nums, int val) {
        int temp = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=val){
                nums[temp++] = nums[i];
            }
        }
        return temp;
    }

    //倒着删除，无序排列
    public int Remove(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}