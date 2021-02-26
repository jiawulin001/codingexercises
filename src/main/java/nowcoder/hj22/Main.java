package nowcoder.hj22;

import java.util.Scanner;


/**
 * <b>题目描述:</b><br/>
 * 有这样一道智力题：<br/>
 * 某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？<br/>
 * 答案是5瓶，<br/>
 * 方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。<br/>
 * 然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。<br/>
 * 如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？<br/>
 * <b>输入描述:</b><br/>
 * 输入文件最多包含10组测试数据，每个数据占一行，仅包含一个正整数n（1<=n<=100），表示小张手上的空汽水瓶数。n=0表示输入结束，你的程序不应当处理这一行。<br/>
 * <b>输出描述:</b><br/>
 * 对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。
 */


public class Main {
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int emptyBottleNum = 0;
        int sodaWaterNum = 0;
        int r = 0;
        while (in.hasNext()) {
            emptyBottleNum = in.nextInt();
            sodaWaterNum = 0;
            r = 0;
            if (emptyBottleNum == 0) {
                return;
            }

            while (true) {
                if (emptyBottleNum == 2) {
                    sodaWaterNum = 1;
                    emptyBottleNum = 0;
                } else {
                    sodaWaterNum = emptyBottleNum / 3;  //3   1
                    emptyBottleNum = emptyBottleNum % 3; //1  1
                    emptyBottleNum += sodaWaterNum;
                }
                r += sodaWaterNum;
                if (emptyBottleNum < 2) {
                    System.out.println(r);
                    break;
                }
            }
        }
    }


    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        int emptyBottleNum = 0;
        while (in.hasNext()) {
            emptyBottleNum = in.nextInt();
            if (emptyBottleNum == 0) {
                return;
            }
            System.out.println(changeSodaWater(emptyBottleNum));
        }
    }


    public static int changeSodaWater(int emptyBottleNum) {
        if (emptyBottleNum < 2) {
            return 0;
        } else if (emptyBottleNum == 2) {
            return 1;
        }
        return emptyBottleNum / 3 + changeSodaWater(emptyBottleNum / 3 + emptyBottleNum % 3);
    }


    //通过数学分析，最后获得的饮料数是总空瓶数整除2
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int emptyBottleNum = 0;
        while (in.hasNext()) {
            emptyBottleNum = in.nextInt();
            if (emptyBottleNum == 0) {
                return;
            }
            System.out.println(emptyBottleNum / 2);
        }
    }
}
