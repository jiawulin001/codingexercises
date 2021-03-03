package nowcoder.hj81;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String shortStr;
        String longStr;
        Boolean result;
        while ((shortStr = in.readLine()) != null) {
            longStr = in.readLine();
            result = true;
            for (int i = 0; i < shortStr.length(); i++) {
                if (longStr.indexOf(shortStr.charAt(i)) == -1) {
                    result = false;
                    break;
                }
            }
            System.out.println(result);
        }
    }
}
