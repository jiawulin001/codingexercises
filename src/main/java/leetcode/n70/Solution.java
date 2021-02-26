package leetcode.n70;

public class Solution {

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * <p>
     * 注意：给定 n 是一个正整数。
     * <p>
     * 示例 1：
     * <p>
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     * 示例 2：
     * <p>
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     */
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.climbStairs(3));
    }


    //递归加记忆法
    //第N阶的楼梯到达的方法数是由  N-2和 N-1阶方法之和得到的，我们已知了1阶楼梯是1种方式，所以直接累加上去就可以了，这就是和斐波拉契数的解法一致了。
    public int climbStairs1(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;
        return fn(n, cache);
    }

    private int fn(int n, int[] cache) {
        if (cache[n] == 0) {
            cache[n] = fn(n - 2, cache) + fn(n - 1, cache);
        }
        return cache[n];
    }

    //由上面解法我们知道了是由前两个数字累加上去的，所以得到如下DP解法
    public int climbStairs2(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;

        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }

    //对上面解法进行空间复杂度的优化
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int preOneSum = 2;
        int preTwoSum = 1;
        int currSum = 3;

        for (int i = 2; i < n; i++) {
            currSum = preOneSum + preTwoSum;
            preTwoSum = preOneSum;
            preOneSum = currSum;
        }

        return currSum;
    }
}