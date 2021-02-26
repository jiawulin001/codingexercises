package oj.n69;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] input = new String[2];
        while (s.hasNext()) {
            input = s.nextLine().split(" ");
            System.out.println(isEquals(input[0], input[1]));
        }
    }


    private static String isEquals(String str1, String str2) {
        if (str1.equals(str2)) {
            return "YES";
        }

        String[] str1s = str1.split("\\.");
        String[] str2s = str2.split("\\.");

        if (str1s.length == 1 && str2s.length == 1) {
            return "NO";
        }

        if (!str1s[0].equals(str2s[0])) {
            return "NO";
        }

        if (str1s.length == 1 && str2s.length == 2 && "".equals(str2s[1].replaceAll("0*$", ""))) {
            return "YES";
        }

        if (str1s.length == 2 && str2s.length == 1 && "".equals(str1s[1].replaceAll("0*$", ""))) {
            return "YES";
        }

        if (str1s.length == 2 && str2s.length == 2 && (str1s[1].replaceAll("0*$", "")).equals(str2s[1].replaceAll("0*$", ""))) {
            return "YES";
        }

        return "NO";
    }


    private static String isEquals2(String str1, String str2) {
        BigDecimal b1 = new BigDecimal(str1);
        BigDecimal b2 = new BigDecimal(str2);

        return b1.compareTo(b2) == 0 ? "YES" : "NO";
    }
}
