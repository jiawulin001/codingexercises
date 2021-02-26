package leetcode.n1125;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        String[] game = {"skipping rope", "sit-ups", "Rubik's Cube"};
        List<List<String>> athletes = Arrays.asList(Arrays.asList("sit-ups"), Arrays.asList("skipping rope"), Arrays.asList("sit-ups", "Rubik's Cube"));
        Solution s = new Solution();
        Arrays.stream(s.smallestSufficientTeam(game, athletes)).forEach(System.out::println);

    }

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int minSize = -1;
        List<Integer> temp, team = new ArrayList<Integer>();

        for (int i = 0; i < people.size(); i++) {
            temp = iWantYou(req_skills, people, i, minSize);
            if (minSize == -1 && temp != null) {
                minSize = temp.size();
                team = temp;
            } else if (minSize != -1 && temp != null) {
                minSize = temp.size();
                team = temp;
            }
        }
        team.sort(Integer::compareTo);
        return team.stream().mapToInt(Integer::valueOf).toArray();
    }

    private List<String> toList(String[] game) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < game.length; i++) {
            list.add(game[i]);
        }
        return list;
    }


    private List<Integer> iWantYou(String[] game, List<List<String>> athletes, int beginIndex, int minSize) {
        List<Integer> team = new ArrayList<>();
        List athlete;
        List<String> tempList = toList(game);
        Iterator<String> games;
        boolean isChoose = false;

        for (int i = beginIndex; i < athletes.size(); i++) {
            athlete = athletes.get(i);
            games = tempList.iterator();
            while (games.hasNext()) {
                if (athlete.contains(games.next())) {
                    isChoose = true;
                    games.remove();
                }
            }

            if (isChoose) {
                team.add(i);
                if (minSize != -1 && minSize <= team.size()) {
                    return null;
                }

                if (tempList.isEmpty()) {
                    return team;
                }
            }
        }

        for (int i = 0; i < beginIndex; i++) {
            athlete = athletes.get(i);
            games = tempList.iterator();
            while (games.hasNext()) {
                if (athlete.contains(games.next())) {
                    isChoose = true;
                    games.remove();
                }
            }

            if (isChoose) {
                team.add(i);
                if (minSize != -1 && minSize <= team.size()) {
                    return null;
                }

                if (tempList.isEmpty()) {
                    return team;
                }
            }
        }

        return null;
    }


}
