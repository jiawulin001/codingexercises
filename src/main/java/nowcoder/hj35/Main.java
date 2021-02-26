package nowcoder.hj35;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num;
        int cell;
        int preCellNum;
        int preRowNum;
        StringBuffer sb;
        while (in.hasNext()) {
            preCellNum = 1;
            preRowNum = 1;
            num = in.nextInt();
            cell = num;
            sb = new StringBuffer();
            sb.append(1);
            sb.append(" ");
            for (int i = 1; cell > 1; i++) {
                if (i < cell) {
                    preCellNum = preCellNum + i + (num - cell + 1);
                    sb.append(preCellNum);
                    sb.append(" ");
                } else {
                    sb.delete(sb.length() - 1, sb.length());
                    sb.append("\n");
                    i = 0;
                    cell--;
                    preRowNum = preRowNum + (num - cell);
                    preCellNum = preRowNum;
                    sb.append(preRowNum);
                    sb.append(" ");
                }
            }
            sb.delete(sb.length() - 1, sb.length());
            System.out.println(sb);
        }
    }

    public static void main1(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(i + "\t" + ((i - 1) * i / 2 + 1));
        }
    }
}
