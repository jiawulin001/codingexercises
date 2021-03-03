package nowcoder.hj94;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        int m, n;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        String[] strs;
        Map<String, Integer> map;
        while ((str = in.readLine()) != null) {
            m = Integer.parseInt(str);
            map = new LinkedHashMap<>(m + 1);
            strs = in.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                map.put(strs[i], 0);
            }
            map.put("Invalid", 0);

            n = Integer.parseInt(in.readLine());
            strs = in.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                str = strs[i];
                if (!map.containsKey(str)) {
                    str = "Invalid";
                }
                map.put(str, map.get(str) + 1);
            }
            StringBuffer sb = new StringBuffer();
            map.forEach((key, value) -> {
                sb.append(key);
                sb.append(" : ");
                sb.append(value);
                sb.append("\n");
            });

            sb.delete(sb.length() - 1, sb.length());
            System.out.println(sb);
        }
    }
}
