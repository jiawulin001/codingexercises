package nowcoder.hj30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String str1, str2;
        DecimalFormat df = new DecimalFormat("0000");


        for (int i = 0; i < 16; i++) {
            str1 = df.format(Integer.valueOf(Integer.toBinaryString(i)));
            str2 = df.format(Integer.valueOf(Integer.toBinaryString((i & 1) * 8 + (i & 2) * 2 + (i & 4) / 2 + (i & 8) / 8)));
            System.out.println(str1 + "\t" + str2);
        }
    }


    public static void main1(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        char[] chr1;
        char[] chr2;
        char c;
        int length;
        StringBuffer sb;
        String[] bits = {"0", "8", "4", "C", "2", "A", "6", "E", "1", "9", "5", "D", "3", "B", "7", "F"};

        while ((str = in.readLine()) != null) {
            str = str.replace(" ", "");
            length = str.length();
            if (length % 2 == 0) {
                chr1 = new char[length / 2];
                chr2 = new char[chr1.length];
            } else {
                chr2 = new char[length / 2];
                chr1 = new char[chr2.length + 1];
            }

            for (int i = 0; i < str.length(); i++) {
                chr1[i / 2] = str.charAt(i);
                i++;
                if (i < str.length()) {
                    chr2[(i - 1) / 2] = str.charAt(i);
                }
            }

            Arrays.sort(chr1);
            Arrays.sort(chr2);

            sb = new StringBuffer();

            for (int i = 0; i < length; i++) {
                if (i % 2 == 0) {
                    c = chr1[i / 2];
                } else {
                    c = chr2[(i - 1) / 2];
                }

                if (c >= 'a' && c <= 'f') {
                    sb.append(bits[c - 87]);
                } else if (c >= 'A' && c <= 'F') {
                    sb.append(bits[c - 55]);
                } else if (c >= '0' && c <= '9') {
                    sb.append(bits[c - '0']);
                } else {
                    sb.append(c);
                }
            }

            System.out.println(sb);
        }
    }
}
