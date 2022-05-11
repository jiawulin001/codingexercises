package leetcode.n704;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        s.search(nums, 2);
    }

    public int search(int[] nums, int target) {

        int lindex = 0;
        int rindex = nums.length;
        int mid;

        if(nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }

        while (lindex < rindex) {
            mid = (lindex + rindex) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                rindex = mid;
            } else {
                lindex = mid + 1;
            }
        }
        return -1;
    }
}
