package leetcode.n179;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3, 4, 3, 4, 3, 4, 3, 4, 3, 4};
        Solution s = new Solution();

        System.out.println(s.largestNumber(nums));
        s.testSort();
    }

    public String largestNumber(int[] nums) {
        boolean isAllZero = true;

        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = nums[i] + "";
            if (isAllZero && nums[i] != 0) {
                isAllZero = false;
            }
        }

        if (isAllZero) {
            return "0";
        }

        Arrays.sort(strs, (str1, str2) -> {
            return (str2 + str1).compareTo(str1 + str2);
        });

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }


    private void testSort() {
        Integer[] nums = {12, 125, 42123, 8412, 6, 1, 8512, 3, 3231, 82};

        Arrays.sort(nums, (n1, n2) -> -Integer.compare(n2 + n1, n1 + n2));

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
    }
}