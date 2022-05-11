package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/***
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * 416. 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class N416 {
    public static void main(String[] args) {
        N416 test = new N416();
        test.canPartition(new int[]{1, 5, 11, 5});
    }

    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int avg = IntStream.of(nums).sum();

        if (avg % 2 != 0) {
            return false;
        }
        avg = avg / 2;

        for (int i = nums.length - 1; i >= 0; i--) {

        }


        return false;
    }

    private boolean check(int[] nums, int index, int target) {
        return false;
    }
}
