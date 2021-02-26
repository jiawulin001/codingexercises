package nowcoder.hj102;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main1(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        LinkedHashMap<Character, Integer> list;
        int count;
        StringBuffer sb;
        while ((line = in.readLine()) != null) {
            list = new LinkedHashMap<>();
            for (int i = 0; i < line.length(); i++) {
                count = list.getOrDefault(line.charAt(i), 0) + 1;
                list.put(line.charAt(i), count);
            }

            Iterator<Map.Entry<Character, Integer>> it = list.entrySet().stream().sorted((e2, e1) -> {
                if (e1.getValue() - e2.getValue() == 0) {
                    return e2.getKey() - e1.getKey();
                }
                return e1.getValue() - e2.getValue();
            }).iterator();

            sb = new StringBuffer();
            while (it.hasNext()) {
                sb.append(it.next().getKey());
            }
            System.out.println(sb.toString());
        }
    }


    public static void main3(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int[] count;
        int max;
        while ((str = in.readLine()) != null) {
            count = new int[123];
            max = 0;
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i)] += 1;
                max = Math.max(max, count[str.charAt(i)]);
            }
            StringBuffer sb = new StringBuffer();
            while (max > 0) {
                for (int i = 48; i < count.length; i++) {
                    if (count[i] == max) {
                        sb.append((char) i);
                    }
                }
                max--;
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 150; i++) {
            System.out.printf("%s:\t%s\n", i, (char) i);
        }
    }
}
