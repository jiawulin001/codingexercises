package leetcode.fib;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.IntFunction;
import java.util.stream.Stream;

public class bb {

    public static void main1(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        //int[] nums = {7, 6, 4, 3, 1};
        int val = -nums[0];

        int min = Integer.MAX_VALUE;
        int ml = 0;
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(nums[i],min);
            ml = Math.max(ml,nums[i] - min);
        }
        System.out.println(ml);
        int[][] dp = new int[nums.length][2];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], nums[i] - dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][1], nums[i] - nums[i - 1]);
        }


        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(nums[j] - nums[i], max);
            }
        }


        System.out.println(max);

    }


    public static void main3(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        int len = prices.length;
        // 特殊判断
        if (len < 2) {
            System.out.println(0);
        }
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 从第 2 天开始遍历
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], prices[i] + dp[i - 1][1] );
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);

        }
        // return dp[len - 1][0];
        System.out.println(dp[len - 1][0]);
    }

    public static void main(String[] args) {
        LinkedHashMap<Integer,Integer> hashMap = new LinkedHashMap<>(16,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > 5;
            }
        };

        for (int i = 0; i < 10; i++) {
            hashMap.put(i,i);
        }

        hashMap.get(6);

        System.out.println(hashMap.keySet());
    }
}
