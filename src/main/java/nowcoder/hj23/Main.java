package nowcoder.hj23;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        int length = in.available();
        HashMap<Integer, Integer> map = new HashMap<>();
        int c;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            c = in.read();
            if (c != '\n') {
                sb.append((char) c);
                map.put(c, map.getOrDefault(c, 0) + 1);
                continue;
            }
            int min = 1;
            for (; min <= 20; min++) {
                if (map.containsValue(min)) {
                    break;
                }
            }

            String str = sb.toString();
            for (int chr : map.keySet()) {
                if (map.get(chr) == min) {
                    str = str.replaceAll((char) chr + "", "");
                }
            }
            System.out.println(str);

            sb = new StringBuffer();
            map = new HashMap<>();
        }
    }
}
