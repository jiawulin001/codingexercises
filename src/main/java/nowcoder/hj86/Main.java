package nowcoder.hj86;

import java.util.Scanner;

public class Main {
    /**
     * 求二进制数1的个数<br/>
     * 位运算常见案例：<br/>
     * https://blog.csdn.net/hyqsong/article/details/51588551
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer intVal = null;
        int preCount = 0;
        int currCount = 0;
        while (in.hasNext()) {
            intVal = in.nextInt();
            currCount = 0;
            preCount = 0;
            while (intVal != 0) {

                if (intVal % 2 == 1) {
                    currCount++;
                } else if (preCount <= currCount) {//要等于不能164（10100100）过不了
                    preCount = currCount;
                    currCount = 0;
                }

                intVal = intVal / 2;
            }
            System.out.println(Math.max(preCount, currCount));
        }
    }

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer intVal;
        while (in.hasNext()) {
            intVal = in.nextInt();
            String str = Integer.toBinaryString(intVal);
            String[] strs = str.split("0");
            int max = 0;
            for (int i = 0; i < strs.length; i++) {
                max = Math.max(max, strs[i].length());
            }
            System.out.println(max);
        }
    }
}
