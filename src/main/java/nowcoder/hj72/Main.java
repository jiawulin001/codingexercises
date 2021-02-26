package nowcoder.hj72;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            in.nextInt();
            System.out.println(printResult());
        }
    }

    private static String printResult() {
        // 5*x + 3 * y + z / 3 = 100;
        int z;
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < (100 - i); j++) {
                //(5 * i) + (3 * j) + (z / 3) = 100
                z = (100 - (5 * i + 3 * j)) * 3;
                if (i + j + z == 100) {
                    buffer.append(i + " " + j + " " + z + "\n");
                }
            }
        }

        return buffer.toString();
    }
}
