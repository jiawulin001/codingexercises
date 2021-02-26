package nowcoder.hj100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader bread = new BufferedReader(new InputStreamReader(System.in))) {
            String str;
            int n;
            while ((str = bread.readLine()) != null) {
                if (!"".equals(str)) {
                    n = Integer.parseInt(str);
                    //2，5，8，11，14
                    System.out.println(2 * n + (n * (n - 1) * 3) / 2);
                    //Sn=a1*n+[n*(n-1)*d]/2
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}