package nowcoder.hj67;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int[] numbers = {in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()};
            int[] flag = {0, 0, 0, 0};


            boolean result = false;
            for (int i = 0; i < numbers.length; i++) {
                flag[i] = 1;
                if (dfs(numbers, flag, numbers[i])) {
                    result = true;
                    break;
                }
                flag[i] = 0;
            }

            System.out.println(result);
        }

    }

    private static boolean dfs(int[] numbers, int[] flag, int val) {
        if (flag[0] + flag[1] + flag[2] + flag[3] == 4) {
            return val == 24;
        }

        for (int j = 0; j < numbers.length; j++) {
            if (flag[j] == 0) {
                flag[j] = 1;
                if (dfs(numbers, flag, val + numbers[j]) ||
                        dfs(numbers, flag, val - numbers[j])
                        || dfs(numbers, flag, val * numbers[j])
                        || (val % numbers[j] == 0 && dfs(numbers, flag, val / numbers[j]))) {
                    return true;
                }
                flag[j] = 0;

            }
        }

        return false;
    }
}
