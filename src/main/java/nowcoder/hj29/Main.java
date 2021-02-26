package nowcoder.hj29;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = in.readLine()) != null) {
            System.out.println(encoding(line));
            System.out.println(decoding(in.readLine()));
        }
    }

    private static String encoding(String str) {
        char[] strs = str.toCharArray();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] >= 'a' && strs[i] <= 'z') {
                if (strs[i] == 'z') {
                    strs[i] = 'A';
                } else {
                    strs[i] = (char) (strs[i] + 1 - 32);
                }
            } else if (strs[i] >= 'A' && strs[i] <= 'Z') {
                if (strs[i] == 'Z') {
                    strs[i] = 'a';
                } else {
                    strs[i] = (char) (strs[i] + 1 + 32);
                }
            } else if (strs[i] >= '0' && strs[i] <= '9') {
                if (strs[i] == '9') {
                    strs[i] = '0';
                } else {
                    strs[i] = (char) (strs[i] + 1);
                }
            }
        }
        return new String(strs);
    }

    private static String decoding(String str) {
        char[] strs = str.toCharArray();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] >= 'a' && strs[i] <= 'z') {
                if (strs[i] == 'a') {
                    strs[i] = 'Z';
                } else {
                    strs[i] = (char) (strs[i] - 1 - 32);
                }
            } else if (strs[i] >= 'A' && strs[i] <= 'Z') {
                if (strs[i] == 'A') {
                    strs[i] = 'z';
                } else {
                    strs[i] = (char) (strs[i] - 1 + 32);
                }
            } else if (strs[i] >= '0' && strs[i] <= '9') {
                if (strs[i] == '0') {
                    strs[i] = '9';
                } else {
                    strs[i] = (char) (strs[i] - 1);
                }
            }
        }
        return new String(strs);
    }
}
