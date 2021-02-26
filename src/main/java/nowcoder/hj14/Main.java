package nowcoder.hj14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main1(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] str = new String[Integer.parseInt(in.readLine())];
        for (int i = 0; i < str.length; i++) {
            str[i] = in.readLine();
        }
        Arrays.stream(str).sorted().forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] str = new String[Integer.parseInt(in.readLine())];
        for (int i = 0; i < str.length; i++) {
            str[i] = in.readLine();
        }

        StringBuffer sb = new StringBuffer();
        Arrays.sort(str);
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}


