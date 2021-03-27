package od;

import java.util.Scanner;

public class Main9 {

    /**
     * <h1>九宫格按键输入</h1>
     * 有英文和数字两个模式，默认是数字模式，数字模式直接输出数字，<br>
     * 英文模式连续按同一个按键会依次出现这个按键上的字母，<br>
     * 如果输入“/”或者其他字符，则循环中断，输出此时停留的字母。<br>
     * 数字和字母的对应关系如下，注意0只对应空格：<br>
     * <pre>
     *     1(,.)  2(abc) 3(def)
     *     4(ghi) 5(jkl) 6(mno)
     *     7(pqrs)8(tuv) 9(wxyz)
     *     # 0(空格) /
     * </pre>
     * 输入一串按键，要求输出屏幕显示
     *
     * <li>#用于切换模式，默认是数字模式，执行#后切换为英文模式；</li>
     * <li>/表示延迟，例如在英文模式，输入22/222,显示为bc,数字模式下/没有效果；</li>
     * <li>英文模式下，多次按同一键，例如输入22222，显示为b;</li>
     * <h2>输入描述：</h2>
     * 输入范围为数字0~9和字符# /，输出屏幕显示，例如，<br>
     * 在数字模式下，输入1234，显示1234<br>
     * 在英文模式下，输入1234，显示,adg<br>
     * <h2>输出描述：</h2>
     * 输出屏幕显示的字符
     * <h2>示例1：</h2>
     * <h3>输入</h3>
     * 2222/22
     * <h3>输出</h3>
     * 222222
     */
    public static void main(String[] args) {
        //String input = "2222/22";   #236444660#2019
        String input = "#236444/660#2019";
        Scanner in = new Scanner(input);

        char[][] keys = {{' '}, {',', '.'},
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}};

        int model = 0;//0：数字模式  1：英文模式

        int keyCount;
        String str;
        StringBuffer result;
        while (in.hasNext()) {
            str = in.next();
            keyCount = 0;
            result = new StringBuffer();
            for (int i = 0; i < str.length(); i++) {
                if ('0' <= str.charAt(i) && '9' >= str.charAt(i)) {
                    if (i > 0 && model == 1 && str.charAt(i - 1) == str.charAt(i)) {
                        keyCount++;
                    } else {
                        if (model == 1 && keyCount != 0) {
                            char[] key = keys[str.charAt(i - 1) - '0'];
                            result.append(key[keyCount % key.length]);
                            keyCount = 0;
                        } else if (i > 0 && model == 1 && '0' <= str.charAt(i - 1) && '9' >= str.charAt(i - 1)) {
                            result.append(keys[str.charAt(i - 1) - '0'][0]);
                            keyCount = 0;
                        } else if (model == 0) {
                            result.append(str.charAt(i));
                        }
                    }
                } else if ('#' == str.charAt(i) || '/' == str.charAt(i)) {
                    if (model == 1 && i > 0) {
                        char[] key = keys[str.charAt(i - 1) - '0'];
                        if (keyCount != 0) {

                            result.append(key[keyCount % key.length]);
                            keyCount = 0;
                        } else if (i > 0 && '0' <= str.charAt(i - 1) && '9' >= str.charAt(i - 1)) {
                            result.append(key[0]);
                        }
                    }
                }

                if ('#' == str.charAt(i)) {
                    model = model == 0 ? 1 : 0;
                }
            }

            if (model == 1 && '0' <= str.charAt(str.length() - 1) && '9' >= str.charAt(str.length() - 1)) {
                char[] key = keys[str.charAt(str.length() - 1) - '0'];
                if (keyCount != 0) {
                    result.append(key[keyCount % key.length]);
                } else {
                    result.append(key[0]);
                }
            }

            System.out.println(result.toString());
        }
    }

}

