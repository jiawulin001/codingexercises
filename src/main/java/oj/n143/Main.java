package oj.n143;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main1(String[] args) {
        Scanner s = new Scanner(System.in);
        int boxNum = s.nextInt();
        int ansCount = s.nextInt();

        int[][] ans = new int[ansCount][3];
        for (int i = 0; i < ansCount; i++) {
            ans[i][0] = s.nextInt();
            ans[i][1] = s.nextInt();
            ans[i][2] = s.nextInt();
        }

        System.out.println(validateAns(ans, boxNum));
    }

    private static int validateAns1(int[][] answer, int boxNum) {
        //TreeMap<Integer, Point> map = new TreeMap<>();
        Integer[] box = new Integer[boxNum];

        int[] ans;
        for (int k = 0; k < answer.length; k++) {
            ans = answer[k];

            if (box[ans[0]] == null || box[ans[1]] == null) {
                for (int i = ans[0]; i <= ans[1]; i++) {
                    box[i] = ans[2];
                }
            } else {
                for (int i = ans[0]; i <= ans[1]; i++) {
                    if (ans[2] != box[i]) {
                        return k;
                    }
                }
            }
        }


        return answer.length;
    }


    private static int validateAns(int[][] answer, int boxNum) {
        List<int[]> points = new ArrayList<>();
        for (int i = 0; i < answer.length; i++) {
            if (!join(points, answer[i], true)) {
                return i;
            }
        }
        return answer.length;
    }

    private static boolean join(List<int[]> points, int[] ans, boolean a) {
        Iterator<int[]> it = points.iterator();
        int[] temp;
        while (it.hasNext()) {
            temp = it.next();
            if (ans[0] == temp[1]) {
                temp[1] = ans[1];
                temp[2] = ans[2] | temp[2];
                points.add(temp);
                break;
            } else if (ans[1] == temp[0]) {
                temp[0] = ans[0];
                temp[2] = ans[2] | temp[2];
                points.add(temp);
                break;
            }
        }
        points.add(ans);


        return true;
    }

}
