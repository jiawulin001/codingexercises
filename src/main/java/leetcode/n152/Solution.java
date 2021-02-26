package leetcode.n152;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        //int[] nums = {-2, 3, -4};
        //int[] nums = {-2, -3, -9, 6};
        int[] nums = {2, 3, -2, 4};
        System.out.println(s.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int curMin = nums[0];
        int curMax = nums[0];
        int maxValue = nums[0];

        int tempMin, tempMax;

        for (int i = 1; i < nums.length; i++) {
            tempMax = curMax * nums[i];
            tempMin = curMin * nums[i];
            curMax = Math.max(Math.max(tempMax, tempMin), nums[i]);
            curMin = Math.min(Math.min(tempMax, tempMin), nums[i]);
            maxValue = Math.max(curMax, maxValue);
        }
        return maxValue;
    }

}