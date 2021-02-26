package nowcoder.hj38;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        Float count = (float) in.nextInt();
        Float currHeight = count;
        // 1
        // 1 / 2   * 2
        // 1 / 2 / 2 * 2
        // 1 / 2 / 2 / 2 *2
        // 1 / 2 / 2 / 2 / 2 *2
        for (int i = 0; i < 4; i++) {
            count += currHeight;
            currHeight = currHeight / 2;
        }
        //System.out.printf("%.6f \n", count);
        //System.out.printf("%.6f \n", currHeight / 2);
        System.out.println(count);
        System.out.println(currHeight / 2);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Float count = Float.valueOf(in.readLine());
        Float currHeight = count;
        for (int i = 0; i < 4; i++) {
            count += currHeight;
            currHeight = currHeight / 2;
        }
        System.out.println(count);
        System.out.println(currHeight / 2);
    }
}
