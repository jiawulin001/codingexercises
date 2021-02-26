package nowcoder.hj34;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int c;
        int[][] result = new int[123][1];
        StringBuffer sb = new StringBuffer();
        while ((c = in.read()) != -1) {
            if (c == '\r' || c == '\n') {
                for (int i = 48; i < result.length; i++) {
                    for (int j = 0; j < result[i][0]; j++) {
                        sb.append((char) i);
                    }
                }
                sb.append("\n");
                result = new int[150][1];
                continue;
            }
            result[c][0] += 1;
        }
        System.out.println(sb.toString());
    }


    public static void main1(String[] args) {
        for (int i = 0; i < 150; i++) {
            System.out.println(i + ":\t" + (char) i);
        }
    }
}
