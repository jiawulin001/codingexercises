package leetcode.n209;

public class Solution {


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(s.minSubArrayLen(7, nums));
    }

    public int minSubArrayLen1(int s, int[] nums) {
        int minSize = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            if (sum >= s) {
                return 1;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    minSize = Math.min(minSize, j - i + 1);
                    break;
                }
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }


    public int minSubArrayLen(int s, int[] nums) {

        int minSize = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0, j = 0;

        while (true) {
            if (sum >= s) {
                minSize = Math.min(minSize, i - j);
                sum = sum - nums[j];
                j++;

                continue;
            } else if (i >= nums.length) {
                break;
            }
            sum += nums[i];
            i++;
        }

        return minSize == Integer.MAX_VALUE ? 0 : minSize;

    }
}
