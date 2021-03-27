package nowcoder.hj67;

import java.util.Scanner;
import java.util.Stack;

public class Main1 {

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] numbers;
        while (in.hasNext()) {
            numbers = new int[]{in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()};
            System.out.println(dfs(numbers, 0, 0));
        }
    }


    private static boolean dfs(int[] numbers, int index, int sum) {
        if (index == numbers.length) {
            return sum == 24;
        }

        for (int i = 0; i < 4; i++) {
            return dfs(numbers, i, sum + numbers[index]) ||
                    dfs(numbers, i, sum - numbers[index]) ||
                    dfs(numbers, i, numbers[index] * sum) ||
                    (sum != 0 && dfs(numbers, i, numbers[index] / sum));

        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] temp = new int[4];
        //dd(a, temp, "");
        perm(a,new Stack<>());
    }

    private static void dd(int[] a, int[] temp, String str) {
        if (temp[0] + temp[1] + temp[2] + temp[3] == 4) {
            System.out.println(str);
        }
        for (int i = 0; i < a.length; i++) {
            if (temp[i] == 0) {
                temp[i] = 1;
                dd(a, temp, str + "\t" + a[i]);
                temp[i] = 0;
            }
        }

        return;
    }

    public static void perm(int[] array, Stack<Integer> stack) {
        if (array.length <= 0) {
            //进入了叶子节点，输出栈中内容
            System.out.println(stack);
        } else {
            for (int i = 0; i < array.length; i++) {
                //tmepArray是一个临时数组，用于就是Ri
                //eg：1，2，3的全排列，先取出1，那么这时tempArray中就是2，3
                int[] tempArray = new int[array.length - 1];
                System.arraycopy(array, 0, tempArray, 0, i);
                System.arraycopy(array, i + 1, tempArray, i, array.length - i - 1);
                stack.push(array[i]);
                perm(tempArray, stack);
                stack.pop();
            }
        }
    }
}
