package leetcode.fib;

public class aa {
    class Solution {
        public int maxProfit(int[] prices) {
            int minPrices = prices[0];
            int maxIncome = 0;
            int income;
            for (int i = 1; i < prices.length; i++) {
                if (minPrices > prices[i]) {
                    minPrices = prices[i];
                }
                income = prices[i] - minPrices;
                if (maxIncome < income) {
                    maxIncome = income;
                }
            }
            return maxIncome;
        }
    }
}
