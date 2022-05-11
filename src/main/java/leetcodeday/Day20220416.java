package leetcodeday;

import java.util.*;

/**
 * 479. 最大回文数乘积
 * https://leetcode-cn.com/problems/largest-palindrome-product/
 * 给定一个整数 n ，返回 可表示为两个 n 位整数乘积的 最大回文整数 。因为答案可能非常大，所以返回它对 1337 取余 。
 * 1 <= n <= 8
 */
public class Day20220416 {

    public static void main1(String[] args) {
        List<int[]> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 999; i >= 100; i--) {
            for (int j = 999; j >= 100; j--) {
                if (strEquals(i * j + "")) {
                    if (!set.contains(i * j)) {
                        list.add(new int[]{i, j, i * j});
                        set.add(i * j);
                    }
                    //System.out.println(i + "*" + j + "=" + i * j);
                }
            }
        }

        list.sort((int[] n1, int[] n2) -> {
            return n2[2] - n1[2];
        });

        list.forEach(n -> System.out.println(n[2] + "\t" + n[0] + "\t" + n[1]));
    }


    public int largestPalindrome1(int n) {
        if (n == 1) {
            return 9;
        }
        int upper = (int) Math.pow(10, n) - 1;
        int ans = 0;
        for (int left = upper; ans == 0; --left) { // 枚举回文数的左半部分
            long p = left;
            for (int x = left; x > 0; x /= 10) {
                p = p * 10 + x % 10; // 翻转左半部分到其自身末尾，构造回文数 p
            }
            for (long x = upper; x * x >= p; --x) {
                if (p % x == 0) { // x 是 p 的因子
                    ans = (int) (p % 1337);
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Day20220416 test = new Day20220416();
        System.out.println(9 == test.largestPalindrome(1));
        System.out.println(987 == test.largestPalindrome(2));
        System.out.println(123 == test.largestPalindrome(3));
        System.out.println(597 == test.largestPalindrome(4));
        System.out.println(677 == test.largestPalindrome(5));
        System.out.println(1218 == test.largestPalindrome(6));
        System.out.println(877 == test.largestPalindrome(7));
        System.out.println(475 == test.largestPalindrome(8));
    }


    public int largestPalindrome(int n) {

        if (n == 1) {
            return 9;
        }

        long log = (long) (Math.pow(10, n) - 1);

        for (long i = log; ; i--) {
            long num = getPalindrome(i);

            for (long j = log; j * j >= num; j--) {
                if (num % j == 0) {
                    return (int) (num % 1337);
                }
            }
        }
    }

    private Long getPalindrome(long num) {
        String numString = num + "";
        int length = numString.length();
        char[] chars = Arrays.copyOf(numString.toCharArray(), length * 2);

        for (int i = 0; i < length; i++) {
            chars[i + length] = numString.charAt(length - i - 1);
        }

        return Long.valueOf(new String(chars));
    }

    public int largestPalindrome222(int n) {
        int[] nums = getStartAndEnd(n);
        String sumStr = "";
        Long max = 0l;
        Long temp;
        for (int i = nums[1]; i >= nums[0]; i--) {
            for (int j = nums[1]; j >= nums[0]; j--) {
                temp = Long.valueOf(i) * j;
                sumStr = temp + "";
                if (strEquals(sumStr)) {
                    if (max > temp) {
                        break;
                    }
                    max = temp;
                }
            }
        }

        // System.out.println(sumStr);
        return (int) (max % 1337);
    }

    private int[] getStartAndEnd(int n) {
        switch (n) {
            case 1:
                return new int[]{1, 9};
            case 2:
                return new int[]{10, 99};
            case 3:
                return new int[]{100, 999};
            case 4:
                return new int[]{1000, 9999};
            case 5:
                return new int[]{10000, 99999};
            case 6:
                return new int[]{100000, 999999};
            case 7:
                return new int[]{1000000, 9999999};
            default:
                return new int[]{10000000, 99999999};
        }
    }

    private static boolean strEquals(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
