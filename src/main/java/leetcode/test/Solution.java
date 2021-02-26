package leetcode.test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        //int[] list = {1,3,9,8,7,2,6,4,5};
        //int[][] interfere = {{1,3},{7,8},{2,6}};
        int[] list = {1, 3, 6, 7, 2, 8, 5, 4, 9};
        int[][] interfere = {{1, 3}, {4, 5}, {2, 7}};

        Solution s = new Solution();
        List<List<Integer>> r = s.s(list, interfere);

        System.out.println(JSON.toJSONString(r));

    }


    public List<List<Integer>> s(int[] list, int[][] interfere) {
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        List<Integer> tempList;

        for (int i = 0; i < interfere.length; i++) {
            for (int j = 0; j < interfere[i].length; j++) {
                tempList = map.getOrDefault(interfere[i][j], new ArrayList<>());
                tempList.add(i);
                map.putIfAbsent(interfere[i][j], tempList);
            }
        }

        List<List<Integer>> r = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();
        Boolean isBreak;
        for (int i = 0; i < list.length - 1; i++) {
            isBreak = false;
            if (!map.containsKey(list[i]) || !map.containsKey(list[i + 1])) {
                r2.add(list[i]);
                continue;
            }

            tempList = map.get(list[i]);
            for (int j = 0; j < tempList.size(); j++) {
                if (map.get(list[i + 1]).contains(tempList.get(j))) {
                    r2.add(list[i]);
                    r.add(r2);
                    r2 = new ArrayList<>();
                    isBreak = true;
                    break;
                }
            }

            if(isBreak){
                continue;
            }
            r2.add(list[i]);

        }
        r2.add(list[list.length - 1]);
        r.add(r2);

        return r;
    }



}
