package nowcoder.hj107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main22(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        Double num;
        while ((str = in.readLine()) != null) {
            num = Double.valueOf(str);
            System.out.printf("%.1f", Math.pow(num, 1.0 / 3.0));
        }
    }

    public static void main1(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        Double num;
        Double length;
        while ((str = in.readLine()) != null) {
            num = Double.valueOf(str);
            length = Math.sqrt(num);
            for (float i = 0; i < length; i++) {
                if (i * i * i == num) {
                    System.out.printf("%.1f", i);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Double number;
        Double max;
        Double min;
        Double input;
        Double cj;
        while (in.hasNext()) {
            input = in.nextDouble();
            max = input;
            min = 0.0;

            while (max - min > 0.001) {
                number = (max + min) / 2;
                cj = number * number * number;
                if (cj > input) {
                    max = number;
                } else if (cj < input) {
                    min = number;
                } else {
                    max = number;
                    break;
                }
            }
            System.out.printf("%.1f", max);
        }
    }
}
