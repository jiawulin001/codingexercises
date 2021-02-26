package nowcoder.hj40;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char c;
        int[] count = new int[4];
        StringBuffer sb;
        while ((c = (char) in.read()) != -1 && c != 65535) {
            if (c == '\r' || c == '\n') {
                sb = new StringBuffer();
                sb.append(count[0]);
                sb.append("\n");
                sb.append(count[1]);
                sb.append("\n");
                sb.append(count[2]);
                sb.append("\n");
                sb.append(count[3]);
                count = new int[4];
                System.out.println(sb);
                continue;
            }

            if ((c >= 'a' && c <= 'z') || (c >= 'a' && c <= 'z')) {
                count[0] += 1;
            } else if (c == ' ') {
                count[1] += 1;
            } else if (c >= '0' && c <= '9') {
                count[2] += 1;
            } else {
                count[3] += 1;
            }
        }
    }
}
