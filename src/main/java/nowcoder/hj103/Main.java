package nowcoder.hj103;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length;
        int max;
        int[] numbs;
        int[] dp;

        while (in.hasNext()) {
            length = in.nextInt();
            numbs = new int[length];
            max = 0;
            dp = new int[length];
            for (int i = 0; i < length; i++) {
                numbs[i] = in.nextInt();
            }

            for (int i = 0; i < numbs.length; i++) {
                max = Math.max(count(i, numbs, dp), max);
            }
            System.out.println(max);
        }
    }


    private static int count(int index, int[] numbers, int[] dp) {
        if (index == numbers.length - 1) {
            return 1;
        }

        int max = 1;
        for (int i = index + 1; i < numbers.length; i++) {
            if (numbers[index] < numbers[i]) {
                if (dp[i] == 0) {
                    dp[i] = count(i, numbers, dp);
                }
                max = Math.max(1 + dp[i], max);
            }
        }

        return max;
    }
}





