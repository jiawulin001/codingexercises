package nowcoder.hj4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main1(String[] args) throws IOException {
        try (InputStream in = System.in) {
            String str = "";
            char c;
            int length;
            while ((c = (char) in.read()) != 65535) {
                if (c == '\n') {
                    length = str.length();
                    for (int i = 0; i < 8 - length; i++) {
                        str += "0";
                    }
                    System.out.println(str);
                    str = "";
                } else if (str.length() == 8) {
                    System.out.println(str);
                    str = c + "";
                } else {
                    str += c;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bread = new BufferedReader(new InputStreamReader(System.in))) {
            String str;
            int length;
            while ((str = bread.readLine()) != null) {
                length = str.length();
                if (length <= 8) {
                    for (int i = 0; i < 8 - length; i++) {
                        str += "0";
                    }
                    System.out.println(str);
                } else {
                    for (int i = 0; length % 8 != 0 && i < 8 - length % 8; i++) {
                        str += "0";
                    }
                    length = str.length();
                    for (int i = 0; i < length / 8; i++) {
                        System.out.println(str.substring(i * 8, (i + 1) * 8));
                    }
                }
            }
        }
    }
}
