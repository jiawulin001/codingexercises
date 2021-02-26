package nowcoder.hj59;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main1(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        char[] strs;
        String c;
        int[] chrs;
        while ((str = in.readLine()) != null) {
            c = "-1";
            strs = str.toCharArray();
            str = str.toUpperCase();
            chrs = new int[100];
            for (int i = 0; i < str.length(); i++) {
                if (chrs[str.charAt(i)] == 1) {
                    continue;
                }

                if (str.indexOf(str.charAt(i), i + 1) == -1) {
                    c = strs[i] + "";
                    break;
                }
                chrs[str.charAt(i)] = 1;
            }
            System.out.println(c);
        }
    }


    //更直接有效，直接看开始和最后是否坐标相同
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        char c = ' ';
        int i;
        while ((str = in.readLine()) != null) {
            for (i = 0; i < str.length(); i++) {
                c = str.charAt(i);
                if (str.indexOf(c) == str.lastIndexOf(c)) {
                    break;
                }
            }
            System.out.println(i == str.length() ? "-1" : c);
        }
    }
}
