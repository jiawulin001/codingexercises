package nowcoder.hj11;

import java.util.Scanner;


/**
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 */


public class Main {

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = 0;
        String str;
        char[] chars;
        while (in.hasNext()) {
            num = in.nextInt();
            str = "";
            chars = (num + "").toCharArray();

            for (int i = chars.length - 1; i >= 0; i--) {
                str += chars[i];
            }
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuffer buffer;
        while (in.hasNext()) {
            buffer = new StringBuffer(in.next());
            System.out.println(buffer.reverse());
        }
    }


    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        String str, outStr;

        while (in.hasNext()) {
            str = in.next();
            outStr = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                outStr += str.charAt(i);
            }
            System.out.println(outStr);
        }
    }
}
