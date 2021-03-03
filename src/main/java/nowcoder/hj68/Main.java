package nowcoder.hj68;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        String[] strs;
        int m;
        Object[][] cj;
        StringBuffer sb;
        while ((str = in.readLine()) != null) {
            m = Integer.parseInt(str);
            boolean isDesc = "0".equals(in.readLine()) ? true : false;
            cj = new Object[m][2];
            for (int i = 0; i < m; i++) {
                strs = in.readLine().split(" ");
                cj[i][0] = strs[0];
                cj[i][1] = Integer.parseInt(strs[1]);
            }

            Arrays.sort(cj, (c1, c2) -> {
                if (isDesc) {
                    return (int) c2[1] - (int) c1[1];
                } else {
                    return (int) c1[1] - (int) c2[1];
                }
            });

            sb = new StringBuffer();
            for (int i = 0; i < cj.length; i++) {
                sb.append(cj[i][0]);
                sb.append(" ");
                sb.append(cj[i][1]);
                sb.append("\n");
            }
            sb.delete(sb.length() - 1, sb.length());
            System.out.println(sb);
        }
    }
}
