package nowcoder.hj56;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int count = in.nextInt();
            System.out.println(findNum(count));
        }
    }

    private static int findNum(int numCount) {
        List<Integer> array = new ArrayList<>();
        int sum, count = 0;

        for (int i = 6; i <= numCount; i++) {
            sum = 0;
            array = new ArrayList<>();
            for (int j = 1; j < (i / 2) + 1; j++) {
                if (i % j == 0) {
                    sum += j;
                    array.add(j);
                }

                if (sum > i) {
                    break;
                }
            }

            if (sum == i) {
                count++;
                array.add(i);
                print(array);

            }
        }

        return count;
    }


    private static void print(List<Integer> list) {
        list.forEach(i -> System.out.printf("%d \t", i));
        System.out.println();
    }
}
