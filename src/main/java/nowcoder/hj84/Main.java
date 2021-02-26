package nowcoder.hj84;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            countUppercaseLetter(in.nextLine());
        }
    }

    private static void countUppercaseLetter(String str) {
        String a = str.replaceAll("[^A-Z]", "");
        System.out.println(a.length());
    }
}
