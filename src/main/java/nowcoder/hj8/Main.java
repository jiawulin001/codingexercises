package nowcoder.hj8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

public class Main {
    public static void main1(String[] args) throws IOException {
        try (BufferedReader bread = new BufferedReader(new InputStreamReader(System.in))) {
            String str;
            int length;

            String[] strs;
            HashMap<Integer, Integer> result;
            while ((str = bread.readLine()) != null) {
                length = Integer.valueOf(str);
                result = new HashMap<>();
                for (int i = 0; i < length; i++) {
                    strs = bread.readLine().split(" ");
                    result.put(Integer.valueOf(strs[0]),
                            result.getOrDefault(Integer.valueOf(strs[0]), 0) + Integer.valueOf(strs[1]));
                }

                Set<Integer> keys = result.keySet();
                Object[] nums = keys.stream().sorted(Comparator.comparingInt(n -> n)).toArray();

                for (Object key : nums) {
                    System.out.println(key + " " + result.get(key));
                }
            }
        }
    }

    public static void main2(String[] args) throws IOException {
        try (BufferedReader bread = new BufferedReader(new InputStreamReader(System.in))) {
            String str;
            Integer[] values;
            String[] strs;
            int index;
            StringBuffer sb;
            while ((str = bread.readLine()) != null) {
                values = new Integer[Integer.valueOf(str)];
                for (int i = 0; i < values.length; i++) {
                    strs = bread.readLine().split(" ");
                    index = Integer.valueOf(strs[0]);
                    if (values[index] != null) {
                        values[index] += Integer.valueOf(strs[1]);
                    } else {
                        values[index] = Integer.valueOf(strs[1]);
                    }
                }

//                for (int i = 0; i < values.length; i++) {
//                    if (values[i] != null) {
//                        System.out.printf("%d %d\n", i, values[i]);
//                    }
//                }

                sb = new StringBuffer();
                for (int i = 0; i < values.length; i++) {
                    if (values[i] != null) {
                        sb.append(i);
                        sb.append(" ");
                        sb.append(values[i]);
                        sb.append("\n");
                    }
                }
                System.out.println(sb);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            //System.out.println(st.nval); //System.out.println(st.sval);
        }
    }
}


