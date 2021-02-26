package nowcoder.hj108;

import java.util.Scanner;


/**
 * <b>题目描述</b>
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 */


public class Main {


    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        int i = 0;
        while (true) {
            if ((number1 * ++i) % number2 == 0) {
                System.out.println(number1 * i);
                break;
            }
        }
    }

    /**
     * 两数最小公倍数等于两数乘积除以两数的最大公约数
     * <p>
     * 最大公约数 (greatest common divisor)，最大公约数记为（a，b）
     * <p>
     * 最小公倍数（Lowest Common Multiple），最小公倍数记为[a，b]
     *
     * <p>
     * 如果数a能被数b整除，a就叫做b的倍数，b就叫做a的约数。约数和倍数都表示一个整数与另一个整数的关系，不能单独存在。<br/>
     * 如只能说16是某数的倍数，2是某数的约数，而不能孤立地说16是倍数，2是约数
     * </P>
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();

        System.out.println(number1 * number2 / gcd(number1, number2));
    }


    /**
     * 求最大公约数：<b>辗转相除法</b><br/>
     * 1. a/b，令r为所得余数（0≤r<b） 若r=0，算法结束，a即为答案<br/>
     * 2. 互换：置 a←b，b←r，并返回第一步
     */
    private static int gcd(int a, int b) {
        System.out.printf("a:%d,b:%d\n", a, b);
        if (b == 0) return a;
        return gcd(b, a % b);
    }

}
