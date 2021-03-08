package nowcoder.hj65;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] a = new int[26];
        a[0] = 1;
        a[1] = 2;
        a[2] = 4;
        a[3] = 7;
        for (int i = 4; i < a.length; i++) {
            a[i] = a[i - 1] + a[i - 2] + a[i - 3];
            a[i] = a[i] % 26;
        }

        Arrays.stream(a).forEach(System.out::println);

    }

    public static void main1(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        String str2;
        String temp;

        int ii, jj;
        int max;
        while ((str = in.readLine()) != null) {
            str2 = in.readLine();
            ii = 0;
            jj = 0;
            max = 0;

            if (str.length() > str2.length()) {
                temp = str;
                str = str2;
                str2 = temp;
            }

            int count = 0;
            int j = str2.indexOf(str.charAt(0));
            for (int i = 0; ; ) {
                if (i < str.length() && j < str2.length() && str2.charAt(j) == str.charAt(i)) {
                    count++;
                    j++;
                    i++;
                } else {
                    if (max < count) {
                        ii = j - count;
                        jj = j - 1;
                        max = count;
                    }

                    i = i - count;
                    j = str2.indexOf(str.charAt(i), j - count + 1);
                    if (j == -1) {
                        i++;
                        j = 0;
                    }

                    count = 0;
                    if (i >= str.length()) {
                        break;
                    }
                }
            }
            System.out.println(str2.substring(ii, jj + 1));
        }
    }
}
