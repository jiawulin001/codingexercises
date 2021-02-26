package nowcoder.hj10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main1(String[] args) throws IOException {
        InputStream in = System.in;
        StringBuffer sb = new StringBuffer();
        int length = in.available();
        char chr;
        for (int i = 0; i < length; i++) {
            chr = (char) in.read();
            if (chr <= 127 && chr != '\n' && sb.indexOf(chr + "") == -1) {
                sb.append(chr);
            }
        }
        System.out.println(sb.length());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bread = new BufferedReader(new InputStreamReader(System.in));
        char[] strs = bread.readLine().toCharArray();
        int[] flag = new int[128];
        int count = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] <= 127 && flag[strs[i]] == 0) {
                count++;
                flag[strs[i]] = 1;
            }
        }
        System.out.println(count);
    }
}


