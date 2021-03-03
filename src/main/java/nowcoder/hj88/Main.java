package nowcoder.hj88;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static String[] pai = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2", "joker", "JOKER"};
    private static Map<String, Integer> level = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        String[] strs;
        String[] strs2;
        putValue("3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2", "joker", "JOKER");

        while ((str = in.readLine()) != null) {
            strs = str.split("-");
            strs2 = strs[1].split(" ");
            strs = strs[0].split(" ");

            //是否炸弹
            strs = getType(strs);
            strs2 = getType(strs2);//
            if ("zd".equals(strs[0]) || "zd".equals(strs2[0])) {
                if ("JOKER".equals(strs[1]) || "JOKER".equals(strs2[1])) {
                    System.out.println("joker JOKER");
                } else if ("zd".equals(strs[0]) && !"zd".equals(strs2[0])) {
                    System.out.printf("%s %s %s %s\n", strs[1], strs[1], strs[1], strs[1]);
                } else if (!"zd".equals(strs[0]) && "zd".equals(strs2[0])) {
                    System.out.printf("%s %s %s %s\n", strs2[1], strs2[1], strs2[1], strs2[1]);
                } else {
                    if (level.get(strs[1]) < level.get(strs2[1])) {
                        strs[1] = strs2[1];
                    }
                    System.out.printf("%s %s %s %s\n", strs[1], strs[1], strs[1], strs[1]);
                }

            } else if ("sz".equals(strs[0]) && "sz".equals(strs2[0])) {
                //是否顺子
                if (level.get(strs[1].split(" ")[0]) < level.get(strs2[1].split(" ")[0])) {
                    strs[1] = strs2[1];
                }
                System.out.printf("%s\n", strs[1]);
            } else if ("sg".equals(strs[0]) && "sg".equals(strs2[0])) {
                //是否三个
                if (level.get(strs[1]) < level.get(strs2[1])) {
                    strs[1] = strs2[1];
                }
                System.out.printf("%s %s %s\n", strs[1], strs[1], strs[1]);
            } else if ("dz".equals(strs[0]) && "dz".equals(strs2[0])) {
                //是否对子
                if (level.get(strs[1]) < level.get(strs2[1])) {
                    strs[1] = strs2[1];
                }
                System.out.printf("%s %s\n", strs[1], strs[1]);
            } else if ("dp".equals(strs[0]) && "dp".equals(strs2[0])) {
                //是否单张
                if (level.get(strs[1]) < level.get(strs2[1])) {
                    strs[1] = strs2[1];
                }
                System.out.printf("%s\n", strs[1]);
            } else {
                System.out.println("ERROR");
            }
        }
    }

    private static void putValue(String... vals) {
        for (int i = 0; i < vals.length; i++) {
            level.put(vals[i], i);
        }
    }

    private static String[] getType(String[] str) {
        int max = 0;
        int[] count = new int[15];
        int i;
        for (i = 0; i < str.length; i++) {
            count[level.get(str[i])] += 1;
            if (count[level.get(str[i])] > count[max]) {
                max = level.get(str[i]);
            }
        }

        if (count[13] == 1 && count[14] == 1) {
            return new String[]{"zd", "JOKER"};
        }

        if (count[max] == 4) {
            return new String[]{"zd", pai[max]};//炸弹
        } else if (count[max] == 3) {
            return new String[]{"sg", pai[max]};//三个
        } else if (count[max] == 2) {
            return new String[]{"dz", pai[max]};//对子
        } else {
            int beginIndex = 0;
            int endIndex = 0;
            for (int j = 0; j < count.length; j++) {
                if (count[j] == 1) {
                    endIndex = j;
                    max = j;
                } else if (endIndex - beginIndex >= 4) {
                    break;
                } else {
                    beginIndex = j + 1;
                }
            }
            StringBuffer sz = new StringBuffer();
            if (endIndex - beginIndex >= 4) {
                for (int j = beginIndex; j <= endIndex; j++) {
                    sz.append(pai[j]);
                    sz.append(" ");
                }
                sz.delete(sz.length() - 1, sz.length());
                return new String[]{"sz", sz.toString()};//单牌
            }
            return new String[]{"dp", pai[max]};//单牌
        }
    }
}
