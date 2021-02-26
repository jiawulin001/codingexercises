package nowcoder.hj13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main1(String[] args) throws IOException {
        BufferedReader bread = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bread.readLine().split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = str.length - 1; i >= 0; i--) {
            sb.append(str[i]);
            sb.append(" ");
        }
        sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bread = new BufferedReader(new InputStreamReader(System.in));
        List<String> strs = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        String str = bread.readLine();

        for (int i = 0; i < str.length(); i++) {
            if (' ' == str.charAt(i)) {
                strs.add(sb.toString());
                sb = new StringBuffer();
            } else {
                sb.append(str.charAt(i));
            }
        }
        strs.add(sb.toString());
        sb = new StringBuffer();
        for (int i = strs.size() - 1; i >= 0; i--) {
            sb.append(strs.get(i));
            sb.append(" ");
        }
        sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb);
    }
}


