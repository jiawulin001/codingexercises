package leetcodeday;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/number-of-lines-to-write-string/
 * 806. 写字符串需要的行数
 */
public class Day20220412 {

    public static void main(String[] args) {
        int[] widths = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                10, 10, 10};
        String s = "abcdefghijklmnopqrstuvwxyz";

        Day20220412 test = new Day20220412();
        System.out.println(Arrays.equals(test.numberOfLines(widths, s), new int[]{3, 60}));

        widths = new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                10, 10, 10};
        s = "bbbcccdddaaa";
        System.out.println(Arrays.equals(test.numberOfLines(widths, s), new int[]{2, 4}));
    }


    public int[] numberOfLines(int[] widths, String s) {
        int maxWidths = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += widths[s.charAt(i) - 'a'];
            if (count > 100) {
                maxWidths += 100;
                count = widths[s.charAt(i) - 'a'];
            } else if (count == 100) {
                maxWidths += 100;
                count = 0;
            }
        }

        maxWidths += count;

        int[] result = new int[]{maxWidths / 100, maxWidths % 100};

        if (result[1] != 0) {
            result[0] += 1;
        } else {
            result[1] = 100;
        }
        return result;
    }
}
