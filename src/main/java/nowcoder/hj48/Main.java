package nowcoder.hj48;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main1(String[] args) throws IOException {
        int[][] link;//0头节点，[i][0]:值 [i][1]:下一个节点序号
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int length;
        int[] node;
        String[] strs;
        int index, preIndex;
        int arrIndex;
        int delValue;
        StringBuffer sb;
        while ((str = in.readLine()) != null) {
            length = Integer.parseInt(str);
            link = new int[1000][2];
            link[0][0] = Integer.parseInt(in.readLine());

            length -= 1;
            arrIndex = 1;
            for (int i = 0; i < length; i++) {
                strs = in.readLine().split(" ");
                node = new int[]{Integer.parseInt(strs[0]), Integer.parseInt(strs[1])};
                index = 0;
                while (true) {
                    if (link[index][0] == node[1]) {
                        link[arrIndex][0] = node[0];
                        link[arrIndex][1] = link[index][1];
                        link[index][1] = arrIndex;
                        arrIndex++;
                        break;
                    } else {
                        index = link[index][1];
                    }
                }
            }

            delValue = Integer.parseInt(in.readLine());
            index = 0;
            preIndex = 0;
            while (true) {
                if (link[index][0] == delValue) {
                    link[preIndex][1] = link[index][1];
                    break;
                } else {
                    preIndex = index;
                    index = link[index][1];
                }
            }

            sb = new StringBuffer();
            index = 0;
            while (true) {
                sb.append(link[index][0]);
                sb.append(" ");
                index = link[index][1];
                if (index == 0) {
                    break;
                }
            }

            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] link;//0头节点，[i][0]:值 [i][1]:下一个节点序号
        int length;
        int[] node;
        int index, preIndex;
        int arrIndex;
        int delValue;
        StringBuffer sb;
        while (in.hasNext()) {
            length = in.nextInt();
            link = new int[1000][2];
            link[0][0] = in.nextInt();

            length -= 1;
            arrIndex = 1;
            for (int i = 0; i < length; i++) {
                node = new int[]{in.nextInt(), in.nextInt()};
                index = 0;
                while (true) {
                    if (link[index][0] == node[1]) {
                        link[arrIndex][0] = node[0];
                        link[arrIndex][1] = link[index][1];
                        link[index][1] = arrIndex;
                        arrIndex++;
                        break;
                    } else {
                        index = link[index][1];
                    }
                }
            }

            delValue = in.nextInt();
            index = 0;
            preIndex = 0;
            while (true) {
                if (link[index][0] == delValue) {
                    link[preIndex][1] = link[index][1];
                    break;
                } else {
                    preIndex = index;
                    index = link[index][1];
                }
            }

            sb = new StringBuffer();
            index = 0;
            while (true) {
                sb.append(link[index][0]);
                sb.append(" ");
                index = link[index][1];
                if (index == 0) {
                    break;
                }
            }

            System.out.println(sb);
        }
    }
}
