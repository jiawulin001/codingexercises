package leetcode.n120;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
     * <p>
     * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
     * 输出：11
     * 解释：如下面简图所示：
     * 2
     * 3 4
     * 6 5 7
     * 4 1 8 3
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     * 示例 2：
     * <p>
     * 输入：triangle = [[-10]]
     * 输出：-10
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= triangle.length <= 200
     * triangle[0].length == 1
     * triangle[i].length == triangle[i - 1].length + 1
     * -104 <= triangle[i][j] <= 104
     *  
     * <p>
     * 进阶：
     * <p>
     * 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/triangle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] parem = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};

        System.out.println(s.minimumTotal(s.getParam(parem)));
    }

    private List<List<Integer>> getParam(int[][] ints) {
        List<List<Integer>> array = new ArrayList<>();
        ArrayList<Integer> array2;
        for (int i = 0; i < ints.length; i++) {
            array2 = new ArrayList<>();
            for (int j = 0; j < ints[i].length; j++) {
                array2.add(ints[i][j]);
            }
            array.add(array2);
        }
        return array;
    }

    /**
     * 值：
     * [
     * [2]
     * [3,4]
     * [6,5,7]
     * [4,1,8,3]
     * ]
     * 坐标：
     * [
     * [0.0]
     * [1.0,1.1]
     * [2.0,2.1,2.2]
     * [3.0,3.1,3.2,3.3]
     * ]
     * <p>
     * 从最下面往上面累加，每次只计算最优的结果
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        int leftSum;
        int rightSum;

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                leftSum = triangle.get(i).get(j) + triangle.get(i + 1).get(j + 1);
                rightSum = triangle.get(i).get(j) + triangle.get(i + 1).get(j);
                triangle.get(i).set(j, Math.min(leftSum, rightSum));
            }
        }
        return triangle.get(0).get(0);
    }

    /**
     * 在上面的方式上面做状态压缩，把每次记录的下一层结果记录到一个一维数组即可
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        List<Integer> minSum = triangle.get(triangle.size() - 1);

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                minSum.set(j, triangle.get(i).get(j) + Math.min(minSum.get(j), minSum.get(j + 1)));
            }
        }
        return minSum.get(0);
    }


    //第一种方法的代码优化，去掉变量接收值，并且比较最小值不用先加
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
}