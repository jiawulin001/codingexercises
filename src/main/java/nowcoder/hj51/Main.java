package nowcoder.hj51;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        String[] nums;
        int length;
        int[] arr;
        int lastIndext;
        while ((str = in.readLine()) != null) {
            length = Integer.parseInt(str);
            arr = new int[length];
            nums = in.readLine().split(" ");
            for (int i = 0; i < length; i++) {
                arr[i] = Integer.parseInt(nums[i]);
            }
            lastIndext = Integer.parseInt(in.readLine());

            if (lastIndext > arr.length || lastIndext <= 0) {
                System.out.println("0");
            } else {
                System.out.println(arr[arr.length - lastIndext]);
            }
        }
    }
}
