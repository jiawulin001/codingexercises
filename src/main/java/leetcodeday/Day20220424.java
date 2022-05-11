package leetcodeday;

/**
 * https://leetcode-cn.com/problems/binary-gap/
 * 868. 二进制间距
 */
public class Day20220424 {
    public static void main(String[] args) {
        Day20220424 test = new Day20220424();
        System.out.println(2 == test.binaryGap(22));
        System.out.println(0 == test.binaryGap(8));
        System.out.println(2 == test.binaryGap(5));
    }

    //自己做的双指针  O(n)
    public int binaryGap1(int n) {
        String binaryStr = Integer.toBinaryString(n);

        int left = binaryStr.indexOf('1');
        int right = left + 1;
        if (left == -1) {
            return 0;
        }

        int result = 0;
        int length = binaryStr.length();
        while (right < length) {
            if ('1' == binaryStr.charAt(right)) {
                result = Math.max(right - left, result);
                left = right;
            }
            right++;
        }
        return result;
    }


    /**
     * 官方位运算 O(long n)
     */
    public int binaryGap(int n) {
        int last = -1, ans = 0;
        for (int i = 0; n != 0; ++i) {
            System.out.println(Integer.toBinaryString(n));
            if ((n & 1) == 1) {
                if (last != -1) {
                    ans = Math.max(ans, i - last);
                }
                last = i;
            }
            n >>= 1;
        }
        return ans;
    }
}
