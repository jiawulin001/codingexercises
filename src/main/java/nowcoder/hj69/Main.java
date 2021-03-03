package nowcoder.hj69;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        String[] strs;
        while ((str = in.readLine()) != null) {
            int x = Integer.parseInt(str);
            int y = Integer.parseInt(in.readLine());
            int z = Integer.parseInt(in.readLine());

            int[][] a = new int[x][y];
            int[][] b = new int[y][z];
            for (int i = 0; i < x; i++) {
                strs = in.readLine().split(" ");
                for (int j = 0; j < y; j++) {
                    a[i][j] = Integer.parseInt(strs[j]);
                }
            }

            for (int i = 0; i < y; i++) {
                strs = in.readLine().split(" ");
                for (int j = 0; j < z; j++) {
                    b[i][j] = Integer.parseInt(strs[j]);
                }
            }

            int value;
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < z; j++) {
                    value = 0;
                    for (int k = 0; k < y; k++) {
                        //当前行乘以当前列
                        value += (a[i][k] * b[k][j]);
                    }
                    sb.append(value);
                    sb.append(" ");
                }
                sb.append("\n");
            }

            sb.delete(sb.length() - 1, sb.length());
            System.out.println(sb.toString());
        }
    }
}
