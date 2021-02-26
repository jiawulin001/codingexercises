package nowcoder.hj1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bread = new BufferedReader(new InputStreamReader(System.in))) {
            String str;
            String[] strs;
            while ((str = bread.readLine()) != null) {
                strs = str.split(" ");
                System.out.println(strs[strs.length - 1].length());
            }
        }
    }
}
