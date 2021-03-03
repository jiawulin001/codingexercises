package nowcoder.hj58;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        String[] strs;
        Object[] nums;
        while ((str = in.readLine()) != null) {
            strs = str.split(" ");
            int k = Integer.parseInt(strs[1]);
            strs = in.readLine().split(" ");
            StringBuffer sb = new StringBuffer();
            nums = Arrays.stream(strs).sorted(Comparator.comparingInt(Integer::parseInt)).toArray();

            for (int j = 0; j < k; j++) {
                sb.append(nums[j].toString());
                sb.append(" ");
            }
            sb.delete(sb.length() - 1, sb.length());
            System.out.println(sb);
        }
    }
}
