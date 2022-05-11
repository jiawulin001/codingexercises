package od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main26 {
    // oj 325.世界杯预研

    /**
     * 蒙特卡洛方法，直接按照胜率模拟一定数量的场次比赛，最后看谁获得冠军次数最多，谁就是胜利者
     */
    public static void main(String[] args) {
        String input = "2\n0.0 0.1 0.2 0.3\n0.9 0.0 0.4 0.5\n0.8 0.6 0.0 0.6\n0.7 0.5 0.4 0.0";

        Scanner in = new Scanner(input);
        int round = Integer.parseInt(in.nextLine());
        int teamNum = (int) Math.pow(2, round);

        String[][] odds = new String[teamNum][teamNum];
        for (int i = 0; i < teamNum; i++) {
            odds[i] = in.nextLine().split(" ");
        }

        int[] teamsWinCount = new int[teamNum];

        //进行1W场比赛
        int winTeam;
        for (int i = 0; i < 100000; i++) {
            winTeam = competition(odds, round, teamNum);
            teamsWinCount[winTeam]++;
        }


        winTeam = 0;
        int max = teamsWinCount[0];
        for (int i = 1; i < teamNum; i++) {
            if (teamsWinCount[i] > max) {
                winTeam = i;
                max = teamsWinCount[i];
            }
        }

        System.out.println(winTeam + 1);
    }

    private static int competition(String[][] odds, int round, int teamNum) {
        List<Integer> teamList = new ArrayList<>(teamNum);
        for (int i = 0; i < teamNum; i++) {
            teamList.add(i);
        }


        int teamA;
        int teamB;
        int winTeam;
        for (int i = 0; i < round; i++) {
            for (int j = 0; j < teamList.size(); j++) {
                teamA = teamList.get(j);
                teamB = teamList.get(j + 1);
                winTeam = getWinner(odds[teamA][teamB]);

                if (winTeam == 1) {
                    teamList.remove(j + 1);
                } else {
                    teamList.remove(j);
                }
            }
        }

        return teamList.get(0);
    }

    private static int getWinner(String winRate) {
        if (Math.random() < Float.valueOf(winRate)) {
            return 1;
        } else {
            return 2;
        }
    }
}

class Main26_2 {
    /**
     * 概率dp <br>
     * <img src="..\..\resources\image\冠军预测分析.png" />
     */
    public static void main(String[] args) {
        //String input = "2\n0.0 0.1 0.2 0.3\n0.9 0.0 0.4 0.5\n0.8 0.6 0.0 0.6\n0.7 0.5 0.4 0.0";
        String input = "2\n0.00 0.41 0.65 0.31\n0.59 0.00 0.41 0.19\n0.35 0.59 0.00 0.15\n0.69 0.81 0.85 0.00";

        Scanner in = new Scanner(input);
        int round = Integer.parseInt(in.nextLine());
        int teamNum = (int) Math.pow(2, round);

        String[][] odds = new String[teamNum][teamNum];
        for (int i = 0; i < teamNum; i++) {
            odds[i] = in.nextLine().split(" ");
        }

        //每轮获胜的概率,i是轮次,j是队伍编号
        float[][] dp = new float[round][teamNum];

        // 初始第1轮比赛，0,1 2,3 4,5 6,7 所以偶数和偶数+1比赛  奇数和奇数-1比赛
        for (int i = 0; i < teamNum; i++) {
            if (i % 2 == 0) {
                dp[0][i] = Float.valueOf(odds[i][i + 1]);
            } else {
                dp[0][i] = Float.valueOf(odds[i][i - 1]);
            }
        }

        //每个小组人数
        int groupCount;
        //第几小组
        int groupNum;

        int begin;
        int end;

        // 计算第一轮以后每场比赛胜率
        for (int i = 1; i < round; i++) {
            for (int j = 0; j < teamNum; j++) {
                //先计算当前属于第几小组
                groupCount = (int) Math.pow(2, i);
                groupNum = j / groupCount;

                //当前队伍可能遇到的队伍范围 = 如果自己是偶数队伍那就是偶数+1，如果是奇数队伍那么就是奇数-1
                if (groupNum % 2 == 0) {
                    begin = (groupNum + 1) * groupCount;
                    end = (groupNum + 2) * groupCount;
                } else {
                    begin = (groupNum - 1) * groupCount;
                    end = groupNum * groupCount;
                }

                // 可能和其中一个队伍相遇，所以p(a + b ...),和每个队伍相遇的概率相加
                for (int k = begin; k < end; k++) {
                    // 当前轮次胜率 = 上一轮胜率 * 当前遇上队伍上一轮胜率 * 他们之间的胜率
                    dp[i][j] += dp[i - 1][j] * dp[i - 1][k] * Float.valueOf(odds[j][k]);
                }
            }
        }

        // 计算谁的概率最大
        float max = dp[round - 1][0];
        int index = 0;
        for (int i = 1; i < teamNum; i++) {
            if (dp[round - 1][i] > max) {
                max = dp[round - 1][i];
                index = i;
            }
        }

        System.out.println(index + 1);
    }
}
