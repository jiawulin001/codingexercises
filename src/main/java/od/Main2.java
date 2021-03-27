package od;

import java.util.Arrays;

public class Main2 {


    /**
     * <h1>题目描述</h1>
     * <P>输入一个字符串近包含大小写字母和数字</P>
     */
    public static void main(String[] args) {
        String[] str = {
                "abc2234019A33",
                "df12sdf5sdf89582",
                "125423aa154sdf528",
                "5154sdf42a21dasd4a",
                "f1215s2ff5a4sd1a",
                "aa125478asd",
                "bb11255585",
                "cc23125648"
        };

        Arrays.stream(str).forEach(s -> {
            System.out.println(count(s) + " :" + s);
        });

    }

    public static int count(String str) {
        int max = 0;
        int count = 1;
        boolean isNumber = false;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                if (isNumber) {
                    if (str.charAt(i) >= str.charAt(i - 1)) {
                        count++;
                    } else {
                        max = Math.max(max, count);
                        count = 1;
                    }
                }
                isNumber = true;
            } else {
                max = Math.max(max, count);
                count = 1;
                isNumber = false;
            }
        }

        return max;
    }
}
