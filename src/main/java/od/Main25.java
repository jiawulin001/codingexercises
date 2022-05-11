package od;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 */
public class Main25 {
    public static void main(String[] args) {
        String s = "aaaaaaaaaaaabcdefghijklmnopqrstuvwzyz";
        int k = 3;
        Main25 m = new Main25();
        System.out.println(m.longestSubstring(s, k));
    }


    public int longestSubstring(String s, int k) {
        List<String> subStrings = new ArrayList<>();
        split(subStrings, s, k);
        int max = 0;
        for (int i = 0; i < subStrings.size(); i++) {
            max = Math.max(max, subStrings.get(i).length());
        }

        return max;
    }

    public void split(List<String> subStrings, String s, int k) {
        int[] count = new int[123];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)] += 1;
        }

        String[] strs;
        boolean flag = true;
        for (int i = 97; i < 123; i++) {
            if (count[i] > 0 && count[i] < k) {
                flag = false;
                strs = s.split(String.valueOf((char) i));
                for (int j = 0; j < strs.length; j++) {
                    if (strs[j].length() >= k) {
                        split(subStrings, strs[j], k);
                    }
                }
                return;
            }
        }

        if (flag) {
            subStrings.add(s);
        }
    }


    public int longestSubstring3(String s, int k) {
        int[] count = new int[123];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)] += 1;
        }

        List<String> subStrings = new ArrayList<>();
        subStrings.add(s);
        for (int i = 97; i < 123; i++) {
            if (count[i] > 0 && count[i] < k) {
                splitString(subStrings, ((char) i) + "", k);
            }
        }


        int max = 0;
        count = new int[123];
        int length;
        for (int i = 0; i < subStrings.size(); i++) {
            count = new int[123];
            length = subStrings.get(i).length();
            for (int j = 0; j < length; j++) {
                count[subStrings.get(i).charAt(j)] += 1;
            }

            for (int j = 97; j < count.length; j++) {
                if (count[j] != 0 && count[j] < k) {
                    length = 0;
                    break;
                }
            }

            max = Math.max(max, length);
        }
        return max;
    }

    private void splitString(List<String> subStrings, String chr, int k) {

        String[] strs;
        for (int i = 0; i < subStrings.size(); i++) {
            strs = subStrings.get(i).split(chr);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() >= k) {
                    if (i < subStrings.size()) {
                        subStrings.set(i, strs[j]);
                    } else {
                        subStrings.add(strs[j]);
                    }
                    i++;
                }
            }
        }
    }

    public int longestSubstring2(String s, int k) {
        int[] count = new int[122];
        int[] currCount = new int[122];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)] += 1;
        }

        //97
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)] >= k) {
                currCount[s.charAt(i)] += 1;
            }

        }


        return 0;
    }
}

