package leetcode.n84;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    /**
     * <p>谷歌面试题</p>
     * <p>给一个数组，返回一个大小相同的数组。</p>
     * <p>返回的数组的第i个位置的值应当是，对于原数组中的第i个元素至少往右走多少步，才能遇到一个比自己大的元素</p>
     * <p>（如果之后没有比自己大的元素，或者已经是最后一个元素，则在返回数组的对应位置放上-1）。</p>
     * <p示例：</p>
     * <pre>
     * input: 5,3,1,2,4
     * return: -1 3 1 1 -1
     * </pre>
     * <p>解释：</p>
     * <p>对于第0个数字5，之后没有比它更大的数字，因此是-1，</p>
     * <p>对于第1个数字3，需要走3步才能达到4（第一个比3大的元素），</p>
     * <p>对于第2和第3个数字，都只需要走1步，就可以遇到比自己大的元素。</p>
     * <p>对于最后一个数字4，因为之后没有更多的元素，所以是-1</p>
     */

    public static void main(String[] args) {
        int[] a = {5, 3, 1, 2, 4};
        int[] r = nextExceed3(a);
        Arrays.stream(r).forEach(n -> System.out.println(n));
    }


    /**
     * 暴力法
     */
    public static int[] nextExceed1(int[] input) {
        int[] r = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            r[i] = -1;
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] < input[j]) {
                    r[i] = j - i;
                    break;
                }
            }
        }
        return r;
    }

    public static int[] nextExceed(int[] input) {
        int[] r = new int[input.length];
        Deque<Integer> stack = new ArrayDeque<>(input.length);

        for (int i = 0; i < input.length; i++) {
            r[i] = -1;
            while (!stack.isEmpty() && input[i] < input[stack.peek()]) {
                r[i] = stack.pop() - i;
            }
            stack.push(i);
        }

        return r;
    }


    /**
     * 别人写的单调栈
     */
    public static int[] nextExceed3(int[] input) {
        int[] result = new int[input.length];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>(input.length);
        for (int i = 0; i < input.length; i++) {
            while (!stack.isEmpty() && input[i] > input[stack.peek()]) {
                int top = stack.pop();
                result[top] = i - top;
            }
            stack.push(i);
        }
        return result;

    }
}
