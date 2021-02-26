package nowcoder.hj61;

import java.util.Scanner;


/**
 * <b>题目描述</b>
 * 把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。
 * <p>
 * 数据范围：0<=m<=10，1<=n<=10。
 * 本题含有多组样例输入。
 */


public class Main {
    public static void main1(String[] args) {
        System.out.print("输入M个苹果：");
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        System.out.print("输入N个盘子：");
        int N = scanner.nextInt();
        for (int i = 1; i <= Math.min(M, N); i++) {
            deep(M, i, "", 1);
            System.out.println();
        }
    }


    /**
     * 递归,打印分配过程
     *
     * @param remain 剩余个数
     * @param num    分几次
     * @param print  打印前缀
     * @param start  开始值
     */
    public static void deep(int remain, int num, String print, int start) {

        /**
         * remain个苹果有num种分法，边界条件是num=1,结束当前分法，加上remain>=start是为了去重（前面的分法已经覆盖）
         * 主要思想：M个苹果有num种分法，确定第一个个数X1，剩下M-X1个和num-1种分法依然符合上述的思想，可以继续递归至
         * 次数为1，当前这个分法结束。
         */
        if (num == 1 && remain >= start) {
            System.out.print(print + remain);
            System.out.print(" & ");
            return;
        }
        /**
         * j为什么要从start开始？
         * 因为 2_1_7 和 1_2_7是等效的，后者在操作的时候已经涵盖了前者的情况
         */
        for (int j = start; j <= remain - start; j++) {
            int num1 = num - 1;
            String print1 = print + j + "_";
            deep(remain - j, num1, print1, j);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(deep(m, n));
            System.out.println(deep2(m, n));
            System.out.println(dp(m, n));
        }
    }


    //1.有苹果、没盘子 0方法
    //2.有盘子、没苹果1方法
    //3.1个盘子，不管有没有苹果1方法
    //4.1个苹果，一个方法
    private static int dp(int m, int n) {
        int[][] result = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            result[i][1] = 1;
        }

        for (int i = 1; i <= n; i++) {
            result[0][i] = 1;
            result[1][i] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i < j) {
                    result[i][j] = result[i][i];
                } else {
                    result[i][j] = result[i - j][j] + result[i][j - 1];
                }
            }
        }

        return result[m][n];
    }

    //递归
    private static int deep(int m, int n) {
        if (n == 0) { //没有盘子
            return 0;
        } else if (m <= 1 || n == 1) { //有盘子，没有苹果，或者只有一个苹果
            return 1;
        } else if (n > m) { //苹果数量大于盘子
            return deep(m, m);
        } else {
            return deep(m - n, n) + deep(m, n - 1);
        }
    }


    //网上别人的代码
    //https://www.cnblogs.com/wxgblogs/p/5742618.html
    private static int deep2(int m, int n) {
        if (m == 0 || n == 1) {
            return 1;
        }

        if (n > m) {
            return deep2(m, m);
        } else {
            int count = deep2(m - n, n) + deep2(m, n - 1);
            //System.out.printf("%d %d:%d \n", m, n, count);
            return count;
        }
    }
}
