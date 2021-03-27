package leetcode.n1442;

public class Solution {

    public static void main(String[] args) {
        String str = "1111";
        Solution s = new Solution();
        System.out.println(s.maxScore(str));
    }

    public int maxScore(String s) {
        int left = 0, right = 0;

        if (s.charAt(0) == '0') {
            left = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                right += 1;
            }
        }


        int max = left + right;

        //0 11101
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                left += 1;
            } else {
                right -= 1;
            }
            max = Math.max(max, left + right);
        }

        return max;
    }
}