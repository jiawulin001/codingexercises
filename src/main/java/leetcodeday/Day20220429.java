package leetcodeday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/construct-quad-tree/
 * 427. 建立四叉树
 */
public class Day20220429 {
    public static void main(String[] args) {
        Day20220429 test = new Day20220429();
        Node node = test.construct(new int[][]{{0, 1}, {1, 0}});
        System.out.println(Arrays.equals(node.toArray(), new Integer[][]{{0, 1}, {1, 0}, {1, 1}, {1, 1}, {1, 0}}));
    }

    //自己做的，主要是不停的切割数组
    public Node construct(int[][] grid) {
        if (isLeaf(grid)) {
            return new Node(grid[0][0] == 1, true);
        }

        //10 * 10

        Node node = new Node();
        int[][] topLeftGrid = new int[grid.length / 2][grid.length / 2];
        int[][] topRightGrid = new int[topLeftGrid.length][topLeftGrid.length];
        int[][] bottomLeftGrid = new int[topLeftGrid.length][topLeftGrid.length];
        int[][] bottomRightGrid = new int[topLeftGrid.length][topLeftGrid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (i < topLeftGrid.length) {
                    if (j < topLeftGrid.length) {
                        topLeftGrid[i][j] = grid[i][j];
                        continue;
                    }
                    topRightGrid[i][j - topLeftGrid.length] = grid[i][j];
                } else {
                    if (j < topLeftGrid.length) {
                        bottomLeftGrid[i - topLeftGrid.length][j] = grid[i][j];
                        continue;
                    }
                    bottomRightGrid[i - topLeftGrid.length][j - topLeftGrid.length] = grid[i][j];
                }
            }
        }


        node.topLeft = construct(topLeftGrid);  //i 0-5  j 0-5
        node.topRight = construct(topRightGrid); // i 0-5 j 5-10
        node.bottomLeft = construct(bottomLeftGrid); // i 5-10 j 0-5
        node.bottomRight = construct(bottomRightGrid); // i 5-10 j 5-10

        return node;
    }

    public boolean isLeaf(int[][] grid) {
        int num = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != num) {
                    return false;
                }
            }
        }
        return true;
    }

    //官方的思路是一样的，但是官方不需要每次切割，应为下标可以通过公式计算得出
    //行分界线是当 前行开始 + 结束 / 2   列同理：
    //行分界线 = r0 + r1 / 2   列分界线 = c0 + c1 / 2
    public Node dfs(int[][] grid, int r0, int c0, int r1, int c1) {
        boolean same = true;
        for (int i = r0; i < r1; ++i) {
            for (int j = c0; j < c1; ++j) {
                if (grid[i][j] != grid[r0][c0]) {
                    same = false;
                    break;
                }
            }
            if (!same) {
                break;
            }
        }

        if (same) {
            return new Node(grid[r0][c0] == 1, true);
        }

        Node ret = new Node(true, false, dfs(grid, r0, c0, (r0 + r1) / 2, (c0 + c1) / 2), dfs(grid, r0, (c0 + c1) / 2
                , (r0 + r1) / 2, c1), dfs(grid, (r0 + r1) / 2, c0, r1, (c0 + c1) / 2), dfs(grid, (r0 + r1) / 2,
                (c0 + c1) / 2, r1, c1));
        return ret;
    }
}

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }

    //[[0,1],[1,0],[1,1],[1,1],[1,0]]//isLeaf, val//0 表示 false，1 表示 True 。
    public Integer[][] toArray() {
        if (this.isLeaf) {
            return new Integer[][]{{1, this.val ? 1 : 0}};
        }

        List<Integer[]> list = new ArrayList<>();
        list.add(new Integer[]{this.isLeaf ? 1 : 0, this.val ? 1 : 0});


        LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(this.topLeft);
        nodes.add(this.topRight);
        nodes.add(this.bottomLeft);
        nodes.add(this.bottomRight);

        Node node;
        while (!nodes.isEmpty()) {
            node = nodes.pop();

            if (node == null) {
                list.add(null);
                continue;
            }

            list.add(new Integer[]{node.isLeaf ? 1 : 0, node.val ? 1 : 0});
            nodes.add(node.topLeft);
            nodes.add(node.topRight);
            nodes.add(node.bottomLeft);
            nodes.add(node.bottomRight);
        }

        Integer[][] result = new Integer[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}

