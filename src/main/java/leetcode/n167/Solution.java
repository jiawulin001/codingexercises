package leetcode.n167;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = s.twoSum(new int[]{2, 3, 4}, 6);
        System.out.println(Arrays.equals(nums, new int[]{1, 3}));
    }

    public int[] twoSum1(int[] numbers, int target) {
        int[] result = new int[2];
        int l;
        int r;
        int mid;

        for (int k = 0; k < numbers.length; k++) {
            result[0] = numbers[k];
            result[1] = target - numbers[k];
            l = 0;
            r = numbers.length;
            while (l < r) {
                mid = (l + r) / 2;
                if (mid == k) {
                    l++;
                } else if (numbers[mid] == result[1]) {
                    return new int[]{k + 1, mid + 1};
                } else if (numbers[mid] < result[1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
        }

        return null;
    }

    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                return new int[]{l + 1, r + 1};
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return null;
    }
}
