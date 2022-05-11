package leetcodeday;

/**
 * https://leetcode-cn.com/problems/projection-area-of-3d-shapes/
 * 883. 三维形体投影面积
 */
public class Day20220426 {
    public static void main(String[] args) {
        Day20220426 test = new Day20220426();
        System.out.println(17 == test.projectionArea(new int[][]{{1, 2}, {3, 4}}));
        System.out.println(5 == test.projectionArea(new int[][]{{2}}));
        System.out.println(8 == test.projectionArea(new int[][]{{1, 0}, {0, 2}}));
    }

    /**
     * 自己解答
     * xy就是有效格子数量
     * xz就是每一排最高格子的高度
     * yz就是每一列最高格子的高度
     */
    public int projectionArea(int[][] grid) {
        int xy = 0;

        int xz = 0;
        int countXZ;

        int yz = 0;
        int countYZ;

        for (int i = 0; i < grid.length; i++) {
            countXZ = 0;
            countYZ = 0;
            for (int j = 0; j < grid.length; j++) {
                if (0 != grid[i][j]) {
                    xy++;
                }

                // i和j调换顺序就能改变是按行迭代还是列迭代
                countXZ = Math.max(grid[i][j], countXZ);
                countYZ = Math.max(grid[j][i], countYZ);
            }
            xz += countXZ;
            yz += countYZ;
        }
        return xy + xz + yz;
    }
}
