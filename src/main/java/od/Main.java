package od;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 */
public class Main {
    public static void main(String[] args) {
        String s = "aasssbadafddfaa";

        Character[] chars = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }

        int[] count = new int[123];
        for (int i = 0; i < chars.length; i++) {
            count[chars[i]] += 1;
        }

        Arrays.sort(chars, (c1, c2) -> {
            int sum = count[c1] - count[c2];
            if (sum == 0) {
                return c1 - c2;
            }
            return -sum;
        });

        System.out.println(JSON.toJSONString(chars));
    }
}

