package nowcoder.hj73;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String day = in.nextLine();
            System.out.println(calcDay(day));
        }
    }

    private static int calcDay(String day) {
        int dataCount = 0;
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int[] date = Arrays.stream(day.split(" ")).mapToInt(Integer::valueOf).toArray();

        int year = date[0];
        boolean isRuinian = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
        if (isRuinian) {
            days[1] = 29;
        }

        for (int i = 0; i < date[1] - 1; i++) {
            dataCount += days[i];
        }
        dataCount += date[2];

        return dataCount;
    }
}
