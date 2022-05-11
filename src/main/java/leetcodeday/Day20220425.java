package leetcodeday;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/random-pick-index/solution/sui-ji-shu-suo-yin-by-leetcode-solution-ofsq/
 * 398. 随机数索引
 */
public class Day20220425 {
    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3, 3, 3});
        int[] input = new int[]{2, 3, 4};
        System.out.println(Arrays.binarySearch(input, solution.pick(3)) >= 0);
        System.out.println(0 == solution.pick(1));
    }
}


/**
 * 时间换空间
 * 官网题解：抽样法，只要考点抽样算法
 */
class Solution {
    int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        Random random = new Random();
        int count = 0;
        int result = 0;
        for (int i = 0; i < this.nums.length; i++) {
            if (nums[i] == target) {
                count++;
                // 该算法会保证这 kk 个元素的下标成为最终返回值的概率均为 i/k,证明过程：
                // =P(第i次随机选择的值=0)×P(第 i+1 次随机选择的值!=0)×⋯×P(第 k 次随机选择的值!=0)
                // =1/i * (1- 1/i+1) * ... * (1 - 1/k)
                // =1/i * i/i+1 * ... * k-1/k
                // =1/k
                if (random.nextInt(count) == 0) {
                    result = i;
                }
            }
        }
        return result;
    }
}

/**
 * HASH法，空间换时间
 */
class Solution2 {
    Map<Integer, List<Integer>> hashMap;

    public Solution2(int[] nums) {
        List<Integer> idx;
        this.hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            idx = hashMap.getOrDefault(nums[i], new ArrayList<>());
            idx.add(i);
            hashMap.put(nums[i], idx);
        }
    }

    public int pick(int target) {
        List<Integer> idx = hashMap.get(target);
        Random random = new Random();
        int index = random.nextInt(idx.size());
        return idx.get(index);
    }
}
