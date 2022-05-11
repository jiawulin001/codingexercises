package pat.pat1131;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://pintia.cn/problem-sets/994805342720868352/problems/994805347523346432
 * <p>
 * 4
 * 7 1001 3212 1003 1204 1005 1306 7797
 * 9 9988 2333 1204 2006 2005 2004 2003 2302 2001
 * 13 3011 3812 3013 3001 1306 3003 2333 3066 3212 3008 2302 3010 3011
 * 4 6666 8432 4011 1306
 * 3
 * 3011 3013
 * 6666 2001
 * 2004 3001
 */
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            System.out.printf("%04d \n",i);
        }
    }

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int lineCount = in.nextInt();
        int[][] lines = new int[101][101];
        int[] visible = new int[10000];
        ArrayList<Integer>[] sites = new ArrayList[10000];
        int siteCount;
        ArrayList<Integer> tempList;
        for (int i = 0; i < lineCount; i++) {
            siteCount = in.nextInt();
            for (int j = 0; j < siteCount; j++) {
                lines[i][j] = in.nextInt();
                if (visible[lines[i][j]] != 0) {
                    tempList = sites[lines[i][j]];
                    if (tempList == null) {
                        tempList = new ArrayList<>();
                        tempList.add(visible[lines[i][j]]);
                        sites[lines[i][j]] = tempList;
                    }
                    tempList.add(i + 1);
                }
                visible[lines[i][j]] = i + 1;
            }
        }

        int problemCount = in.nextInt();
        for (int i = 0; i < problemCount; i++) {
            calcCase(lines, sites, in.nextInt(), in.nextInt());
        }
    }

    private static void calcCase(int[][] lines, ArrayList<Integer>[] joinSites, int beginSite, int endSite) {
    }
}
