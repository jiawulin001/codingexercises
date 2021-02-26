package nowcoder.hj5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bread = new BufferedReader(new InputStreamReader(System.in))) {
            String str;
            while ((str = bread.readLine()) != null) {
                System.out.println(hexToTen(str));
            }
        }
    }

    private static int hexToTen1(String hex) {
        return Integer.valueOf(hex.substring(2), 16);
    }

    private static int hexToTen(String hex) {

        int result = 0;

        int length = hex.length();
        for (int i = 2; i < length; i++) {
            if (hex.charAt(i) <= 'A') {
                result += (16 - ('G' - hex.charAt(i))) * Math.pow(16, length - i - 1);
            } else {
                // result += Integer.valueOf(hex.charAt(i) + "") * Math.pow(16, length - i - 1);
                result += (hex.charAt(i) - 48) * Math.pow(16, length - i - 1);
            }
        }
        return result;
    }
}
