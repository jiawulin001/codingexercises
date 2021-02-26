package nowcoder.hj2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bread = new BufferedReader(new InputStreamReader(System.in))) {
            String str;
            while ((str = bread.readLine()) != null) {
                System.out.println(count(str, bread.readLine().charAt(0)));
            }
        }
    }

    public static void main1(String[] args) {
        for (int i = 0; i <= 26; i++) {
            System.out.printf("%c -> %c \n", i + 65, (char) i + 65 + 32);
        }
    }


    private static int count1(String str, char chr) {
        int count = 0;

        if (chr >= 'A' && chr <= 'Z') {
            chr += 32;
        }

        char chr2;
        for (int i = 0; i < str.length(); i++) {
            chr2 = str.charAt(i);
            if (chr2 >= 'A' && chr2 <= 'Z') {
                chr2 += 32;
            }

            if (chr == chr2) {
                count++;
            }
        }

        return count;
    }

    private static int count(String str, char chr) {
        if (chr >= 'A' && chr <= 'Z') {
            chr += 32;
        }

        str = str.toLowerCase();
        str = str.replaceAll("[^" + chr + "]", "");
        return str.length();
    }
}
