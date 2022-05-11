package leetcodeday;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/most-common-word/
 * 819. 最常见的单词
 */
public class Day20220417 {

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = new String[]{"hit"};
        Day20220417 test = new Day20220417();
        System.out.println("ball".equals(test.mostCommonWord(paragraph, banned)));

        System.out.println("ball".equals(test.mostCommonWord("Bob. hIt, baLl", new String[]{"bob", "hit"})));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[\\!|\\?|\\'|\\,|\\;|\\.]", " ");
        paragraph = paragraph.toLowerCase();
        String[] strs = paragraph.split(" ");
        HashMap<String, Integer> map = new HashMap();
        String result = "";
        int maxCount = 0;
        int count = 0;

        HashSet<String> bannedSet = new HashSet<>();
        for (String s : banned) {
            bannedSet.add(s);
        }

        for (String str : strs) {
            if ("".equals(str) || bannedSet.contains(str)) {
                continue;
            }

            count = map.getOrDefault(str, 0) + 1;
            map.put(str, count);

            if (count > maxCount) {
                maxCount = count;
                result = str;
            }
        }

        return result;
    }
}
