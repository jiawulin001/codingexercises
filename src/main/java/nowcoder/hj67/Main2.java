package nowcoder.hj67;

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        int[] numbers = {7, 2, 1, 10};
        System.out.println(dfs(numbers, 0, 3, 0));
        //dfs(numbers, 0, 3);
    }


    private static boolean dfs(int[] numbers, int start, int j, int result) {
        boolean is24 = false;
        if (start == j + 1) {
            //Arrays.stream(numbers).forEach(num -> System.out.print(num + "\t"));
            return result == 24;
        }

        for (int i = start; i <= j; i++) {
            swap(numbers, start, i);

//            is24 = dfs(numbers, start + 1, j, result + numbers[start]) ||
//                    dfs(numbers, start + 1, j, result - numbers[start]) ||
//                    dfs(numbers, start + 1, j, start == 0 ? numbers[start] : result * numbers[start])
//                    || (numbers[i] != 0 && dfs(numbers, start + 1, j, result / numbers[start]));

            is24 = dfs(numbers, start + 1, j, result + numbers[start]) ||
                    dfs(numbers, start + 1, j, start == 0 ? numbers[start] : result * numbers[start]);


            swap(numbers, start, i);
        }
        return is24;
    }


    private static void dfs(int[] numbers, int start, int j) {
        if (start == j) {
            Arrays.stream(numbers).forEach(num -> System.out.print(num + "\t"));
            System.out.println();
        }

        for (int i = start; i <= j; i++) {
            swap(numbers, start, i);
            dfs(numbers, start + 1, j);
            swap(numbers, start, i);
        }
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
