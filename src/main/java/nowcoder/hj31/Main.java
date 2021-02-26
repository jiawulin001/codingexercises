package nowcoder.hj31;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        int length = in.available();

        char[] strs = new char[length];
        char chr;
        int j = length - 1;
        for (int i = 0; i < length; i++) {
            chr = (char) in.read();
            if (chr >= 'A' && chr <= 'z') {
                strs[j] = chr;
                j--;
            } else if (j != length - 1 && strs[j + 1] >= 'A' && strs[j + 1] <= 'z') {
                strs[j] = ' ';
                j--;
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            if (strs[i] != 0) {
                sb.append(strs[i]);
            }
        }

        String[] strings = sb.reverse().toString().split(" ");
        sb = new StringBuffer();
        for (int i = strings.length - 1; i >= 0; i--) {
            sb.append(strings[i]);
            sb.append(" ");
        }
        sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb);
    }
}
