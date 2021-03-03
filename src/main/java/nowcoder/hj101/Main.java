package nowcoder.hj101;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        Integer[] numbers;
        StringBuffer sb;
        while (in.hasNext()) {
            n = in.nextInt();
            numbers = new Integer[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = in.nextInt();
            }
            boolean isDesc = in.nextInt() == 0 ? false : true;

            Arrays.sort(numbers, (num1, num2) -> {
                if (isDesc) {
                    return Integer.compare(num2, num1);
                }
                return Integer.compare(num1, num2);
            });

            sb = new StringBuffer();
            for (int i = 0; i < numbers.length; i++) {
                sb.append(numbers[i]);
                sb.append(" ");
            }
            sb.delete(sb.length() - 1, sb.length());
            System.out.println(sb);
        }
    }
}