package leetcodeday;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/tag-validator/
 * 591. 标签验证器
 */
public class Day20220502 {
    public static void main(String[] args) {
        Day20220502 test = new Day20220502();
        System.out.println(!test.isValid("<A"));
        System.out.println(test.isValid("<A><A>456</A>  <A> 123  !!  <![CDATA[]]>  123 </A>   <A>123</A></A>"));
        System.out.println(!test.isValid("<A></A><B></B>"));
        System.out.println(!test.isValid("<![CDATA[wahaha]]]><![CDATA[]> wahaha]]>"));
        System.out.println(test.isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>"));
        System.out.println(test.isValid("<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>"));
        System.out.println(!test.isValid("<A>  <B> </A>   </B>"));
        System.out.println(!test.isValid("<DIV>  div tag is not closed  <DIV>"));
        System.out.println(!test.isValid("<DIV>  unmatched <  </DIV>"));
        System.out.println(!test.isValid("<DIV> closed tags with invalid tag name  <b>123</b> </DIV>"));
        String code = "<DIV> unmatched tags with invalid tag name  </1234567890> and <CDATA[[]]>  </DIV>";
        System.out.println(!test.isValid(code));
        System.out.println(!test.isValid("<DIV>  unmatched start tag <B>  and unmatched end tag </C>  </DIV>"));
    }

    //自己做的，就是模拟，根据字符判断下一个应该是什么
    public boolean isValid(String code) {
        if (code.length() < 3 || !(code.charAt(0) == '<' && 'A' <= code.charAt(1) && code.charAt(1) <= 'Z')) {
            return false;
        }

        Stack<String> stack = new Stack<>();

        int length = code.length();
        for (int i = 0; i < length; i++) {
            if (code.charAt(i) == '<') {
                //<TAG_NAME>
                if (i + 1 < length && 'A' <= code.charAt(i + 1) && code.charAt(i + 1) <= 'Z') {
                    //合法的 TAG_NAME 仅含有大写字母，长度在范围 [1,9] 之间
                    int j = 1;
                    while (i + j < length && 'A' <= code.charAt(i + j) && code.charAt(i + j) <= 'Z') {
                        if (j > 9) {
                            return false;
                        }
                        j++;
                    }
                    if (i + j < length && code.charAt(i + j) == '>') {
                        stack.push(code.substring(i + 1, i + j));
                        i = i + j;
                        continue;
                    }
                    return false;
                }
                //</TAG_NAME>
                else if (i + 1 < length && code.charAt(i + 1) == '/') {
                    String tagName = stack.pop();
                    if (i + tagName.length() + 2 < length) {
                        if (code.substring(i + 2, i + tagName.length() + 3).equals(tagName + ">")) {
                            i = i + tagName.length() + 2;
                            if (stack.isEmpty() && i + 1 < length) {
                                return false;
                            }
                            continue;
                        }
                    }
                    return false;
                }
                //<![CDATA[
                else if (i + 9 < length && "<![CDATA[".equals(code.substring(i, i + 9))) {
                    int j = 9;
                    boolean isCDATA = false;
                    while (i + j + 2 < length) {
                        if (code.charAt(i + j) == ']' && code.charAt(i + j + 1) == ']' && code.charAt(i + j + 2) == '>') {
                            i = i + j + 2;
                            isCDATA = true;
                            break;
                        }
                        j++;
                    }
                    if (isCDATA) {
                        continue;
                    }
                    return false;
                } else {
                    return false;
                }
            }
        }


        return stack.isEmpty();
    }
}
