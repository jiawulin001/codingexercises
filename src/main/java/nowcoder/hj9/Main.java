package nowcoder.hj9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main1(String[] args) throws IOException {
        try (BufferedReader bread = new BufferedReader(new InputStreamReader(System.in))) {
            String str;
            boolean[] flag;
            StringBuffer sb;
            int num;
            while ((str = bread.readLine()) != null) {
                flag = new boolean[10];
                sb = new StringBuffer();
                for (int i = str.length() - 1; i >= 0; i--) {
                    num = Integer.parseInt(str.charAt(i) + "");
                    if (!flag[num]) {
                        sb.append(str.charAt(i));
                        flag[num] = true;
                    }
                }
                System.out.println(Integer.valueOf(sb.toString()));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bread = new BufferedReader(new InputStreamReader(System.in))) {
            String str;
            StringBuffer sb;
            while ((str = bread.readLine()) != null) {
                sb = new StringBuffer();
                for (int i = str.length() - 1; i >= 0; i--) {
                    if (sb.indexOf(str.charAt(i) + "") == -1) {
                        sb.append(str.charAt(i));
                    }
                }
                System.out.println(Integer.valueOf(sb.toString()));
            }
        }
    }
}


