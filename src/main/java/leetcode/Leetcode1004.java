package leetcode;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/max-consecutive-ones-iii/
 * 1004. 最大连续1的个数 III
 */

public class Leetcode1004 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1};
        Leetcode1004 test = new Leetcode1004();
        System.out.println(test.longestOnes(nums, 2) == 15);
        System.out.println(test.longestOnes2(nums, 2) == 15);
    }


    /**
     * 自己做的双指针滑窗
     */
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int maxCount = 0;
        LinkedList<Integer> zeroList = new LinkedList();
        while (r < nums.length) {
            if (nums[r] == 0) {
                zeroList.add(r);
                if (k == 0) {
                    maxCount = Math.max(maxCount, r - l);
                    l = zeroList.poll() + 1;
                } else {
                    k--;
                }
            }
            r++;
        }
        return Math.max(maxCount, r - l);
    }


    /**
     * 0305科目一专业级第一题
     * 案例开发中的一种解答，太经典了，以第一次满足要求的窗口做基数去滑动
     * 恩
     * 在k不小于0时，窗口一直扩张，当小于0以后调整l一起动，
     * 因为当前窗口就只能这么大，只有l边超过0，还回去k，r就可以继续动l不动的去继续扩张
     */
    public int longestOnes2(int[] nums, int k) {
        int len = nums.length;
        int l = 0;
        int r = 0;
        while (r < len) {
            if (nums[r++] == 0) {
                k--;
            }
            if (k < 0 && nums[l++] == 0) {
                k++;
            }
        }
        return r - l;
    }
}
