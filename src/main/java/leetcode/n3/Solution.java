package leetcode.n3;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("au"));
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(s.lengthOfLongestSubstring("bbbbb"));
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
        System.out.println(s.lengthOfLongestSubstring(""));
    }

    public int lengthOfLongestSubstring(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }

        int maxSize = 1;

        Set<Character> set;
        for (int i = 0; i < s.length(); i++) {
            set = new HashSet<>();
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                } else {
                    break;
                }
            }
            maxSize = Math.max(set.size(), maxSize);
        }
        return maxSize;
    }
}


class Solution2 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.lengthOfLongestSubstring("abba"));
        System.out.println(s.lengthOfLongestSubstring("au"));
        System.out.println(s.lengthOfLongestSubstring("abcbcbb"));
        System.out.println(s.lengthOfLongestSubstring("bbbbb"));
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
        System.out.println(s.lengthOfLongestSubstring(""));
    }

    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[128];
        for (int i = 0; i < index.length; i++) {
            index[i]--;
        }

        int max = 0;
        int begin = 0;
        for (int i = 0; i < s.length(); i++) {
            begin = Math.max(begin,index[s.charAt(i)] + 1);
            max = Math.max(i - begin + 1, max);
            index[s.charAt(i)] = i;
        }

        return max;
    }
}
