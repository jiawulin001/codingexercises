package nowcoder.hj55;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int number;
        int count = 0;
        while ((str = in.readLine()) != null) {
            number = Integer.parseInt(str);
            count = 0;
            for (int i = 7; i <= number; i++) {
                if (i % 7 == 0) {
                    count++;
                } else if ((i + "").indexOf('7') != -1) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
