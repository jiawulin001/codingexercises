package nowcoder.hj96;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main1(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char c;
        boolean isNumber = false;
        StringBuffer sb = new StringBuffer();
        while ((c = (char) in.read()) != -1 && c != 65535) {
            if (c == '\r' || c == '\n') {
                if (isNumber) {
                    sb.append("*");
                }
                System.out.println(sb.toString());
                sb = new StringBuffer();
                isNumber = false;
            } else if (!isNumber && c >= '0' && c <= '9') {
                sb.append('*');
                sb.append(c);
                isNumber = true;
            } else if (isNumber && !(c >= '0' && c <= '9')) {
                sb.append('*');
                sb.append(c);
                isNumber = false;
            } else {
                sb.append(c);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        boolean isNumber = false;
        StringBuffer sb;
        char c;
        while ((str = in.readLine()) != null) {
            sb = new StringBuffer();
            isNumber = false;
            for (int i = 0; i < str.length(); i++) {
                c = str.charAt(i);
                if (!isNumber && c >= '0' && c <= '9') {
                    sb.append('*');
                    sb.append(c);
                    isNumber = true;
                } else if (isNumber && !(c >= '0' && c <= '9')) {
                    sb.append('*');
                    sb.append(c);
                    isNumber = false;
                } else {
                    sb.append(c);
                }
            }

            if (isNumber) {
                sb.append("*");
            }

            System.out.println(sb);
        }
    }
}
