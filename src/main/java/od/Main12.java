package od;

import java.util.Scanner;

public class Main12 {

    /**
     * <h1>数组连续和</h1>
     * 给定一个含有N个正整数的数组，求出有多少个连续区间（包括单个正整数），他们的和大于等于X
     *
     * <h2>输入描述：</h2>
     * <li>第一行两个整数N和X (0 < N <= 100000,0 <= X<= 10000000) </li>
     * <li>第二行有N个正整数（每个正整数小于等于100）</li>
     *
     * <h2>输出描述：</h2>
     * 输出一个正整数，表示所求的个数
     *
     * <h2>示例1：</h2>
     * <h3>输入</h3>
     * 3 7<br>
     * 3 4 7<br>
     * <h3>输出</h3>
     * 4
     */
    public static void main(String[] args) {
        String input = "3 7\n3 4 7";
        Scanner in = new Scanner(input);

        int[] numbers;
        int n, x;
        while (in.hasNext()) {
            n = in.nextInt();
            x = in.nextInt();
            numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = in.nextInt();
            }

            System.out.println(count(numbers, x));
        }
    }

    private static int count(int[] numbers, int x) {
        int count = 0;
        int sum;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= x) {
                count++;
            }
            sum = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                sum += numbers[j];
                if (sum >= x) {
                    count++;
                }
            }
        }
        return count;
    }
}

