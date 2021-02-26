package nowcoder.hj83;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bread = new BufferedReader(new InputStreamReader(System.in))) {
            String str;
            String[] temp;
            int[][] table;
            while ((str = bread.readLine()) != null) {
                temp = str.split(" ");
                table = createTable(Integer.valueOf(temp[0]), Integer.valueOf(temp[1]));
                if (null == table) {
                    System.out.print("-1\n-1\n-1\n-1\n-1\n");
                    continue;
                }
                System.out.println("0");

                str = bread.readLine();
                temp = str.split(" ");
                System.out.println(swapValue(table, Integer.valueOf(temp[0]),
                        Integer.valueOf(temp[1]),
                        Integer.valueOf(temp[2]),
                        Integer.valueOf(temp[3])));

                str = bread.readLine();
                temp = str.split(" ");
                System.out.println(addRow(table, Integer.valueOf(temp[0])));

                str = bread.readLine();
                temp = str.split(" ");
                System.out.println(addColumns(table, Integer.valueOf(temp[0])));

                str = bread.readLine();
                temp = str.split(" ");
                System.out.println(searchCell(table, Integer.valueOf(temp[0]), Integer.valueOf(temp[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static int[][] createTable(int m, int n) {
        //1.数据表的最大规格为9行*9列，对表格进行操作时遇到超出规格应该返回错误。
        if (m < 1 || m > 9 || n < 1 && n > 9) {
            return null;
        }
        return new int[m][n];
    }

    private static int swapValue(int[][] table, int x1, int y1, int x2, int y2) {
        return isContain(x1, table.length) && isContain(x2, table.length)
                && isContain(y2, table[0].length) && isContain(y2, table[0].length) ? 0 : -1;
    }

    private static int addRow(int[][] table, int rowIndex) {
        return isContain(rowIndex, table.length + 1) && table.length + 1 < 10 ? 0 : -1;
    }

    private static int addColumns(int[][] table, int columnsIndex) {
        return isContain(columnsIndex, table[0].length) && table[0].length + 1 < 10 ? 0 : -1;
    }

    private static int searchCell(int[][] table, int x, int y) {
        return isContain(x, table.length) && isContain(y, table[0].length) ? 0 : -1;
    }

    private static boolean isContain(int val, int range) {
        return val >= 0 && val < range && range < 10;
    }
}
