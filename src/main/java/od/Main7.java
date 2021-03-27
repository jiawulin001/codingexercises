package od;

public class Main7 {
    /**
     * <h1>玩牌高手</h1>
     * 给定一个长度位N的整型数组，表示一个选手在n轮内可选择的牌面分数。选手基于规则选牌，请计算所有轮结束后其可以获得的最高分数。选择规则如下：<br>
     * <li>在每轮里选手可以选择获取该轮牌面，则其总分数加上该轮牌面分数，为其新的总分数</li>
     * <li>选手也可不选择本轮牌面直接跳到下一轮，此时将当前总分是还原位3轮钱的总分数，若当前轮次小于等于3（即在第一、二、三轮选择跳过轮次），则总分数置位0</li>
     * <li>选手的初始总分数位0，且必须依次参见每一轮。</li>
     * <h2>输入描述：</h2>
     * <li>第一行位一个小写逗号分隔的字符串，表示n轮的牌面分数，1<=n<=20</li>
     * <li>分数值位整数，-100<=分数值<=100</li>
     * <li>不考虑个数问题</li>
     * <h2>输出描述：</h2>
     * 所有轮结束后选手获得的最高总分数。
     *
     * <h2>示例1：</h2>
     * <h3>输入</h3>
     * 1，-5，-6，4，3，6，-2
     * <h3>输出</h3>
     * 11
     */
    public static void main(String[] args) {
        //int[] numbers = {1, -5, -6, 4, 3, 6, -2};
        //int[] numbers = {6,4,0,-9,6,6,-5,9,5,-8};
        int[] numbers = {6,4,0,-9,6,6,-5,9,5,-8};
        System.out.println(choose(numbers));
        //main1(args);
    }


    //testcase
    public static void main1(String[] args) {
        //int[] numbers = {1, -5, -6, 4, 3, 6, -2};
        //int[] numbers = {1, -5, -6, 4, 3, 6, -2};

        //System.out.println(choose(numbers));
        int n;
        for (int i = 0; i < 10; i++) {
            n = (int) (Math.random() * 10);
            if (n % 2 == 0) {
                System.out.print(0 - (int) (Math.random() * 10));
            } else {
                System.out.print((int) (Math.random() * 10));
            }
            System.out.print(",");
        }
    }

    private static int choose(int[] numbers) {
        return dfs(numbers, 0, 0, "");
    }


    private static int dfs(int[] numbers, int index, int curr, String flag) {
        if (index >= numbers.length) {
            return curr;
        }

        int number = dfs(numbers, index + 1, curr + numbers[index], flag + "1");

        int three = 0;
        if (index > 2) {
            for (int i = 0; i < flag.length() - 2; i++) {
                if (flag.charAt(i) == '1') {
                    three += numbers[i];
                }
            }
        }

        int number2 = dfs(numbers, index + 1, three, flag + "0");

        return Math.max(number, number2);
    }

}

