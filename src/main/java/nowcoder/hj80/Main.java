package nowcoder.hj80;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        String[] strs;
        int[] arr;
        StringBuffer sb;
        int i, j;
        while ((str = in.readLine()) != null) {
            sb = new StringBuffer();
            strs = in.readLine().split(" ");
            arr = new int[strs.length + Integer.parseInt(in.readLine())];
            for (i = 0; i < strs.length; i++) {
                arr[i] = Integer.parseInt(strs[i]);
            }
            j = 0;
            strs = in.readLine().split(" ");
            for (; i < arr.length; i++, j++) {
                arr[i] = Integer.parseInt(strs[j]);
            }

            Arrays.sort(arr);

            sb.append(arr[0]);
            for (i = 1; i < arr.length; i++) {
                if (arr[i] != arr[i - 1]) {
                    sb.append(arr[i]);
                }
            }
            System.out.println(sb);
        }
    }
}
