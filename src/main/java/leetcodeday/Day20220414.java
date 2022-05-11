package leetcodeday;


import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/richest-customer-wealth/
 * 1672. 最富有客户的资产总量
 */
public class Day20220414 {
    public static void main(String[] args) {
        Day20220414 test = new Day20220414();
        System.out.println(6 == test.maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}}));
        System.out.println(10 == test.maximumWealth(new int[][]{{1, 5}, {7, 3}, {3, 5}}));
    }

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            max = Math.max(Arrays.stream(account).sum(), max);
        }
        return max;
    }
}
