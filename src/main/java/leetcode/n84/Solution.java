package leetcode.n84;

public class Solution {
    /**
     * <p>给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。</p>
     * <p>求在该柱状图中，能够勾勒出来的矩形的最大面积。</p>
     * <img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/histogram.png" />
     * <p>以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。</p>
     * <img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/12/histogram_area.png" />
     * <p>图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。</p>
     * <p>示例：</p>
     * <pre>
     * 输入: [2,1,5,6,2,3]
     * 输出: 10
     * </pre>
     */

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] case1 = {2, 1, 5, 6, 2, 3};
        System.out.println(s.largestRectangleArea(case1));
    }

    public int largestRectangleArea(int[] heights) {

        int width = 1;
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            width = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (heights[i] > heights[j]) {
                    break;
                }
                width++;
            }

            for (int k = i + 1; k < heights.length; k++) {
                if (heights[i] > heights[k]) {
                    break;
                }
                width++;
            }
            maxArea = Math.max(maxArea, heights[i] * width);
        }

        return maxArea;
    }
}
