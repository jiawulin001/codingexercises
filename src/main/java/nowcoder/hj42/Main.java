package nowcoder.hj42;

public class Main {

    //Jessi初学英语，为了快速读出一串数字，编写程序将数字转换成英文：
    //如22：twenty two，123：one hundred and twenty three。
    //说明：
    //数字为正整数，长度不超过九位，不考虑小数，转化结果为英文小写；
    //输出格式为twenty two；
    //非法数据请返回“error”；
    //关键字提示：and，billion，million，thousand，hundred。
    public static void main(String[] args) throws Exception {
        //1 2 3 4 5 6 7 8 9
        //length == 2
        //length == 3 hundred
        //length == 4 thousand hundred and
        //length == 5 million thousand hundred and
        //length == 6 billion million thousand hundred and

        String ones[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String tens[] = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nighteen"};
        String twenties[] = {"zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String hundreds[] = {"hundred", "thousand", "million", "billion"};

    }
}
