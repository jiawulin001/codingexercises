package leetcode.n179;

import java.util.LinkedHashSet;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        Solution2 s = new Solution2();

        System.out.println(s.largestNumber(nums));
    }

    public String largestNumber(int[] nums) {

        StringBuffer sb = new StringBuffer();
        for (int i = 9; i >= 0; i--) {
            sb.append(getNumbers(nums, i));
        }

        return sb.toString();
    }

    //3413
    //343
    // 3 313 331 34 344
    //9 91 98 911 988 919
    //9 98 988 91 919 911
    private String getNumbers(int[] nums, int n) {
        Set<String> numbers = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -99 && (nums[i] + "").charAt(0) == (n + "").charAt(0)) {
                numbers.add(nums[i] + "");
                nums[i] = -99;
            }
        }
        StringBuffer sb = new StringBuffer();
        numbers.stream().sorted((str1, str2) -> {
            int length = Math.min(str1.length(), str2.length());
            int result = 0;

            for (int i = 0; i < length; i++) {
                if (str1.charAt(i) > str2.charAt(i)) {
                    result = -1;
                } else if (str1.charAt(i) < str2.charAt(i)) {
                    result = 1;
                } else {
                    continue;
                }
                break;
            }

            if (result == 0) {
                result = str1.length() < str2.length() ? -1 : 1;
            }
            return result;
        }).forEach(str -> {
            sb.append(str + " ");
        });
        return sb.toString();
    }
}