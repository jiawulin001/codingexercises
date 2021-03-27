package od;

import java.util.Arrays;
import java.util.Comparator;

public class Main23 {

    /**
     * <h1>数组中组成最小的数组</h1>
     * 给一个数组，选择3个元素注册最小数字并输出
     * <h2>示例1：</h2>
     * <h3>输入</h3>
     * 21，30，62，5，31
     * <h3>输出</h3>
     * 21305
     */
    public static void main1(String[] args) {
        int[] nums = {21, 30, 62, 5, 31};
        Arrays.sort(nums);
        Integer[] n = {nums[0], nums[1], nums[2]};
        Arrays.sort(n,(n1, n2) -> Integer.valueOf(n1 + "" + n2) - Integer.valueOf(n2 + "" + n1));
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i]);
        }
    }


    public static void main(String[] args) {
        String a = "123";
        String b = "321";


    }
}

