package nowcoder.hj89;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Double[]> numbers;
        String result = "";
        while (in.hasNext()) {
            numbers = getNumbers(in.next(), in.next(), in.next(), in.next());

            if (numbers == null) {
                System.out.println("ERROR");
                continue;
            }

            for (int i = 0; i < numbers.size(); i++) {
                result = changeString(numbers.get(i)[0]);
                result = calc(numbers.get(i), numbers.get(i)[0], 1, result);
                if (null != result) {
                    break;
                }
            }
            System.out.println(null != result ? result : "NONE");
        }
    }

    private static String calc(Double[] numbers, Double val, int j, String result) {
        if (j == 4) {
            return val == 24 ? result : null;
        }
        String str;
        str = calc(numbers, val + numbers[j], j + 1, result + "+" + changeString(numbers[j]));
        if (null != str) return str;
        str = calc(numbers, val - numbers[j], j + 1, result + "-" + changeString(numbers[j]));
        if (null != str) return str;
        str = calc(numbers, val * numbers[j], j + 1, result + "*" + changeString(numbers[j]));
        if (null != str) return str;
        str = calc(numbers, val / numbers[j], j + 1, result + "/" + changeString(numbers[j]));
        return str;
    }

    private static List<Double[]> getNumbers(String p1, String p2, String p3, String p4) {
        if (p1.length() > 2 || p2.length() > 2 || p3.length() > 2 || p4.length() > 2) {
            return null;
        }
        Double[] num = {changeNumber(p1),
                changeNumber(p2),
                changeNumber(p3),
                changeNumber(p4)};
        List<Double[]> numbers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == i) continue;
                for (int k = 0; k < 4; k++) {
                    if (k == j || k == i) continue;
                    for (int l = 0; l < 4; l++) {
                        if (l == j || l == i || l == k) continue;
                        numbers.add(new Double[]{num[i], num[j], num[k], num[l]});
                    }
                }
            }
        }
        return numbers;
    }

    private static double changeNumber(String str) {
        if ("J".equals(str)) {
            return 11.0;
        } else if ("Q".equals(str)) {
            return 12.0;
        } else if ("K".equals(str)) {
            return 13.0;
        } else if ("A".equals(str)) {
            return 1.0;
        } else {
            return Double.valueOf(str);
        }
    }

    private static String changeString2(Double num) {
        if (num == 11.0) {
            return "J";
        } else if (num == 12.0) {
            return "Q";
        } else if (num == 13.0) {
            return "K";
        } else if (num == 1.0) {
            return "A";
        } else {
            return num.intValue() + "";
        }
    }

    private static String changeString(Double num) {
        if (num == 11.0) {
            return "J";
        } else if (num == 12.0) {
            return "Q";
        } else if (num == 13.0) {
            return "K";
        } else if (num == 1.0) {
            return "A";
        } else {
            return num.intValue() + "";
        }
    }
}