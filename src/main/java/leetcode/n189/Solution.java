package leetcode.n189;

import java.util.Arrays;

/**
 * nums = "----->-->"; k =3
 * result = "-->----->";
 * <p>
 * reverse "----->-->" we can get "<--<-----"
 * reverse "<--" we can get "--><-----"
 * reverse "<-----" we can get "-->----->"
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] r = new int[]{-1, -100, 3, 99};
        s.rotate(r, 2);
        System.out.println(Arrays.equals(r, new int[]{3, 99, -1, -100}));

        System.out.println(s.getIndex(3, 2, 0));
        System.out.println(s.getIndex(3, 2, 1));
        System.out.println(s.getIndex(3, 2, 2));
        System.out.println(s.getIndex(3, 2, 3));
    }

    //翻转法
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        reverse(nums, 0, length - 1);
        reverse(nums, 0, k % length - 1);
        reverse(nums, k % length, length - 1);
    }

    private void reverse(int[] nums, int begin, int end) {
        int val;
        while (begin < end) {
            val = nums[end];
            nums[end] = nums[begin];
            nums[begin] = val;
            end--;
            begin++;
        }
    }

    // 非空间复杂度O(1)，数组拷贝
    // -1, -100, 3, 99      3, 99, -1, -100
    public void rotate1(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[getIndex(nums.length - 1, k, i)] = nums[i];
        }

        System.arraycopy(result, 0, nums, 0, result.length);
    }

    private int getIndex(int maxIndex, int step, int currIndex) {
        return (currIndex + step) % maxIndex;
    }
}
