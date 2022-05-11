package leetcode.n286;

import java.util.*;

public class Solution {

    private static final int EMPTY = -2; //Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[]{1, 0},
            new int[]{-1, 0},
            new int[]{0, 1},
            new int[]{0, -1}
    );

    public static void main(String[] args) {
        int[][] rooms = {
                {-2, -1, 0, -2},
                {-2, -2, -2, -1},
                {-2, -1, -2, -1},
                {0, -1, -2, -2}};
        Solution s = new Solution();
        s.wallsAndGates(rooms);
    }


    public void wallsAndGates1(int[][] rooms) {
        Stack<int[]> stack = new Stack<>();
        for (int r = 0; r < rooms.length; r++) {
            for (int c = 0; c < rooms.length; c++) {
                if (rooms[r][c] == 0) {
                    stack.push(new int[]{r, c});
                }
            }
        }

        int[] point;
        int r, c;
        while (!stack.isEmpty()) {
            point = stack.pop();
            r = point[0];
            c = point[1];

            if (r > 0 && rooms[r - 1][c] != -1 && rooms[r - 1][c] != 0) {
                if (rooms[r][c] == 0) {
                    //上，值不等于1，刷成1放入队列,不能是门和墙


                    //下，值不等于1，刷成1放入队列,不能是门和墙
                    //左，值不等于1，刷成1放入队列,不能是门和墙
                    //右，值不等于1，刷成1放入队列,不能是门和墙
                } else {
                    //空房间
                    //上，前后差值不等于1和相等，刷成加1放入队列,不能是门和墙
                    //下，前后差值不等于1和相等，刷成加1放入队列,不能是门和墙
                    //左，前后差值不等于1和相等，刷成加1放入队列,不能是门和墙
                    //右，前后差值不等于1和相等，刷成加1放入队列,不能是门和墙
                }
                stack.push(new int[]{r - 1, c});
            }

            if (r + 1 < rooms.length && rooms[r + 1][c] != -1 && rooms[r + 1][c] != 0) {


                stack.push(new int[]{r + 1, c});
            }
            if (c > 0 && rooms[r][c - 1] != -1 && rooms[r][c - 1] != 0) {


                stack.push(new int[]{r, c - 1});
            }
            if (c + 1 < rooms[0].length && rooms[r][c + 1] != -1 && rooms[r][c + 1] != 0) {


                stack.push(new int[]{r, c + 1});
            }

        }
    }

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == GATE) {
                    q.add(new int[]{row, col});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                q.add(new int[]{r, c});
            }
        }
    }

}
