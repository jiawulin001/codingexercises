package leetcode.n1125;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
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

        for (int i = 0; i < 10; i++) {
            System.out.println((1 << i) + "\t" + Integer.toBinaryString(1 << i));
        }
        return null;
    }
}
