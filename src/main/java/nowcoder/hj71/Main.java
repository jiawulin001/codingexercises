package nowcoder.hj71;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main2(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String modelStr;
        String str;
        StringBuffer sb;
        int j;
        while ((modelStr = in.readLine()) != null) {
            sb = new StringBuffer();
            str = in.readLine();

            for (int i = 0; i < modelStr.length(); ) {
                if ('?' == modelStr.charAt(i)) {
                    j = i;
                    while (modelStr.charAt(j) == '?') {
                        j++;
                    }
                    sb.append('{');
                    sb.append(j - i);
                    sb.append('}');
                    i = j;
                } else if ('*' == modelStr.charAt(i)) {
                    while (i < modelStr.length() && modelStr.charAt(i) == '*') {
                        i++;
                    }
                    sb.append('*');
                } else {
                    sb.append(modelStr.charAt(i));
                    i++;
                }
            }
            System.out.println(str.matches(sb.toString()));
        }

        //zfxfz{1}tnblhz{1}cv{1}{1}bjan{1}ecdwqb**{1}*xpbff
    }

    public static void main1(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String modelStr;
        String str;
        while ((modelStr = in.readLine()) != null) {
            str = in.readLine();

            for (int i = 0; i < modelStr.length(); i++) {
                if ('*' == modelStr.charAt(i)) {

                } else if ('?' == modelStr.charAt(i)) {

                }
            }
        }
    }


    // *：匹配0个或以上的字符（字符由英文字母和数字0-9组成，不区分大小写。下同）
    //？：匹配1个字符
    //te?t*.*
    //txt12.xls
    //有一个用例不过：a* a
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str1, str2;
        while ((str1 = in.readLine()) != null) {
            str2 = in.readLine();
            System.out.println(matches(str1, str2, 0, 0));
        }
    }

    private static boolean matches(String str1, String str2, int index1, int index2) {
        if (index1 == str1.length() && index2 == str2.length()) {
            return true;
        } else if (index1 == str1.length() || index2 == str2.length()) {
            return false;
        }

        if ('*' == str1.charAt(index1)) {
            return matches(str1, str2, index1 + 1, index2) || matches(str1, str2, index1 + 1, index2 + 1);
        } else if ('?' == str1.charAt(index1) || str1.charAt(index1) == str2.charAt(index2)) {
            return matches(str1, str2, index1 + 1, index2 + 1);
        }

        return false;
    }
}
