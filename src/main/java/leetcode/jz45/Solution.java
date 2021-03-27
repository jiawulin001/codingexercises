package leetcode.jz45;

import java.util.Arrays;

public class Solution {

    //https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0, 3, 30, 34, 5, 9};
        System.out.println(s.minNumber(nums));
    }

    public String minNumber(int[] nums) {
        StringBuffer sb = new StringBuffer();
        Arrays.stream(nums).boxed().map(String::valueOf).sorted((str1, str2) -> (str1 + str2).compareTo(str2 + str1)).forEach(sb::append);
        return sb.toString();
    }

}