package nowcoder.hj46;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = in.readLine()) != null) {
            System.out.println(str.substring(0, Integer.parseInt(in.readLine())));
        }
    }
}
