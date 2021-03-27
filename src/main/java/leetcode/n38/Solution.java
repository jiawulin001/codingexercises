package leetcode.n38;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    //https://leetcode-cn.com/problems/count-and-say/

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countAndSay(6));
    }

    public String countAndSay(int n) {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("1");
        list.add("11");
        list.add("21");
        list.add("1211");
        list.add("111221");
        String str;
        int count = 0;
        Character chr;

        String displayStr;
        for (int i = 6; i <= n; i++) {
            displayStr = "";
            str = list.get(i - 1);
            chr = str.charAt(0);
            count = 1;
            for (int j = 1; j < str.length(); j++) {
                if (chr == str.charAt(j)) {
                    count++;
                } else {
                    displayStr = displayStr + count + chr;
                    chr = str.charAt(j);
                    count = 1;
                }
            }
            displayStr = displayStr + count + chr;
            list.add(displayStr);
        }

        return list.get(n);
    }
}