package leetcodeday;

/**
 * https://leetcode-cn.com/problems/subarray-product-less-than-k/
 * 713. 乘积小于 K 的子数组
 */
public class Day20220505 {

    public static void main(String[] args) {
        Day20220505 test = new Day20220505();
        System.out.println(31 == test.numSubarrayProductLessThanK(new int[]{10, 2, 2, 5, 4, 4, 4, 3, 7, 7}, 289));
        System.out.println(18 == test.numSubarrayProductLessThanK(new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9
                , 3}, 19));

        System.out.println(8 == test.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(0 == test.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
    }


    /**
     * 自己做的，滑窗，每次有新的数加进来，组合数就多窗口数量种可能，有n位数组合的种数为：n*(n+1) / 2
     * 比如：5个数：5 4 3 2 1
     * 就是5 + 4 + 3 + 2 + 1，组合有：
     * 5 4 3 2 1
     * 5 4 3 2
     * 5 4 3
     * 5 4
     * 5
     * <p>
     * 4 3 2 1
     * 4 3 2
     * 4 3
     * 4
     * <p>
     * 3 2 1
     * 3 2
     * 3
     * <p>
     * 2 1
     * 2
     * <p>
     * 1
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;

        int product = 1;
        int lIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            if (product < k) {
                count += i - lIndex + 1;
            } else {
                while (lIndex < i) {
                    product /= nums[lIndex++];
                    if (product < k) {
                        count += i - lIndex + 1;
                        break;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 自己做的错误解答，无法找到全部组合，
     *
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        int count = -1;

        int leftIndex = 0;
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                count++;
            }
            product *= nums[i];
            if (product < k) {
                count++;
            } else {
                while (leftIndex < i) {
                    product /= nums[leftIndex++];
                    if (product < k && leftIndex < i) {
                        count++;
                        break;
                    }
                }
            }
        }


        while (leftIndex < nums.length - 1) {
            product /= nums[leftIndex++];
            if (leftIndex < nums.length - 1 && product < k) {
                count++;
                break;
            }
        }

        return count == -1 ? 0 : count;
    }
}
