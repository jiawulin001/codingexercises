package nowcoder.hj76;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            formula(in.nextInt());
        }
    }

    private static void formula(int number) {
        int sum = 0;
        int product = (int) Math.pow(number, 3);
        int beginNum = product / number - ((number / 2) * 2);
        beginNum = beginNum % 2 == 0 ? beginNum - 1 : beginNum;

        while (true) {
            sum = ((beginNum + (beginNum + (number - 1) * 2)) * number) / 2;
            if (sum < product) {
                beginNum += 2;
            } else if (sum == product) {
                printResult(beginNum, beginNum + (number - 1) * 2);
                return;
            }
        }
    }

    private static void printResult(int beginNum, int endNum) {
        for (int i = beginNum; i < endNum; i = i + 2) {
            System.out.print(i + "+");
        }
        System.out.println(endNum);
    }
}
