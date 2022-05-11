package leetcodeday;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/
 * 433. 最小基因变化
 */
public class Day20220507 {
    public static void main(String[] args) {
        Day20220507 test = new Day20220507();
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        System.out.println(1 == test.minMutation(start, end, bank));

        start = "AACCGGTT";
        end = "AAACGGTA";
        bank = new String[]{"AACCGATT", "AACCGATA", "AAACGATA", "AAACGGTA"};
        System.out.println(4 == test.minMutation(start, end, bank));

        start = "AACCGGTT";
        end = "AAACGGTA";
        bank = new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.println(2 == test.minMutation(start, end, bank));

        start = "AAAAACCC";
        end = "AACCCCCC";
        bank = new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        System.out.println(3 == test.minMutation(start, end, bank));
    }

    public int minMutation(String start, String end, String[] bank) {


        Set<String> bankSet = new HashSet<>();
        Set<String> visited = new HashSet<>();

        for (String s : bank) {
            bankSet.add(s);
        }

        if (!bankSet.contains(end)) {
            return -1;
        }

        LinkedList<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        int count = 1;
        char[] str;
        int length;
        String tempStr;
        char[] chars = {'A', 'C', 'G', 'T'};
        char currChar;
        while (!queue.isEmpty()) {
            length = queue.size();
            for (int i = 0; i < length; i++) {
                str = queue.poll().toCharArray();
                for (int j = 0; j < str.length; j++) {
                    currChar = str[j];
                    for (char c : chars) {
                        if (c == currChar) {
                            continue;
                        }
                        str[j] = c;
                        tempStr = new String(str);

                        if (tempStr.equals(end)) {
                            return count;
                        }

                        if (bankSet.contains(tempStr) && !visited.contains(tempStr)) {
                            queue.add(tempStr);
                            visited.add(tempStr);
                        }
                    }
                    str[j] = currChar;
                }
            }
            count++;
        }
        return -1;
    }

    /**
     * 自己做的，解答错误，我的解答是期望每次突变都和最终更相近一位，但用例里面存在先突变到其他字符串，在慢慢变回最终的，所以无法全部通过
     */
    public int minMutation1(String start, String end, String[] bank) {
        if (!Arrays.stream(bank).anyMatch(str -> str.equals(end))) {
            return -1;
        }

        int count = Integer.MAX_VALUE;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == end.charAt(i)) {
                continue;
            }

            count = Math.min(mutation(start, end, bank, i), count);
        }


        return count == Integer.MAX_VALUE ? -1 : count;
    }

    private int mutation(String start, String end, String[] bank, int i) {
        char[] temp = start.toCharArray();
        temp[i] = end.charAt(i);
        String tempStr = new String(temp);
        int count = 1;
        if (!Arrays.stream(bank).anyMatch(str -> str.equals(tempStr))) {
            return Integer.MAX_VALUE;
        } else if (tempStr.equals(end)) {
            return 1;
        } else {
            for (int j = 0; j < tempStr.length(); j++) {
                if (tempStr.charAt(j) == end.charAt(j)) {
                    continue;
                }
                count = mutation(new String(temp), end, bank, j);
                if (1 == count) {
                    break;
                }
            }
        }
        return count + 1;
    }


}
