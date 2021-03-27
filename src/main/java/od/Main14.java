package od;

import java.util.Scanner;
import java.util.Stack;

public class Main14 {

    /**
     * <h1>仿LISP运算</h1>
     * LISP语言唯一的语法就是括号要配对<br>
     * 形如（OP P1 P2。。。。）括号内元素由单个空格分隔<br>
     * 其中第一个元素OP为操作符，后续元素均为其参数，参数个数取决于操作符类型<br>
     * 注意：参数P1 P2也可能是另一个嵌套的(OP P1 P2…)<br>
     * 当前OP类型为add/sub/mul/div（全小写），分别代表整数的加减乘除法<br>
     * 简单起见，所有OP参数个数均为2<br>
     * <h2>举例：</h2>
     * 输入：（mul 3 -7）输出：-21<br>
     * 输入：（add 1 2）输出：3<br>
     * 输入：（sub (mul 2 4)(div 9 3)）输出：5<br>
     * 输入：（div 10）输出：error<br>
     * 题目涉及数字均为整数，可能为负；不考虑32位溢出翻转，<br>
     * 除零错误时，输入“error”，除法遇除不尽，向下取整，即3/2=1<br>
     * <h2>输入描述：</h2>
     * 输入位长度不超过512个字符串，用例保证了无语法错误
     * <h2>输出描述：</h2>
     * 输出计算结果或者error
     *
     * <h2>示例1：</h2>
     * <h3>输入</h3>
     * （div 12 (sub 45 45)）
     * <h3>输出</h3>
     * error
     */
    public static void main(String[] args) {
        String input = "(div 12 (sub 45 42))";
        Scanner in = new Scanner(input);

        System.out.println(calc(in.nextLine()));
    }


    private static String calc(String str) {
        //add/sub/mul/div
        Stack stack = new Stack();
        String tempStr;
        for (int i = 0; i < str.length(); i++) {
            if ('a' == str.charAt(i)) {
                stack.push('+');
                i += 2;
            } else if ('s' == str.charAt(i)) {
                stack.push('-');
                i += 2;
            } else if ('m' == str.charAt(i)) {
                stack.push('*');
                i += 2;
            } else if ('d' == str.charAt(i)) {
                stack.push('/');
                i += 2;
            } else if ('(' == str.charAt(i)) {
                stack.push('(');
            } else if (isNumber(str.charAt(i))) {
                tempStr = "" + str.charAt(i);
                i++;
                while (isNumber(str.charAt(i))) {
                    tempStr += str.charAt(i);
                    i++;
                }
                i--;
                stack.push(Integer.valueOf(tempStr));
            } else if (')' == str.charAt(i)) {
                int num1 = (int) stack.pop();
                int num2 = (int) stack.pop();
                //除零错误时，输入“error”，除法遇除不尽，向下取整，即3/2=1
                switch ((char) stack.pop()) {
                    case '+':
                        stack.pop();
                        stack.push(num2 + num1);
                        break;
                    case '-':
                        stack.pop();
                        stack.push(num2 - num1);
                        break;
                    case '*':
                        stack.pop();
                        stack.push(num2 * num1);
                        break;
                    case '/':
                        if (num1 == 0) {
                            return "error";
                        }
                        stack.pop();
                        stack.push((int) (num2 / num1));
                        break;
                }
            }
        }
        return stack.pop().toString();
    }


    private static boolean isNumber(char c) {
        return '0' <= c && '9' >= c;
    }
}

