package nowcoder.hj95;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Double rmb;
        String str;
        while (in.hasNext()) {
            //rmb = in.nextDouble();
            str = in.nextLine();
            rmb = Double.valueOf(str);
            if (str.indexOf('.') != -1) {
                str = str.substring(str.indexOf('.') + 1);
            } else {
                str = "";
            }
            System.out.println(changeDisplay(rmb, str));
        }
    }

    //151121.15
    //10012.02
    //人民币拾伍万壹仟壹佰贰拾壹元壹角伍分
    //人民币壹万零拾贰元贰分
    //个、十、百、千、万、十万、百万、千万、亿、十亿、百亿、千亿
    //1千2百3十4万5千6百
    private static String changeDisplay(Double rmb, String xs) {
        int tInt;

        String tStr = xs;
        String[] str = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        StringBuffer sb = new StringBuffer("人民币");

        String temStr = "";
        if (rmb >= 100000000) {
            tInt = ((Double) (rmb / 100000000)).intValue();
            sb.append(change(tInt));
            sb.append("亿");
            rmb -= tInt * 100000000;
            temStr = "零";
        }

        if (rmb >= 10000) {
            tInt = ((Double) (rmb / 10000)).intValue();
            sb.append(change(tInt));
            sb.append("万");
            rmb -= tInt * 10000;

            if (rmb.intValue() < 1000) {
                sb.append("零");
            }

        } else if (temStr.length() > 0) {
            sb.append(temStr);
        }

        sb.append(change(rmb.intValue()));

        if (sb.length() > 3) {
            sb.append("元");
        }

        if (!"".equals(tStr)) {
            boolean flag = false;
            if (tStr.length() == 1) {
                tStr += "0";
            }

            if (tStr.charAt(0) != '0') {
                sb.append(str[tStr.charAt(0) - '0']);
                sb.append("角");
                flag = true;
            }

            if (tStr.charAt(1) != '0') {
//                sb.append(str[tStr.charAt(0) - '0']);
//                if (tStr.charAt(0) != '0') {
//                    sb.append("角");
//                }
                sb.append(str[tStr.charAt(1) - '0']);
                sb.append("分");
                flag = true;
            }

            if (!flag) {
                sb.append("整");
            }

        } else {
            sb.append("整");
        }
        return sb.toString();
    }


    private static String change(int num) {
        String[] str = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        StringBuffer sb = new StringBuffer();
        int tInt = num;
        int number;
        String tStr = "";
        if (tInt >= 1000) {
            number = tInt / 1000;
            sb.append(str[number]);
            sb.append("仟");
            tInt -= number * 1000;
        }

        if (tInt >= 100) {
            number = tInt / 100;
            sb.append(str[number]);
            sb.append("佰");
            tInt -= number * 100;
        } else if (sb.length() > 0) {
            tStr = "零";
        }


        if (tInt >= 10) {
            number = tInt / 10;
            sb.append(tStr);
            sb.append(number == 1 ? "" : str[number]);
            sb.append("拾");
            tInt -= number * 10;
            tStr = "";
        } else if (sb.length() > 0) {
            tStr = "零";
        }


        if (tInt > 0) {
            sb.append(tStr);
            sb.append(str[tInt]);
        }
        return sb.toString();
    }
}
