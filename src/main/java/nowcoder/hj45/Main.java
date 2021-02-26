package nowcoder.hj45;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int[] count;
        char c;
        int max, result, fraction, index = 0, length;
        while ((str = in.readLine()) != null) {
            length = Integer.parseInt(str);
            for (int j = 0; j < length; j++) {
                str = in.readLine();
                count = new int[26];
                max = 0;
                fraction = 26;
                result = 0;
                for (int i = 0; i < str.length(); i++) {
                    c = str.charAt(i);
                    if (c >= 'a' && c <= 'z') {
                        index = c - 65 - 32;
                        count[index] += 1;
                    } else if (c >= 'A' && c <= 'Z') {
                        index = c - 65;
                        count[index] += 1;
                    }
                    max = Math.max(max, count[index]);
                }

                while (max > 0) {
                    for (int i = 0; i < count.length; i++) {
                        if (count[i] == max) {
                            result += fraction * max;
                            fraction--;
                        }
                    }
                    max--;
                }
                System.out.println(result);
            }
        }
    }
}
