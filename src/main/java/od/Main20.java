package od;

import java.util.Scanner;

public class Main20 {

    /**
     * <h1>矩阵最大值</h1>
     * 给定一个仅包含0和1的N*N二维矩阵，请计算二维矩阵最大值，计算规则如下：<br>
     * <li>每行元素按下标顺序组成一个二进制数（下标越大约排在低位），二进制数的值为该行的值。矩阵各行值之和为矩阵的值。</li>
     * <li>允许通过向左或向右整体循环移动每行元素改变各元素在行中的位置</li>
     * 比如：[1,0,1,1,1]向右整体移动2位为[1,1,1,0,1],值为29.<br>
     * [1,0,1,1,1]向左整体移动2位为[1,1,1,1,0],值为30.<br>
     *
     * <h2>输入描述</h2>
     * <li>输入第一行为正整数，记录N的大小，0 < N <= 20 </li>
     * <li>输入的第2到N+1行为矩阵信息，行内元素边角逗号分隔</li>
     *
     * <h2>输出描述</h2>
     * 矩阵的最大值<br>
     *
     * <h2>示例1：</h2>
     * <h3>输入</h3>
     * 5<br>
     * 1，0，0，0，1<br>
     * 0，0，0，1，1<br>
     * 0，1，0，1，0<br>
     * 1，0，0，1，1<br>
     * 1，0，1，0，1<br>
     * <h3>输出</h3>
     * 122
     */
    public static void main(String[] args) {
        String input = "5\n1,0,0,0,1\n0,0,0,1,1\n0,1,0,1,0\n1,0,0,1,1\n1,0,1,0,1";
        Scanner in = new Scanner(input);

        int n;
        char[][] matrix;
        String[] strs;
        while (in.hasNext()) {
            n = in.nextInt();
            in.nextLine();
            matrix = new char[n][n];
            for (int i = 0; i < n; i++) {
                strs = in.nextLine().split(",");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = strs[j].charAt(0);
                }
            }
            System.out.println(sum(matrix));
        }
    }

    private static int sum(char[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += getMaxNum(matrix[i]);
        }
        return sum;
    }

    public static int getMaxNum(char[] nums) {
        int max = Integer.parseInt(new String(nums), 2);
        String str;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == '1') {
                str = new String(nums, i, nums.length - i) + new String(nums, 0, i);
                max = Math.max(Integer.parseInt(str, 2), max);
            }
        }
        return max;
    }


    public static void main2(String[] args) {
        int n1 = Integer.parseInt("10001", 2);
        int n2 = Integer.parseInt("00011", 2);
        int n3 = Integer.parseInt("01010", 2);
        int n4 = Integer.parseInt("10011", 2);
        int n5 = Integer.parseInt("10101", 2);
        System.out.println(n1 + n2 + n3 + n4 + n5);
        n1 = Integer.parseInt("11000", 2); //右1
        n2 = Integer.parseInt("11000", 2); //右2
        n3 = Integer.parseInt("10100", 2); //左1
        n4 = Integer.parseInt("11100", 2); //右2
        n5 = Integer.parseInt("11010", 2); //右1

        System.out.println(n1 + n2 + n3 + n4 + n5);
    }
}

