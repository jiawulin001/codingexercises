package nowcoder.hj57;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main1(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String number1 = "";
        String number2 = "";
        String temp;
        int length;
        StringBuffer sum;
        int jw;
        int num;
        while ((number1 = in.readLine()) != null) {
            number2 = in.readLine().trim();
            number1 = number1.trim();
            sum = new StringBuffer();
            jw = 0;
            if (number1.length() < number2.length()) {
                temp = number1;
                number1 = number2;
                number2 = temp;
            }

            length = number1.length() - number2.length();
            for (int i = number2.length() - 1; i >= 0; i--) {
                num = number1.charAt(i + length) - '0' + Integer.parseInt(number2.charAt(i) + "") + jw;
                if (num >= 10) {
                    jw = 1;
                    num -= 10;
                } else {
                    jw = 0;
                }
                sum.append(num);
            }


            for (int i = length - 1; i >= 0; i--) {
                num = Integer.parseInt(number1.charAt(i) + "") + jw;
                if (num >= 10) {
                    jw = 1;
                    num -= 10;
                } else {
                    jw = 0;
                }
                sum.append(num);
            }

            if (jw == 1) {
                sum.append(jw);
            }

            System.out.println(sum.reverse().toString());
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        BigInteger number1;
        BigInteger number2;
        while ((str = in.readLine()) != null) {
            str = str.trim();
            number1 = new BigInteger(str);
            str = in.readLine().trim();
            number2 = new BigInteger(str);
            number2 = number1.add(number2);
            System.out.println(number2.toString());
        }
    }
}
