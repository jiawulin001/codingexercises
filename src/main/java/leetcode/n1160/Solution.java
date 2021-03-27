package leetcode.n1160;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = {"hello", "world", "leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(s.countCharacters(words, chars));
    }

    public int countCharacters(String[] words, String chars) {
        int[] charCount = new int[123];
        for (int i = 0; i < chars.length(); i++) {
            charCount[chars.charAt(i)] += 1;
        }

        int sum = 0;
        boolean isOk;
        int[] count;
        for (int i = 0; i < words.length; i++) {
            isOk = true;
            count = Arrays.copyOf(charCount, charCount.length);
            for (int j = 0; j < words[i].length(); j++) {
                if (count[words[i].charAt(j)] == 0) {
                    isOk = false;
                    break;
                } else {
                    count[words[i].charAt(j)] -= 1;
                }
            }
            if (isOk) {
                sum += words[i].length();
            }
        }

        return sum;
    }
}