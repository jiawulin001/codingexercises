package nowcoder.hj93;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        int length;
        Scanner in = new Scanner(System.in);
        List<Integer> numbers;
        int sum5, sum3, total, sum;
        int num;

        while (in.hasNext()) {
            total = 0;
            sum5 = 0;
            sum3 = 0;
            sum = 0;
            length = in.nextInt();
            numbers = new ArrayList<>(length);

            for (int i = 0; i < length; i++) {
                num = in.nextInt();
                if (num % 5 == 0) {
                    sum5 += num;
                } else if (num % 3 == 0) {
                    sum3 += num;
                } else {
                    sum += num;
                    numbers.add(num);
                }
                total += num;
            }

            num = total / 2 - sum5;

            if ((sum - num) == (total / 2 - sum3)) {
                System.out.println(chooseNumbers(numbers, num, 0));
            } else {
                System.out.println(false);
            }
        }
    }

    //可以先给number排序，然后观察到当前递减的值已经超过了就不用往后了
    private static boolean chooseNumbers(List<Integer> numbers, int number, int index) {
        if (number == 0) {
            return true;
        } else if (index == numbers.size()) {
            return false;
        }
        boolean b1 = chooseNumbers(numbers, number - numbers.get(index), index + 1);
        boolean b2 = chooseNumbers(numbers, number, index + 1);
        return b1 || b2;
    }


    private static void test(int[] number, int a) {
        for (int i = 0; i < number.length; i++) {

        }
    }

    public static void main1(String[] args) {
        int a = 2;
        int b = -1;
        System.out.println(Math.abs(a - b));
        System.out.println(Math.abs(b - a));
    }


    private static boolean pro(Vector<Vector<Integer>> all, Vector<Integer> v, int index, int[] array) {
        v.add(array[index]);
        int sum = sum(v);
        if (sum <= 43) {
            if (sum == 43) {
                all.add((Vector<Integer>) v.clone());
                v.remove(v.size() - 1);
                return true;
            }
            for (int i = index + 1; i < array.length; i++) {
                if (!pro(all, v, i, array)) {
                    break;
                }
            }
            v.remove(v.size() - 1);
            return true;
        } else {
            v.remove(v.size() - 1);
            return false;
        }
    }

    private static int sum(Vector<Integer> v) {
        int sum = 0;
        for (int i = 0; i < v.size(); i++) {
            sum += v.get(i);
        }
        return sum;
    }

    public static void main2111(String arg[]) {

        Vector<Vector<Integer>> all = new Vector<Vector<Integer>>();
        //int[] array = new int[]{460, 588, 720, 1250, 1800, 2200, 3080, 4100,4375, 5184, 6510, 6900, 9000};

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < array.length; i++) {
            Vector<Integer> v = new Vector<Integer>();
            pro(all, v, i, array);
        }
        for (int i = 0; i < all.size(); i++) {
            System.out.println(all.get(i).toString());
        }
    }

    private static boolean dfs(int[] bag, int target, int i) {
        if (target == 0) return true;
        if (i == bag.length) return false;
        // dfs搜索，对每个元素，选择或者放弃
        boolean b1, b2;
        b1 = dfs(bag, target, i + 1);
        b2 = dfs(bag, target - bag[i], i + 1);

        return b1 || b2;
    }

    public static void main1212(String[] args) {
        //int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        //System.out.println(dfs(array, 43, 0));
        int[] array = new int[]{460, 588, 720, 1250, 1800, 2200, 3080, 4100, 4375, 5184, 6510, 6900, 9000};
        System.out.println(dfs(array, 13750, 0));

    }

}

