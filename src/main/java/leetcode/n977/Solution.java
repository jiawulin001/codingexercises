package leetcode.n977;

import java.util.Arrays;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] * nums[i];
        }
        Arrays.sort(result);
        return result;
    }
}

class TwoPointer {
    public static void main(String[] args) {
        TwoPointer s = new TwoPointer();
        int[] r = s.sortedSquares(new int[]{-4, -1, 0, 3, 10});
        System.out.println(Arrays.equals(r, new int[]{0, 1, 9, 16, 100}));
    }

    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        int[] result = new int[nums.length];
        for (int index = j; index >= 0; index--) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                result[index] = nums[i] * nums[i];
                i++;
            } else {
                result[index] = nums[j] * nums[j];
                j--;
            }
        }

        return result;
    }
}
