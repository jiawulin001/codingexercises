package od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> game = Arrays.asList("skipping rope", "sit-ups", "Rubik's Cube");
        List<List<String>> athletes = Arrays.asList(Arrays.asList("sit-ups"), Arrays.asList("skipping rope"), Arrays.asList("sit-ups", "Rubik's Cube"));
        iWantYou2(game, athletes).forEach(System.out::println);

    }


    private static List<Integer> iWantYou(List<String> game, List<List<String>> athletes, int beginIndex, int minSize) {
        List<Integer> team = new ArrayList<>();
        List athlete;
        List<String> tempList = new ArrayList<>();
        tempList.addAll(game);
        Iterator<String>  games;
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

    private static List<Integer> iWantYou2(List<String> game, List<List<String>> athletes) {
        int minSize = -1;
        List<Integer> team = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        //athletes.sort((list1, list2) -> Integer.compare(list2.size(), list1.size()));


        for (int i = 0; i < athletes.size(); i++) {
            temp = iWantYou(game, athletes, i, minSize);
            if (minSize == -1 && temp != null) {
                minSize = temp.size();
                team = temp;
            } else if (minSize != -1 && temp != null) {
                minSize = temp.size();
                team = temp;
            }
        }
        return team;
    }
}
