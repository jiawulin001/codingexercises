package nowcoder.hj6;

import java.util.Scanner;

public class Main {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        StringBuffer factor = new StringBuffer();

        boolean flag = false;
        for (int i = 2; i < number / 2 + 1; i++) {
            if (number % i == 0) {
                flag = true;
                for (int j = 2; j < i / 2 + 1; j++) {
                    if (i % j == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    factor.append(i);
                    factor.append(" ");
                }
            }
        }
        if (factor.length() == 0) {
            System.out.println(number + " ");
        } else {
            System.out.println(factor);
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int length = (int) Math.sqrt(number);
        StringBuffer sb = new StringBuffer();
        //因为奇数第一个质数是3，偶数第一个质数是2
        for (int i = 2; i <= length; i++) {
            while (number % i == 0) {
                sb.append(i);
                sb.append(" ");
                number /= i;
            }
        }

        //number是除积，所以除尽了就是1
        if (number != 1) {
            sb.append(number);
            sb.append(" ");
        }
        System.out.println(sb);
    }

}
