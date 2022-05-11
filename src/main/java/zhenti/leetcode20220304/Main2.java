package zhenti.leetcode20220304;


import java.util.Arrays;

public class Main2 {


    public static void main(String[] args) {
        Main2 main = new Main2();
        int[] result = main.getNotificationOrder(9, 3, new Earthquake(6, 3, 2),
                new int[][]{{3, 5}, {7, 4}, {6, 5}, {5, 7}, {2, 5}, {5, 7}});
        System.out.println(Arrays.equals(result, new int[]{5, 2, 6, 7}));
    }


    public int[] getNotificationOrder(int mapSideLen, int gridSideLen, Earthquake earthquake, int[][] userArray) {
        return null;
    }

    static class Earthquake {
        int radius;
        int rowIdx;
        int colIdx;

        Earthquake(int radius, int rowIdx, int colIdx) {
            this.radius = radius;
            this.rowIdx = rowIdx;
            this.colIdx = colIdx;
        }
    }
}

