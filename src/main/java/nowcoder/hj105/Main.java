package nowcoder.hj105;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int fsCount = 0;
        int zsCount = 0;
        int num, sum = 0;

        while (in.hasNext()) {
            num = in.nextInt();
            if (num < 0) {
                fsCount++;
            } else {
                zsCount++;
                sum += num;
            }
        }

        System.out.printf("%d\n%.1f", fsCount, sum == 0 ? 0.0 : sum / zsCount);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int fsCount = 0;
        int zsCount = 0;
        int num, sum = 0;

        while ((str = in.readLine()) != null) {
            if ("exit".equals(str)) break;
            num = Integer.parseInt(str);
            if (num < 0) {
                fsCount++;
            } else {
                zsCount++;
                sum += num;
            }
        }
        System.out.printf("%d\n%.1f", fsCount, sum == 0 ? 0.0 : sum / zsCount);
    }
}