package leetcodeday;

/**
 * https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
 * 357. 统计各位数字都不同的数字个数
 * 给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。
 */
public class Day20220411 {
    public static void main(String[] args) {
        Day20220411 test = new Day20220411();
        for (int i = 0; i < 8; i++) {
            System.out.println(test.countNumbersWithUniqueDigits(i));
            System.out.println(test.countNumbersWithUniqueDigits2(i));
            System.out.println("---------------------");
        }

    }

    //回溯法
    public int countNumbersWithUniqueDigits2(int n) {
        int result = 1;
        result = backtracking(n, 0, 0, result);
        return result;
    }

    /**
     *
     * @param n
     * @param step
     * @param bitmask
     * @param result
     * @return
     */
    private int backtracking(int n, int step, int bitmask, int result) {
        if (n == step) {
            return result;
        }

        for (int i = 0; i < 10; i++) {
            if ((bitmask >> i & 1) == 1) {
                continue;
            }

            if (i != 0) {
                result += 1;
            }

            result = backtracking(n, step + 1, bitmask | 1 << i, result);
        }

        return result;
    }

    //排列组合
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int res = 10, cur = 9;
        for (int i = 0; i < n - 1; i++) {
            cur *= 9 - i;
            res += cur;
        }
        return res;
    }
}
