package leetcodeday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Day20220418 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i < 201; i++) {
            list.add(i + "");
        }

        list.sort(String::compareTo);
        list.forEach(System.out::println);
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n + 1);
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        list.sort(Comparator.comparing(n2 -> (n2 + "")));

        return list;
    }

    public List<Integer> lexicalOrder1(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            //dfs(i, n, result);
        }
        return result;
    }

    private void dfs(int begin, int n) {

    }

}
