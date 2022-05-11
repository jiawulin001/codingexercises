package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/intersection-of-multiple-arrays/
 * 2248. 多个数组求交集
 */
public class Leetcode2248 {

    /**
     * 自己做的，根据题目提示：
     * 1 <= nums[i][j] <= 1000
     * nums[i] 中的所有值 互不相同
     * <p>
     * 所以可以使用数组来计数处理
     */
    public List<Integer> intersection(int[][] nums) {
        List<Integer> result = new ArrayList<>();
        int[] map = new int[1001];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                map[nums[i][j]] += 1;
            }
        }

        for (int i = 0; i < map.length; i++) {
            if (map[i] == nums.length) {
                result.add(i);
            }
        }
        return result;
    }
}
