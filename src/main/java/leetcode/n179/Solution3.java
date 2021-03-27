package leetcode.n179;

import java.util.LinkedHashSet;
import java.util.Set;

public class Solution3 {
    public static void main(String[] args) {
        int[] nums = {3,4,3,4,3,4,3,4,3,4};
        Solution3 s = new Solution3();

        System.out.println(s.largestNumber(nums));
    }

    public String largestNumber(int[] nums) {
        Set<String> result = new LinkedHashSet<>(nums.length * nums.length);
        int[] flag = new int[nums.length];
        int max = '0';

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, (nums[i] + "").charAt(0));
        }


        getStringArray(nums, flag, 0, "", result, max);

        return result.stream().sorted((str1, str2) -> {

            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) == str2.charAt(i)) {
                    continue;
                } else {
                    return str2.charAt(i) - str1.charAt(i);
                }
            }
            return 1;
        }).toArray()[0].toString();

    }

    private void getStringArray(int[] nums, int[] flag, int i, String str, Set<String> result, int max) {
        boolean isEnd = true;
        if (str.length() > 0 && str.charAt(0) != max) {
            return;
        }

        for (int j = 0; j < flag.length; j++) {
            if (flag[j] == 0) {
                isEnd = false;
                break;
            }
        }

        if (isEnd) {
            result.add(str);
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (flag[j] == 0) {
                flag[j] = 1;
                getStringArray(nums, flag, j, str + nums[j], result, max);
                flag[j] = 0;
            }
        }
    }
}