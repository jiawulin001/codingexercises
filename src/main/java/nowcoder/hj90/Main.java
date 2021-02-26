package nowcoder.hj90;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String[] ip;
        while ((line = in.readLine()) != null) {
            if (line.indexOf("-") != -1) {
                System.out.println("NO");
                continue;
            }

            ip = line.split("\\.");
            if (ip.length != 4) {
                System.out.println("NO");
            } else if (Integer.parseInt(ip[0]) <= 255
                    && Integer.parseInt(ip[1]) <= 255
                    && Integer.parseInt(ip[2]) <= 255
                    && Integer.parseInt(ip[3]) <= 255) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
