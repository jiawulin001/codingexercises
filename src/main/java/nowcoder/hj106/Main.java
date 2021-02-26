package nowcoder.hj106;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            reverseString(in.nextLine());
        }
    }

    private static void reverseString2(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
        System.out.println();
    }

    private static void reverseString(String str) {
        char[] strs = str.toCharArray();
        for (int i = strs.length - 1; i >= 0; i--) {
            System.out.print(strs[i]);
        }
        System.out.println();
    }
}
