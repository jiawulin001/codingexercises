package nowcoder.hj71;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
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
}
