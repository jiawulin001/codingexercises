package nowcoder.hj60;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int num;
        int length;
        boolean isZS;
        int num2;
        int minValue;
        String result = "";

        int count;

        String str;
        while ((str = in.readLine()) != null) {
            num = Integer.parseInt(str);
            count = num / 2;
            minValue = num;
            for (int i = 1; i <= count; i++) {
                length = (int) Math.sqrt(i);
                isZS = true;
                for (int j = 2; j <= length; j++) {
                    if (i % j == 0) {
                        isZS = false;
                        break;
                    }
                }

                if (!isZS) {
                    continue;
                }

                num2 = num - i;

                length = (int) Math.sqrt(num2);
                isZS = true;
                for (int j = 2; j <= length; j++) {
                    if (num2 % j == 0) {
                        isZS = false;
                        break;
                    }
                }
                if (!isZS) {
                    continue;
                }


                if (minValue > num2 - i) {
                    minValue = num2 - i;
                    result = i + "\n" + num2;
                }

            }
            System.out.println(result);
        }
    }

    //1 2 4 5 8 10
    public static void main2(String[] args) {
        for (int i = 1; i <= Math.sqrt(2); i++) {
            if (2 % i == 0) {
                System.out.println(i);
            }
        }
    }
}
