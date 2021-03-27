package od;

import java.util.Scanner;

public class Main15 {
    /**
     * <h1>N进制减法</h1>
     * 实现一个基于字符串的N进制的减法<br>
     * 需要对输入的两个字符串按照给定的N进制进行减法操作，输出正负符号和表示结果的字符串。<br>
     *
     * <h2>输入描述：</h2>
     * 输入：三个参数<br>
     * <li>第一个参数是整数形式的进制N值，N值范围为大于等于2、小于等于35</li>
     * <li>第二个参数为被减数字符串</li>
     * <li>第三个参数为减数字符串，有效的字符包括0~9以及小写字母a~z，字符串有效字符个数最大为100个字符，另外还有结尾的\0
     * 限制</li>
     * 输入的被减数和减法，除了单独的0以外，不能已0开头的字符串。<br>
     * 如果输入有异常或者计算过程中有异常，此时应当输出-1表示错误。<br>
     * <h2>输出描述：</h2>
     * 输出：2个
     * <li>第一个为减法计算的结果，-1表示出错，0表示结果为整数，1表示结果负数</li>
     * <li>第二个表示结果的字符串</li>
     * <h2>示例1：</h2>
     * <h3>输入</h3>
     * 2 11 1
     * <h3>输出</h3>
     * 0 10
     */
    public static void main(String[] args) {
        String input = "2 11 1";
        Scanner in = new Scanner(input);

        while (in.hasNext()) {
            System.out.println(calc(in.nextInt(), in.next(), in.next()));
        }


        //2 -> 10

        //11  == 1 + 2^1 + 1

        //5A == 5 * 16^1 + 10 = 90
        //90 == 90 / 16 = 5 与 10 == 5A

    }

    private static String calc(int n, String num1, String num2) {
        Integer val = Integer.parseInt(num1, n) - Integer.parseInt(num2, n);
        return Integer.toUnsignedString(val, n);
    }
}

