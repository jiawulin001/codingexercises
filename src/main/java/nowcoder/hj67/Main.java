package nowcoder.hj67;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            Double[] numbers = {in.nextDouble(), in.nextDouble(), in.nextDouble(), in.nextDouble()};
            // 3 + 9 - 4 * 3
            // 9 - 3 / 2 * 8
            List<Double[]> numberList = getNumberList(numbers);
            boolean is24 = false;
            for (int i = 0; i < numberList.size(); i++) {
                numbers = numberList.get(i);
                if (calc(numbers, 1, numbers[0])) {
                    is24 = true;
                    break;

                }
            }

            System.out.println(is24);
        }
    }

    private static boolean calc(Double[] numbers, int i, Double val) {
        if (i == numbers.length) {
            return val == 24;
        }
        return calc(numbers, i + 1, val + numbers[i]) ||
                calc(numbers, i + 1, val - numbers[i]) ||
                calc(numbers, i + 1, val * numbers[i]) ||
                calc(numbers, i + 1, val / numbers[i]);
    }

    private static List<Double[]> getNumberList(Double[] numbers) {
        List<Double[]> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < numbers.length; k++) {
                    if (j == k || i == k) {
                        continue;
                    }
                    for (int l = 0; l < numbers.length; l++) {
                        if (k == l || j == l || i == l) {
                            continue;
                        }
                        list.add(new Double[]{numbers[i], numbers[j], numbers[k], numbers[l]});
                    }
                }
            }
        }
        return list;
    }

}
