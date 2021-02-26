package leetcode.n121;

public class Solution {


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 1, 5, 2, 9, 4};
        int[] prices3 = {7, 2, 6, 1, 8, 4};

        System.out.println(s.maxProfit(prices));
        System.out.println(s.maxProfit(prices2));
        System.out.println(s.maxProfit(prices3));

    }

    public int maxProfit1(int[] prices) {
        int maxIncome = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxIncome = Math.max(maxIncome, prices[j] - prices[i]);
            }
        }
        return maxIncome;
    }

    public int maxProfit2(int[] prices) {

        int minPrices = prices[0];
        int maxIncome = 0;
        for (int i = 1; i < prices.length; i++) {
            minPrices = Math.min(minPrices, prices[i]);
            maxIncome = Math.max(maxIncome, prices[i] - minPrices);
        }
        return maxIncome;
    }

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