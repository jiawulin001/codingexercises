package nowcoder.hj75;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            System.out.println(findMaxSubStringSize(str1, str2));
        }
    }

    //滑窗解法
    private static int findMaxSubStringSize(String str1, String str2) {
        String temp;
        if (str1.length() > str2.length()) {
            temp = str1;
            str1 = str2;
            str2 = temp;
        }

        int beginIndex = 0, endIndex = 1;
        int maxSize = 0;
        while (beginIndex + maxSize < str1.length()) {
            if (-1 != str2.indexOf(str1.substring(beginIndex, endIndex))) {
                maxSize = Math.max(endIndex - beginIndex, maxSize);
                endIndex++;
            } else {
                beginIndex++;
                endIndex = Math.max(endIndex, beginIndex + 1);
            }
        }

        return maxSize;
    }


    //DP解法
    private static int findMaxSubStringSize2(String str1, String str2) {
        return 0;
    }

}
