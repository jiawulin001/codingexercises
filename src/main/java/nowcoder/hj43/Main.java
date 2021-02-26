package nowcoder.hj43;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int[] mn;
        int[][] maze;

        int index;
        int[] path;  //0空，1左边，2右边
        String[] strs;
        while ((str = in.readLine()) != null) {
            strs = str.split(" ");
            mn = new int[2];
            mn[0] = Integer.parseInt(strs[0]);
            mn[1] = Integer.parseInt(strs[1]);

            path = new int[mn[0] * mn[1] / 2];
            maze = new int[mn[0]][mn[1]];
            for (int i = 0; i < mn[0]; i++) {
                strs = in.readLine().split(" ");
                for (int j = 0; j < mn[1]; j++) {
                    maze[i][j] = Integer.parseInt(strs[j]);
                }
            }

            mn[0] = 0;
            mn[1] = 0;
            index = 0;

            while (!(mn[0] == maze.length - 1 && mn[1] == maze[0].length - 1)) {
                //左边通么
                if (path[index] != 1 && mn[1] + 1 < maze[0].length && maze[mn[0]][mn[1] + 1] != 1) {
                    mn[1] += 1;
                    path[index] = 1;
                    index++;
                } else if (path[index] != 2 && mn[0] + 1 < maze.length && maze[mn[0] + 1][mn[1]] != 1) {
                    //下边通么
                    mn[0] += 1;
                    path[index] = 2;
                    index++;
                } else {
                    //回去
                    index--;
                    if (path[index] == 1) {
                        mn[1] -= 1;
                    } else {
                        mn[0] -= 1;
                    }
                }
            }

            StringBuffer sb = new StringBuffer("(0,0)\n");
            mn[0] = 0;
            mn[1] = 0;
            for (int i = 0; i < path.length; i++) {
                if (path[i] == 0) {
                    continue;
                } else if (path[i] == 1) {
                    mn[1] += 1;
                } else if (path[i] == 2) {
                    mn[0] += 1;
                }

                sb.append("(");
                sb.append(mn[0]);
                sb.append(",");
                sb.append(mn[1]);
                sb.append(")\n");
            }
            sb.delete(sb.length() - 1, sb.length());
            System.out.println(sb);
        }
    }
}
