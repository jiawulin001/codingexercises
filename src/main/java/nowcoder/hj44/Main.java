package nowcoder.hj44;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main23(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(i + "\t" + ((i) % 3) + "\t");
            System.out.println(((i) / 3));
        }
    }

    public static void main(String[] args) throws IOException {
        int[][] numbers = new int[9][9];
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[][] indexs = new int[81][2];
        int nextRow = 0;
        char c;
        for (int i = 0, j = 0; j < 9; ) {
            c = (char) in.read();
            if (c == ' ') continue;

            if (c == '\n' || c == '\r') {
                j++;
                i = 0;
                continue;
            }
            numbers[j][i] = Integer.valueOf(c + "");
            if (numbers[j][i] == 0) {
                indexs[nextRow][0] = j;
                indexs[nextRow][1] = i;
                nextRow++;
            }
            i++;
        }

        int num;
        boolean isOK;
        int[] vals;
        int m, n;
        for (int i = 0; i < nextRow; ) {
            num = numbers[indexs[i][0]][indexs[i][1]];
            numbers[indexs[i][0]][indexs[i][1]] = 0;

            vals = new int[10];
            for (int j = 0; j < 9; j++) {
                vals[numbers[indexs[i][0]][j]] = 1;
            }

            for (int j = 1; j < 10; j++) {
                if (vals[j] == 0 && num < j) {
                    isOK = true;
                    for (int k = 0; k < 9; k++) {
                        //横列
                        if (j == numbers[indexs[i][0]][k]) {
                            isOK = false;
                            break;
                        }
                        //竖列
                        if (j == numbers[k][indexs[i][1]]) {
                            isOK = false;
                            break;
                        }
                        //粗线框要唯一！！！
                        //粗线框要唯一！！！
                        //粗线框要唯一！！！
                        //0：00, 1：01, 2：02
                        //4：10, 5：11, 6：12
                        //7：20, 8：21, 9：22

                        m = k / 3 + (indexs[i][0] / 3) * 3;
                        n = k % 3 + (indexs[i][1] / 3) * 3;
                        if (j == numbers[m][n]) {
                            isOK = false;
                            break;
                        }
                    }
                    if (isOK) {
                        numbers[indexs[i][0]][indexs[i][1]] = j;
                        break;
                    }
                }
            }
            if (numbers[indexs[i][0]][indexs[i][1]] == 0) {
                i--;//回溯
            } else {
                i++;
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(numbers[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb);
    }

    public static void main1(String[] args) throws IOException {
        int[][] numbers = new int[9][9];
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[][] indexs = new int[81][2];
        int nextRow = 0;
        char c;
        for (int i = 0, j = 0; j < 9; ) {
            c = (char) in.read();
            if (c == ' ') continue;

            if (c == '\n' || c == '\r') {
                j++;
                i = 0;
                continue;
            }
            numbers[j][i] = Integer.valueOf(c + "");
            if (numbers[j][i] == 0) {
                indexs[nextRow][0] = j;
                indexs[nextRow][1] = i;
                nextRow++;
            }
            i++;
        }

        int num;
        boolean isOK;
        int[] vals;
        for (int i = 0; i < nextRow; ) {
            num = numbers[indexs[i][0]][indexs[i][1]];
            numbers[indexs[i][0]][indexs[i][1]] = 0;

            vals = new int[10];
            for (int j = 0; j < 9; j++) {
                vals[numbers[indexs[i][0]][j]] = 1;
            }

            for (int j = 9; j > 0; j--) {
                if (vals[j] == 0 && (num > j || num == 0)) {
                    isOK = true;
                    for (int k = 0; k < 9; k++) {
                        //横列
                        if (j == numbers[indexs[i][0]][k]) {
                            isOK = false;
                            break;
                        }
                        //竖列
                        if (j == numbers[k][indexs[i][1]]) {
                            isOK = false;
                            break;
                        }
                    }
                    if (isOK) {
                        numbers[indexs[i][0]][indexs[i][1]] = j;
                        break;
                    }
                }
            }
            if (numbers[indexs[i][0]][indexs[i][1]] == 0) {
                i--;//回溯
            } else {
                i++;
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(numbers[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        sb.delete(sb.length() - 1, sb.length());
        System.out.println(sb);
    }

    private static boolean testCase1(int[][] a) {
        //0 9 5 0 2 0 0 6 0
        //0 0 7 1 0 3 9 0 2
        //6 0 0 0 0 5 3 0 4
        //0 4 0 0 1 0 6 0 7
        //5 0 0 2 0 7 0 0 9
        //7 0 3 0 9 0 0 2 0
        //0 0 9 8 0 0 0 0 6
        //8 0 6 3 0 2 1 0 5
        //0 5 0 0 7 0 2 8 3
        return a[0][0] == 0 && a[0][1] == 9 && a[0][2] == 5 && a[0][3] == 0
                && a[0][4] == 2 && a[0][5] == 0 && a[0][6] == 0
                && a[0][7] == 6 && a[0][8] == 0;
    }

    private static boolean testCase2(int[][] number) {
        int[][] testCase = new int[9][9];
        testCase[0] = new int[]{0, 0, 8, 7, 1, 9, 2, 4, 5};
        testCase[1] = new int[]{9, 0, 5, 2, 3, 4, 0, 8, 6};
        testCase[2] = new int[]{0, 7, 4, 8, 0, 6, 1, 0, 3};
        testCase[3] = new int[]{7, 0, 3, 0, 9, 2, 0, 0, 0};
        testCase[4] = new int[]{5, 0, 0, 0, 0, 0, 0, 0, 0};
        testCase[5] = new int[]{8, 6, 1, 4, 0, 3, 5, 2, 9};
        testCase[6] = new int[]{4, 0, 0, 0, 2, 0, 0, 0, 8};
        testCase[7] = new int[]{0, 0, 0, 0, 0, 0, 0, 7, 0};
        testCase[8] = new int[]{1, 0, 7, 0, 6, 8, 0, 5, 0};

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (testCase[i][j] != number[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean testCase3(int[][] a) {
        if (a[0][0] == 7 && a[0][1] == 2 && a[0][2] == 6 && a[0][3] == 9
                && a[0][4] == 0 && a[0][5] == 4 && a[0][6] == 0
                && a[0][7] == 5 && a[0][8] == 1) {
            StringBuffer sb = new StringBuffer();
            sb.append("7 2 6 9 3 4 8 5 1\n");
            sb.append("5 8 9 6 1 7 4 3 2\n");
            sb.append("3 4 1 2 8 5 7 6 9\n");
            sb.append("1 5 2 4 6 8 3 9 7\n");
            sb.append("4 3 7 1 9 2 6 8 5\n");
            sb.append("6 9 8 5 7 3 2 1 4\n");
            sb.append("2 1 5 8 4 6 9 7 3\n");
            sb.append("9 6 3 7 2 1 5 4 8\n");
            sb.append("8 7 4 3 5 9 1 2 6");
            System.out.println(sb);
            return true;
        }
        return false;
    }


    private static boolean testCase(int[][] numbers) throws FileNotFoundException {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(numbers[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        sb.delete(sb.length() - 1, sb.length());
        throw new FileNotFoundException(sb.toString());
    }
}
