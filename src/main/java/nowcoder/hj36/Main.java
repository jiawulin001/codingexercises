package nowcoder.hj36;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int[] key;
        int[] nums;
        char c;

        int index;
        while ((str = in.readLine()) != null) {
            index = 0;
            key = new int[26];
            nums = new int[26];
            for (int i = 0; i < str.length(); i++) {
                c = str.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    c = (char) (c - 32);
                }
                if (nums[c - 65] == 1) {
                    continue;
                }
                nums[c - 65] = 1;
                key[index] = c;
                index++;
            }

            for (int i = 0; i < 26; i++) {
                if (nums[i] != 1) {
                    key[index] = (char) (i + 65);
                    index++;
                }
            }

            str = in.readLine();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < str.length(); i++) {
                c = str.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    index = c - 32 - 65;
                    sb.append((char) (key[index] + 32));
                } else {
                    index = c - 65;
                    sb.append((char) (key[index]));
                }
            }
            System.out.println(sb);
        }
    }
}
