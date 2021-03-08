package nowcoder.hj93;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int length;
        Scanner in = new Scanner(System.in);
        List<Integer> numbers;
        List<Integer> numbers5;
        List<Integer> numbers3;
        int sum5, sum3, sum;
        int num;

        while (in.hasNext()) {
            sum = 0;
            sum5 = 0;
            sum3 = 0;
            length = in.nextInt();
            numbers = new ArrayList<>(length);
            numbers5 = new ArrayList<>(length);
            numbers3 = new ArrayList<>(length);

            for (int i = 0; i < length; i++) {
                num = in.nextInt();
                if (num % 5 == 0) {
                    numbers5.add(num);
                    sum5 += num;
                } else if (num % 3 == 0) {
                    numbers3.add(num);
                    sum3 += num;
                } else {
                    numbers.add(num);
                }
                sum += num;
            }

            if (sum5 > sum3) {
                num = sum5 - sum3;
            } else {
                num = sum3 - sum5;
            }

            if (num > sum - sum5 - sum3) {

            }

        }
    }

}
