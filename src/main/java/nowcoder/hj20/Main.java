package nowcoder.hj20;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        //1.长度超过8位
        //2.包括大小写字母.数字.其它符号,以上四种至少三种
        //3.不能有相同长度大于2的子串重复
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int[] count;
        int i;
        while ((str = in.readLine()) != null) {
            if ("".equals(str)) {
                continue;
            }
            count = new int[4];
            if (str.length() <= 8) {
                System.out.println("NG");
                continue;
            }

            for (i = 0; i < str.length() - 6; i++) {
                if (-1 != str.indexOf(str.substring(i, i + 3), i + 3)) {
                    System.out.println("NG");
                    count = null;
                    break;
                }
                if ('A' <= str.charAt(i) && 'Z' >= str.charAt(i)) {
                    count[0] = 1;
                } else if ('a' <= str.charAt(i) && 'z' >= str.charAt(i)) {
                    count[1] = 1;
                } else if ('0' <= str.charAt(i) && '9' >= str.charAt(i)) {
                    count[2] = 1;
                } else {
                    count[3] = 1;
                }
            }

            if (count == null) {
                continue;
            }


            for (; i < str.length(); i++) {
                if ('A' <= str.charAt(i) && 'Z' >= str.charAt(i)) {
                    count[0] = 1;
                } else if ('a' <= str.charAt(i) && 'z' >= str.charAt(i)) {
                    count[1] = 1;
                } else if ('0' <= str.charAt(i) && '9' >= str.charAt(i)) {
                    count[2] = 1;
                } else {
                    count[3] = 1;
                }
            }

            if (count[0] + count[1] + count[2] + count[3] < 3) {
                System.out.println("NG");
                continue;
            }

            System.out.println("OK");
        }
    }
}
