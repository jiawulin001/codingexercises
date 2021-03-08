package nowcoder.hj49;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuffer sb;
        int count;
        while (in.hasNext()) {
            sb = new StringBuffer();
            count = in.nextInt();
            for (int i = 0; i < count; i++) {
                sb.append("ABCD");
            }
            System.out.println(sb);
        }
    }
}
