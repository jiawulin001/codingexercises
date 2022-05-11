package leetcode.n283;

import java.util.Arrays;

public class Solution {
    //[0,1,0,3,12]

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{2, 1};
        s.moveZeroes(nums);
        System.out.println(Arrays.equals(nums, new int[]{1, 3, 12, 0, 0}));
    }

    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 1;
        int temp;
        while (j < nums.length && i < nums.length) {
            if (i < j && nums[i] == 0 && nums[j] != 0) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            } else if (nums[j] == 0) {
                j++;
            } else if (nums[i] != 0) {
                i++;
            } else {
                j++;
            }
        }
    }
}
