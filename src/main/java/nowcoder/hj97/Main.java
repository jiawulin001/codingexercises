package nowcoder.hj97;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        int fsCount, zeroCount;
        int sum;
        int num;
        while (in.hasNext()) {
            n = in.nextInt();
            fsCount = 0;
            zeroCount = 0;
            sum = 0;
            for (int i = 0; i < n; i++) {
                num = in.nextInt();
                if (num < 0) {
                    fsCount++;
                } else if (num != 0) {
                    sum += num;
                } else {
                    zeroCount++;
                }
            }
            System.out.printf("%d %.1f \n", fsCount, (float) sum / (n - fsCount - zeroCount));
        }
    }
}
