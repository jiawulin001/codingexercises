package leetcodeday;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/rotate-function/
 * 396. 旋转函数
 */
public class Day20220422 {
    public static void main(String[] args) {
        Day20220422 test = new Day20220422();
        System.out.println(26 == test.maxRotateFunction(new int[]{4, 3, 2, 6}));
        System.out.println(0 == test.maxRotateFunction(new int[]{100}));
    }

    public int maxRotateFunction1(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i + j < nums.length) {
                    sum += j * nums[i + j];
                } else {
                    sum += j * nums[j + i - nums.length];
                }
            }
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }

    // 4	3	2	`-0index*length	0index

    public int maxRotateFunction(int[] nums) {
        int count = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += i * nums[i];
        }

        int result = sum;
        for (int i = nums.length - 1; i > 0; i--) {
            //上一次	-	上一次最后一位 * length - 1		* 	2	+	这一次第一位
            //sum = (sum - nums[i] * (nums.length - 1)) + (count - nums[i]);
            sum += count - nums.length * nums[i];
            result = Math.max(sum, result);
        }

        return result;
    }


}
