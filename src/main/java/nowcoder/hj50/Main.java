package nowcoder.hj50;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.*;
import java.util.function.BiFunction;

public class Main {
    public static void main1(String[] args) throws ScriptException {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String expression = in.nextLine();
            //System.out.println(calc(expression));
            calcByEval(expression);
        }
    }

    //使用java eval方法
    private static void calcByEval(String expression) throws ScriptException {
        expression = expression.replaceAll("\\{", "(");
        expression = expression.replaceAll("\\[", "(");
        expression = expression.replaceAll("\\]", ")");
        expression = expression.replaceAll("\\}", ")");
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine se = sem.getEngineByName("js");
        System.out.println(se.eval(expression));
    }


    private static int calc1(String expression) {
        Stack<Character> s1 = new Stack<>();
        List<Object> s2 = new ArrayList<>();
        char ch;
        for (int i = 0; i < expression.length(); i++) {
            ch = expression.charAt(i);

            //  if("-" == ch){//}

            //if (s1.isEmpty()) {
            //  s1.push(ch);
            //}

            if (ch >= '0' && ch <= 9) {
                s2.add(ch);
            } else if (ch == '+' || ch == '-') {
                if (s1.peek() == '*' || s1.peek() == '/') {

                }
            } else if (ch == '*' || ch == '/') {

            } else if (ch == '{' || ch == '[' || ch == '(') {
                s1.push(ch);
            } else if (ch == '}') {
                while (!s1.isEmpty()) {
                    s2.add(s1.pop());
                    if (s1.peek() == '{') {
                        s1.pop();
                        break;
                    }
                }
            } else if (ch == ']') {
                while (!s1.isEmpty()) {
                    s2.add(s1.pop());
                    if (s1.peek() == ']') {
                        s1.pop();
                        break;
                    }
                }
            } else if (ch == ')') {
                while (!s1.isEmpty()) {
                    s2.add(s1.pop());
                    if (s1.peek() == ')') {
                        s1.pop();
                        break;
                    }
                }
            }
        }
        return 0;
    }


    //+, -, *, /, (, )
    private static int calc2(String expression) {
        expression = expression.replaceAll("\\{", "(");
        expression = expression.replaceAll("\\[", "(");
        expression = expression.replaceAll("\\]", ")");
        expression = expression.replaceAll("\\}", ")");

        Stack<Character> stack = new Stack<>();
        List<Character> exp = new ArrayList<>();

        char[] c = expression.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= '0' && c[i] <= '9') {
                exp.add(c[i]);
            } else if (c[i] == '-' && (i == 0 || !(c[i - 1] >= '0' && c[i - 1] <= '9'))) {
                exp.add('0');
                exp.add(c[i + 1]);
                exp.add('-');
                i++;
            } else if (c[i] == '+' || c[i] == '-') {
                if (stack.empty()) {
                    stack.push(c[i]);
                } else if (stack.peek() == '*' || stack.peek() == '/') {
                    while (!stack.empty() && (stack.peek() == '*' || stack.peek() == '/')) {
                        exp.add(stack.pop());
                    }
                    stack.push(c[i]);
                } else {
                    stack.push(c[i]);
                }
            } else if (c[i] == '*' || c[i] == '/') {
                stack.push(c[i]);
            } else if (c[i] == '(') {
                stack.push(c[i]);
            } else if (c[i] == ')') {
                while (!stack.empty()) {
                    if (stack.peek() != '(') {
                        exp.add(stack.pop());
                    } else {
                        stack.pop();
                        break;
                    }
                }
            }
        }

        while (!stack.empty()) {
            exp.add(stack.pop());
        }

        exp.forEach(chr -> System.out.print(chr));
        System.out.println();


        Stack<Integer> number = new Stack<>();
        int temp = 0;

        for (int i = 0; i < exp.size(); i++) {
            if (exp.get(i) == '+') {
                number.push(number.pop() + number.pop());
            } else if (exp.get(i) == '-') {
                temp = number.pop();
                number.push(number.pop() - temp);
            } else if (exp.get(i) == '*') {
                number.push(number.pop() * number.pop());
            } else if (exp.get(i) == '/') {
                temp = number.pop();
                number.push(number.pop() / temp);
            } else {
                number.push(Integer.valueOf(exp.get(i) + ""));
            }
        }

        return number.pop();
    }


    //+, -, *, /, (, )
    private static int calc3(String expression) {
        expression = expression.replaceAll("\\{", "(");
        expression = expression.replaceAll("\\[", "(");
        expression = expression.replaceAll("\\]", ")");
        expression = expression.replaceAll("\\}", ")");

        Stack<Character> stack = new Stack<>();
        List<Character> exp = new ArrayList<>();

        HashMap<Character, Integer> level = new HashMap<>();
        level.put('(', 0);
        level.put('+', 1);
        level.put('-', 1);
        level.put('*', 2);
        level.put('/', 2);


        char[] c = expression.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= '0' && c[i] <= '9') {
                exp.add(c[i]);
            } else if (c[i] == '-' && (i == 0 || !(c[i - 1] >= '0' && c[i - 1] <= '9'))) {
                exp.add('0');
                exp.add(c[i + 1]);
                exp.add('-');
                i++;
            } else if (c[i] == '(') {
                stack.push(c[i]);
            } else if (c[i] == ')') {
                while (stack.peek() != '(') {
                    exp.add(stack.pop());
                }
                stack.pop();
            } else {
                if (stack.empty()) {
                    stack.push(c[i]);
                } else {
                    //          System.out.println(stack.peek());
                    while (!stack.empty() && level.get(stack.peek()) >= level.get(c[i])) {
                        exp.add(stack.pop());
                    }
                    stack.push(c[i]);
                }
            }
        }

        while (!stack.empty()) {
            exp.add(stack.pop());
        }

        //exp.forEach(chr -> System.out.print(chr));
        //System.out.println();


        Stack<Integer> number = new Stack<>();
        int temp = 0;

        for (int i = 0; i < exp.size(); i++) {
            if (exp.get(i) == '+') {
                number.push(number.pop() + number.pop());
            } else if (exp.get(i) == '-') {
                temp = number.pop();
                number.push(number.pop() - temp);
            } else if (exp.get(i) == '*') {
                number.push(number.pop() * number.pop());
            } else if (exp.get(i) == '/') {
                temp = number.pop();
                number.push(number.pop() / temp);
            } else {
                number.push(Integer.valueOf(exp.get(i) + ""));
            }
        }

        return number.pop();
    }

    private static int calc(String expression) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> exp = new Stack<>();

        HashMap<Character, Integer> level = new HashMap<>();
        level.put('(', 0);
        level.put('+', 1);
        level.put('-', 1);
        level.put('*', 2);
        level.put('/', 2);

        HashMap<Character, BiFunction<Integer, Integer, Integer>> opt = new HashMap<>();
        opt.put('+', (n1, n2) -> n1 + n2);
        opt.put('-', (n1, n2) -> n1 - n2);
        opt.put('*', (n1, n2) -> n1 * n2);
        opt.put('/', (n1, n2) -> n1 / n2);

        char[] c = expression.toCharArray();
        String number;
        int tempNum;
        for (int i = 0; i < c.length; i++) {
            //是数字，或者已‘-’开头，并且前面不是数字也不是括号，那么这个就是一个负数了
            if ((c[i] >= '0' && c[i] <= '9') ||
                    (c[i] == '-' && (i == 0 ||
                            (!(c[i - 1] == ')' || c[i - 1] == ']' || c[i - 1] == '}') &&
                                    !(c[i - 1] >= '0' && c[i - 1] <= '9'))))) {
                number = c[i] + "";
                while (i < c.length - 1 && c[i + 1] >= '0' && c[i + 1] <= '9') {
                    number += c[i + 1];
                    i++;
                }
                exp.push(Integer.valueOf(number));
            } else if (c[i] == '(' || c[i] == '[' || c[i] == '{') {
                stack.push('(');
            } else if (c[i] == ')' || c[i] == ']' || c[i] == '}') {
                while (stack.peek() != '(') {
                    tempNum = exp.pop();
                    tempNum = opt.get(stack.pop()).apply(exp.pop(), tempNum);
                    exp.push(tempNum);
                }
                stack.pop();
            } else {
                if (stack.empty()) {
                    stack.push(c[i]);
                } else {
                    while (!stack.empty() && level.get(stack.peek()) >= level.get(c[i])) {
                        tempNum = exp.pop();
                        tempNum = opt.get(stack.pop()).apply(exp.pop(), tempNum);
                        exp.push(tempNum);
                    }
                    stack.push(c[i]);
                }
            }
        }
        while (!stack.isEmpty()) {
            tempNum = exp.pop();
            tempNum = opt.get(stack.pop()).apply(exp.pop(), tempNum);
            exp.push(tempNum);
        }

        return exp.pop();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(calc2(scanner.nextLine())
            );
        }
    }
}
