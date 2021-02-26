package leetcode.n684;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {


    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] input = {{1, 2}, {1, 3}, {2, 3}};
        Arrays.stream(s.findRedundantConnection(input)).forEach(i -> System.out.print(i + "\t"));
        int[][] input2 = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        System.out.println();
        Arrays.stream(s.findRedundantConnection(input2)).forEach(i -> System.out.print(i + "\t"));


    }


    public int[] findRedundantConnection(int[][] m) {
        Map<Integer, Integer> parent = new HashMap<>(m.length);
        int[] r = new int[2];
        int u, v;
        for (int i = 0; i < m.length; i++) {
            u = m[i][0];
            v = m[i][1];

            int xParent = find(parent, u);
            int yParent = find(parent, v);
            if (xParent != yParent) {
                parent.put(xParent, yParent);
            } else {
                r[0] = u;
                r[1] = v;
            }

        }

        return r;
    }

    private int find(Map<Integer, Integer> parent, int x) {
        if (parent.get(x) == null) {
            return x;
        }
        return find(parent, parent.get(x));
    }


}
