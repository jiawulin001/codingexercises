package nowcoder.hj15;

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
        int count = 0;
        while (in.hasNext()) {
            intVal = in.nextInt();
            count = 0;
            while (intVal != 0) {
                count += intVal % 2;   //不是0就是1
                intVal = intVal / 2;
            }
            System.out.println(count);
        }
    }
}
