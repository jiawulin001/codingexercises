package leetcode.n443;

import java.util.Arrays;

//@Slf4j
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] input = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int size = solution.compress(input);

        //case 1:6 ["a","2","b","2","c","3"]
        if (size == 6) {
            char[] res = Arrays.copyOfRange(input, 0, 6);
            boolean b = Arrays.equals(new char[]{'a', '2', 'b', '2', 'c', '3'}, res);
            if (b) {
                //               log.info("用例一正确");
                System.out.println("用例一正确");
            } else {
                // log.error("用例一错误");
                System.out.println("用例一错误");
            }

        } else {
            // log.error("用例一错误");
            System.out.println("用例一错误");
        }

        input = new char[]{'a'};
        size = solution.compress(input);
        //case2:1 ["a"]
        if (size == 1) {
            char[] res = Arrays.copyOfRange(input, 0, 1);
            boolean b = Arrays.equals(new char[]{'a'}, res);
            if (b) {
                System.out.println("用例二正确");
            } else {
                System.out.println("用例二错误");
            }

        } else {
            System.out.println("用例二错误");
        }

        input = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        size = solution.compress(input);
        //case3:4 ["a","b","1","2"]
        if (size == 4) {
            char[] res = Arrays.copyOfRange(input, 0, 4);
            boolean b = Arrays.equals(new char[]{'a', 'b', '1', '2'}, res);
            if (b) {
                System.out.println("用例三正确");
            } else {
                System.out.println("用例三错误");
            }

        } else {
            System.out.println("用例三错误");
        }
    }
}
