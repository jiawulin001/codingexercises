package nowcoder.hj63;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            int length = in.nextInt();

            int max = 0;
            String result = "";
            String tempStr = "";
            int count = 0;

            if (length == str.length()) {
                System.out.println(str);
                continue;
            }

            for (int i = 0; i < str.length() - length; i++) {
                tempStr = str.substring(i, i + length);
                count = countGC(tempStr);
                if (count > max) {
                    max = count;
                    result = tempStr;
                }
            }

            System.out.println(result);
        }
    }


    private static int countGC(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if ('G' == str.charAt(i) || 'C' == str.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}

