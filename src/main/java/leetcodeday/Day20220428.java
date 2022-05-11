package leetcodeday;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-array-by-parity/
 * 905. 按奇偶排序数组
 */
public class Day20220428 {

    public static void main(String[] args) {
        Day20220428 test = new Day20220428();
        int[] result = test.sortArrayByParity(new int[]{3, 1, 2, 4});
        System.out.println(Arrays.equals(result, new int[]{4, 2, 1, 3}));


        result = test.sortArrayByParity(new int[]{0});
        System.out.println(Arrays.equals(result, new int[]{0}));

    }

    /**
     * 自己做的双指针+原地交换
     *
     * @param nums
     * @return
     */
    public int[] sortArrayByParity(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int temp;
        while (l < r) {
            if (nums[l] % 2 == 1) {
                temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                r--;
            } else {
                l++;
            }

            if (nums[r] % 2 == 0) {
                temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                l++;
            } else {
                r--;
            }
        }
        return nums;
    }
}
