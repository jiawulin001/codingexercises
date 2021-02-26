package nowcoder.hj37;

import java.util.Scanner;

public class Main {
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int month = in.nextInt();
            System.out.println(countRabbit(month));
        }
    }

    private static int countRabbit(int month) {
        ///List<Integer> list = new ArrayList<>(month);
        int count = 1;
        int rabbit = 0;
        int[] rabbits = new int[month + 5];
        rabbits[3] = 1;

        for (int i = 3; i <= month; i++) {
            rabbit += rabbits[i];
            rabbits[i + 2] = rabbit;
            count += rabbit;
        }

        return count;
    }


}
