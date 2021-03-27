package od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main19 {


    /**
     * <h1>水仙花数</h1>
     * 水仙花数是指一个n位的正整数，其各位数字的n次方和等于该数本身，例如:<br>
     * 153是一个3位数<br>
     * 153 = 1^3 + 5^3 + 3^3<br>
     *
     * <h2>输入描述：</h2>
     * 第一行输入一个整数n,表示一个n位正整数，n在3到7之间，包含3和7<br>
     * 第二行输入一个正整数，表示需要返回第m个水仙花数。<br>
     * <h2>输出描述：</h2>
     * 返回长度是n的第m个水仙花数，个数冲0开始编写。<br>
     * 若m大于水仙花数的个数，返回最后一个水仙花数和m的乘积。<br>
     * 若输入不合法，返回-1<br>
     *
     * <h2>示例1：</h2>
     * <h3>输入</h3>
     * 3 0
     * <h3>输出：</h3>
     * 153
     */
    public static void main(String[] args) {
        String input = "3 0";
        //main3(args);
        //main4(args);

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            System.out.println(getNumber(in.nextInt(), in.nextInt()));
        }
    }

    public static int getNumber(int n, int index) {
        int[] range = {-1, -1, -1, 100, 1000, 10000, 100000, 1000000, 10000000};
        List<Integer> number = new ArrayList<>();

        int sum = 0;
        for (int i = range[n]; i < range[n + 1]; i++) {
            sum = 0;
            for (int j = 1; j <= range[n]; j *= 10) {
                sum += Math.pow(i / j % 10, n);
                if (sum > range[n + 1]) {
                    break;
                }
            }

            if (sum == i) {
                number.add(i);
            }

            if (number.size() - 1 == index) {
                return i;
            }
        }

        if (!number.isEmpty()) {
            return number.get(number.size() - 1) * n;
        }

        return -1;
    }

    public static void main3(String[] args) {
        int n = 3;
        int sum = 0;
        int num1, num2, num3;
        for (int i = 0; i < 10; i++) {
            num1 = (int) Math.pow(i, 3);
            if (num1 > 999) {
                continue;
            }

            for (int j = 0; j < 10; j++) {
                num2 = (int) Math.pow(j, 3);
                if (num2 > 999) {
                    continue;
                }

                for (int k = 0; k < 10; k++) {
                    num3 = (int) Math.pow(k, 3);
                    if (num3 > 999) {
                        continue;
                    }

                    sum = num1 + num2 + num3;
                    if (sum < 99 && sum > 999) {
                        continue;
                    }
                    if (sum == Integer.parseInt(i + "" + j + "" + k)) {
                        System.out.println(sum);
                    }
                }
            }
        }
    }

    public static void main4(String[] args) {
        int sum = 0;
        int num1, num2, num3, num4;
        for (int i = 0; i < 10; i++) {
            num1 = (int) Math.pow(i, 4);
            if (num1 > 9999) {
                continue;
            }

            for (int j = 0; j < 10; j++) {
                num2 = (int) Math.pow(j, 4);
                if (num2 > 9999) {
                    continue;
                }

                for (int k = 0; k < 10; k++) {
                    num3 = (int) Math.pow(k, 4);
                    if (num3 > 9999) {
                        continue;
                    }


                    for (int l = 0; l < 10; l++) {
                        num4 = (int) Math.pow(l, 4);
                        if (num4 > 9999) {
                            continue;
                        }

                        sum = num1 + num2 + num3 + num4;
                        if (sum < 999 && sum > 9999) {
                            continue;
                        }
                        if (sum == Integer.parseInt(i + "" + j + "" + k + "" + l)) {
                            System.out.println(sum);
                        }
                    }
                }
            }
        }
    }
}

