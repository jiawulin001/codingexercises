package nowcoder.hj91;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            System.out.println(fn(in.nextInt(), in.nextInt()));
        }
    }


    private static int fn(int n, int m) {
        int[][] table = new int[n + 1][m + 1];
        table[n][m] = 1;
        for (int i = n; i >= 0; i--) {
            for (int j = m; j >= 0; j--) {
                if (i < n) {//向下
                    table[i][j] += table[i + 1][j];
                }
                if (j < m) {//向右
                    table[i][j] += table[i][j + 1];
                }
            }
        }
        return table[0][0];
    }
}
