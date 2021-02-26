package nowcoder.hj53;

import java.util.Scanner;

public class Main {


    //1
    //1  1  1
    //1  2  3  2  1
    //1  3  6  7  6  3  1
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int row = in.nextInt();
            System.out.println(triangle(row));
        }
    }

//通过找规律的做法
    //当n<3时，没有偶数，输出-1；
//当n为奇数时，第一个偶数位置在第二，输出2；
//当n为偶数且能被4整除时，第一个偶数位置在第三，输出3；
//当n为偶数但不能被4整除时，偶数位置在第四，输出4

    private static int findEven(int row) {
        if (row < 3) {
            return -1;
        } else if (row % 2 == 1) {
            return 2;
        } else if (row % 2 == 0 && row % 4 == 0) {
            return 3;
        } else {
            return 4;
        }
    }

    //正常构建三角形的解法
    private static int triangle(int row) {
        int[][] tr = new int[row][(row - 1) + row];
        tr[0][0] = 1;
        int lNum, mMum, rNum;
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < i + 1 + i; j++) {
                lNum = 0;
                mMum = 0;
                rNum = 0;
                if (i - 1 >= 0 && j - 2 >= 0) {
                    lNum = tr[i - 1][j - 2];
                }

                if (i - 1 >= 0 && j - 1 >= 0) {
                    mMum = tr[i - 1][j - 1];
                }

                if (i - 1 >= 0) {
                    rNum = tr[i - 1][j];
                }
                tr[i][j] = lNum + mMum + rNum;

                if (row == i + 1 && tr[i][j] % 2 == 0) {
                    return j + 1;
                }
            }
        }
        return -1;
    }

    private static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    System.out.print(array[i][j]);
                }
            }
            System.out.println();
        }
    }
}
