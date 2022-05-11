package leetcodeday;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/di-string-match/
 * 942. 增减字符串匹配
 */
public class Day20220509 {


    public static void main(String[] args) {
        Day20220509 test = new Day20220509();
        System.out.println(Arrays.equals(test.diStringMatch("IDID"), new int[]{0, 4, 1, 3, 2}));
        System.out.println(Arrays.equals(test.diStringMatch("III"), new int[]{0, 1, 2, 3}));
        System.out.println(Arrays.equals(test.diStringMatch("DDI"), new int[]{3, 2, 0, 1}));
    }

    public int[] diStringMatch(String s) {
        int[] result = new int[s.length() + 1];

        LinkedList<Integer> nums = new LinkedList();
        for (int i = 0; i < result.length; i++) {
            nums.add(i);
        }

        int i = 1;
        result[0] = s.charAt(0) == 'I' ? nums.pollFirst() : nums.pollLast();
        for (; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                result[i] = nums.pollFirst();
            } else {
                result[i] = nums.pollLast();
            }
        }
        result[i] = nums.poll();
        return result;
    }
}
