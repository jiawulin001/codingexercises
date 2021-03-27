package od;

import java.util.Arrays;

public class Main4 {
    /**
     * 第二题 基于小明的身高给班级排序
     * 与小明身高差的绝对最小的排前面，身高差的绝对值最大的排后面，漏掉很重要的一点，相同绝对值的按身高大小排
     * 输入
     * 第一行 小明身高 和班级同学个数
     * 第二行 对应同学身高
     * 输出 排序后输出数组
     * 用例
     * 100 10
     * 95 96 97 98 99 101 102 103 104 105
     * 输出
     * 99 101 98 102 97 103 96 104 95 105
     */


    public static void main(String[] args) {
        int xmHeight = 100;
        int[] tx = {95, 96, 97, 98, 99, 101, 102, 103, 104, 105};
        //ans:99 101 98 102 97 103 96 104 95 105
        Arrays.stream(sorted(xmHeight, tx)).forEach(n -> {
            System.out.print(n + " ");
        });
    }


    public static Integer[] sorted(int xm, int[] heights) {
        return Arrays.stream(heights).boxed().sorted((n1, n2) -> {
            int diff1 = Math.abs(n1 - xm);
            int diff2 = Math.abs(n2 - xm);
            if (diff1 == diff2) {
                return n1 - n2;
            } else {
                return diff1 - diff2;
            }
        }).toArray(Integer[]::new);
    }
}
