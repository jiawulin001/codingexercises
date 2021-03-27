package leetcode.n994;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        //int[][] sg = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int[][] sg = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        //int[][] sg = {{0,2}};
        Solution s = new Solution();
        System.out.println(s.orangesRotting(sg));

    }


    public int orangesRotting(int[][] grid) {
        int count = 1;
        int orangesCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    orangesCount++;
                }
            }
        }

        if (orangesCount == 0) {
            return 0;
        }

        int[][] copyGrid;
        int num;
        while (true) {
            num = 0;
            copyGrid = arrayCopy(grid);
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 2) {
                        num += change(copyGrid, i, j);
                    }
                }
            }
            if (num == 0) {
                return -1;
            }
            orangesCount -= num;
            if (orangesCount == 0) {
                return count;
            }
            grid = copyGrid;
            count++;
        }
    }


    private int change(int[][] grid, int i, int j) {
        int count = 0;
        if (i > 0 && grid[i - 1][j] == 1) {
            grid[i - 1][j] = 2;//上
            count++;
        }

        if (i < grid.length - 1 && grid[i + 1][j] == 1) {
            grid[i + 1][j] = 2;//下
            count++;
        }

        if (j > 0 && grid[i][j - 1] == 1) {
            grid[i][j - 1] = 2;//左
            count++;
        }

        if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
            grid[i][j + 1] = 2;//右
            count++;
        }
        return count;
    }

    private int[][] arrayCopy(int[][] original) {
        int[][] copyArray = new int[original.length][original[0].length];
        for (int i = 0; i < original.length; i++) {
            copyArray[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return copyArray;
    }
}