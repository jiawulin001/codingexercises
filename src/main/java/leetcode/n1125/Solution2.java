package leetcode.n1125;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        String[] req_skills = {"java", "nodejs", "reactjs"};
        List<List<String>> people = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("java");
        people.add(list);
        list = new ArrayList<>();
        list.add("nodejs");
        people.add(list);
        list = new ArrayList<>();
        list.add("nodejs");
        list.add("reactjs");
        people.add(list);
        s.smallestSufficientTeam(req_skills, people);
    }


    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(req_skills[i], 1 << i);
        }
        int allS = (1 << n) - 1;
        int len = people.size();
        int[] scores = new int[len];
        for (int i = 0; i < len; i++) {
            //将字符串组转换成数字
            scores[i] = getS(people.get(i), map);
        }
        int[][] dp = new int[len + 1][allS + 1];
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j < allS + 1; j++) {
                dp[i][j] = 10000;
            }
        }
        dp[0][allS] = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < allS + 1; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j | scores[i - 1]] + 1);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
            }
        }
        //最优规划找到最优值
        int min = dp[len][0];
        int[] ans = new int[min];
        int key = 0;
        int tAll = 0;
        //通过各个位置的最优值，找到最短路径
        for (int i = len; i >= 1; i--) {
            System.out.println(dp[i][tAll]);
            if (dp[i][tAll] == dp[i - 1][tAll | scores[i - 1]] + 1) {
                ans[key++] = i - 1;
                tAll = tAll | scores[i - 1];
                if (tAll == allS) {
                    break;
                }
            }
        }
        return ans;
    }

    private int getS(List<String> list, Map<String, Integer> map) {
        int score = 0;
        for (String s : list) {
            score += map.get(s);
        }
        return score;
    }

}
