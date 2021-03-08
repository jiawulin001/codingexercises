package nowcoder.hj92;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int max;
        int count;
        int i;
        StringBuffer sb;
        while ((str = in.readLine()) != null) {
            sb = new StringBuffer();
            max = 0;
            count = 0;
            i = 0;

            while (true) {
                if (i < str.length() && isNumber(str.charAt(i))) {
                    count++;
                } else {
                    if (max < count) {
                        sb = new StringBuffer();
                        max = count;
                    }

                    if (count != 0 && max == count) {
                        sb.append(str.substring(i - count, i));
                    }
                    count = 0;
                }
                if (i > str.length()) {
                    break;
                }
                i++;
            }

            sb.append(",");
            sb.append(max);
            System.out.println(sb);
        }
    }


    private static boolean isNumber(Character c) {
        return '0' <= c && '9' >= c;
    }
}
