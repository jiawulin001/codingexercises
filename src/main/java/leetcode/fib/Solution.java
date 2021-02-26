package leetcode.fib;

public class Solution {

    static int[] cache = new int[261];

    public static void main(String[] args) {
        long currTime = System.currentTimeMillis();
        System.out.println(fib(260));
        System.out.println(System.currentTimeMillis() - currTime);
        cache = null;
        currTime = System.currentTimeMillis();
        System.out.println(fun(260));
        System.out.println(System.currentTimeMillis() - currTime);
    }


    private static int fib(int num) {
        if (cache[num] == 0) {
            cache[num] = num <= 1 ? num : fib(num - 1) + fib(num - 2);
        }
        return cache[num];
    }

    private static int fun(int num) {
        int[] array = new int[num + 1];

        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= num; i++) {
            array[i] = array[i - 2] + array[i - 1];
        }
        return array[num];
    }

}
