package leetcodeday;

import com.alibaba.fastjson.JSON;

/**
 * https://leetcode-cn.com/problems/shortest-distance-to-a-character/
 * 821. 字符的最短距离
 */
public class Day20220419 {
    public static void main(String[] args) {
        Day20220419 test = new Day20220419();
        System.out.println(JSON.toJSONString(test.shortestToChar("loveleetcode", 'e')));
        System.out.println(JSON.toJSONString(test.shortestToChar("aaba", 'b')));
        System.out.println(JSON.toJSONString(test.shortestToChar("abba", 'b')));
    }


    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        int beginIndex = s.indexOf(c);
        int endIndex = s.indexOf(c, beginIndex + 1);
        if (endIndex == -1) {
            for (int i = 0; i < result.length; i++) {
                result[i] = Math.abs(i - beginIndex);
            }
            return result;
        }

        for (int i = 0; i < beginIndex; i++) {
            result[i] = Math.abs(i - beginIndex);
        }

        int i = 1;
        while (endIndex != -1) {
            if ((endIndex - i) < (beginIndex + i)) {
                beginIndex = endIndex;
                endIndex = s.indexOf(c, beginIndex + 1);
                i = 1;
                continue;
            } else if ((endIndex - i) == (beginIndex + i)) {
                result[beginIndex + i] = i;
            } else {
                result[beginIndex + i] = i;
                result[endIndex - i] = i;
            }
            i++;
        }

        for (int j = beginIndex; j < result.length; j++) {
            result[j] = Math.abs(j - beginIndex);
        }
        return result;
    }
}
