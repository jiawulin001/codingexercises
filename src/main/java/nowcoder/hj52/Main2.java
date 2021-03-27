package nowcoder.hj52;

import java.util.Scanner;


public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1, str2;

        //字符串A: abcdefg
        //字符串B: abcdef
        while (in.hasNext()) {
            str1 = in.nextLine();
            str2 = in.nextLine();
            System.out.println(calc(str1, str2));
        }
    }

    private static int calc(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        //第二个单词长度为零时，那就是全删除或者全插入
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        //第一个单词长度为零时，那就是全删除或者全插入
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
