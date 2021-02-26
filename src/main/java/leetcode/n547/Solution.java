package leetcode.n547;

public class Solution {


    /**
     * <p>班上有 N 名学生。其中有些人是朋友，有些则不是。</p>
     * <p>他们的友谊具有是传递性。</p>
     * <p>如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。</p>
     * <p>所谓的朋友圈，是指所有朋友的集合。</p>
     *
     *
     * <p>给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。</p>
     * <p>如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。</p>
     * <p>你必须输出所有学生中的已知的朋友圈总数。</p>
     *
     * <p>示例一：</p>
     * <pre>
     * 输入：
     * [[1,1,0],
     *  [1,1,0],
     *  [0,0,1]]
     * 输出：2
     * </pre>
     * <p>解释：已知学生 0 和学生 1 互为朋友，他们在一个朋友圈。</p>
     * <p>第2个学生自己在一个朋友圈。所以返回 2 。</p>
     *
     * <p>示例二：</p>
     * <pre>
     *     输入：
     * [[1,1,0],
     *  [1,1,1],
     *  [0,1,1]]
     * 输出：1
     * 解释：已知学生 0 和学生 1 互为朋友，学生 1 和学生 2 互为朋友，所以学生 0 和学生 2 也是朋友，所以他们三个在一个朋友圈，返回 1 。
     *
     * </pre>
     *
     * <p>提示：</p>
     * <pre>
     * 1 <= N <= 200
     * M[i][i] == 1
     * M[i][j] == M[j][i]
     * </pre>
     */

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] input = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(s.findCircleNum(input));
        int[][] input2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(s.findCircleNum(input2));

    }


    public int findCircleNum(int[][] m) {
        int[] parent = new int[m.length];
        for (int i = 0; i < m.length; i++) {
            parent[i] = -1;
            for (int j = 0; j < i; j++) {
                if (m[i][j] == 1) {
                    join(parent, i, j);
                }
            }
        }

        return countCrcle(parent);
    }

    private void join(int[] parent, int y, int x) {
        int xParent = find(parent, x);
        int yParent = find(parent, y);
        if (xParent != yParent) {
            parent[xParent] = yParent;
        }
    }

    private int find(int[] parent, int x) {
        if (parent[x] == -1) {
            return x;
        }
        return find(parent, parent[x]);
    }

    private int countCrcle(int[] parent) {
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                count++;
            }
        }
        return count;
    }


}
