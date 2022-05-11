package leetcode.n733;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        image = s.floodFill(image, 1, 1, 2);
        System.out.println(Arrays.equals(image, new int[][]{{2, 2, 2}, {2, 2, 0}, {2, 0, 1}}));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{sr, sc});
        int[] point;
        while (!queue.isEmpty()) {
            point = queue.poll();
            if (image[point[0]][point[1]] == newColor) {
                continue;
            }
            if (point[0] > 0 && image[point[0]][point[1]] == image[point[0] - 1][point[1]]) {
                queue.add(new int[]{point[0] - 1, point[1]});
            }
            if (point[0] + 1 < image.length && image[point[0]][point[1]] == image[point[0] + 1][point[1]]) {
                queue.add(new int[]{point[0] + 1, point[1]});
            }
            if (point[1] > 0 && image[point[0]][point[1]] == image[point[0]][point[1] - 1]) {
                queue.add(new int[]{point[0], point[1] - 1});
            }
            if (point[1] + 1 < image[0].length && image[point[0]][point[1]] == image[point[0]][point[1] + 1]) {
                queue.add(new int[]{point[0], point[1] + 1});
            }
            image[point[0]][point[1]] = newColor;
        }
        return image;
    }

    private void fillColor(int[][] image, int sr, int sc, int newColor) {

    }
}
