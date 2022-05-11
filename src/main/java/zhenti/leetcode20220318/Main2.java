package zhenti.leetcode20220318;

import java.util.Arrays;
import java.util.LinkedList;

public class Main2 {

//    num == 围棋桌
//    type = 0：成人  1：儿童

    public static void main(String[] args) {
        //2台桌子   儿童1台   最长对弈时间3  人集合[到达时刻，成人/儿童]
        Main2 main2 = new Main2();
        int[] result = main2.goGame(2, 1, 3, new int[][]{{1, 0}, {1, 1}, {2, 1}, {2, 0}});
        System.out.println(Arrays.equals(result, new int[]{1, 1, -1, -1}));

        main2 = new Main2();
        result = main2.goGame(3, 1, 4, new int[][]{{1, 1}, {1, 0}, {2, 0}, {2, 1}, {3, 1}, {4, 1}, {4, 1}, {6, 1}, {6
                , 0}, {7, 0}});
        System.out.println(Arrays.equals(result, new int[]{2, 2, 2, 2, 4, 4, -1, -1, 7, 7}));
    }

    public int[] goGame(int num, int cnt, int time, int[][] people) {
        //{类型，对弈时间}  空闲，占位，对弈
        int[] result = new int[people.length];
        LinkedList<Integer> adultTableWaiting = new LinkedList<>();
        LinkedList<Integer> childTableWaiting = new LinkedList<>();
        LinkedList<Integer> adultVSTable = new LinkedList<>();
        LinkedList<Integer> childVSTable = new LinkedList<>();
        final int child = 1;
        int adultTableCount = 0;
        int childTableCount = 0;

        //{人ID，占几号桌子}
        int waitingPeople;
        //2台桌子   儿童1台   最长对弈时间3  人集合[到达时刻，成人/儿童]
        for (int i = 0; i < people.length; i++) {
            //小孩
            if (people[i][1] == child) {
                //先看有没有小孩桌等待中
                if (!childTableWaiting.isEmpty()) {
                    waitingPeople = childTableWaiting.pop();
                    result[waitingPeople] = people[i][0];
                    result[i] = people[i][0];
                    childVSTable.add(people[i][0]);
                    continue;
                }
            }

            //不管大人还是小孩
            if (!adultTableWaiting.isEmpty()) {
                waitingPeople = adultTableWaiting.pop();
                result[waitingPeople] = people[i][0];
                result[i] = people[i][0];
                adultVSTable.add(people[i][0]);
                continue;
            }

            //更新桌子
            while (!adultVSTable.isEmpty() && adultVSTable.peek() + time <= people[i][0]) {
                adultVSTable.pop();
            }
            while (!childVSTable.isEmpty() && childVSTable.peek() + time <= people[i][0]) {
                childVSTable.pop();
            }

            adultTableCount = adultVSTable.size() + adultTableWaiting.size();
            childTableCount = childVSTable.size() + childTableWaiting.size();

            if (adultTableCount + childTableCount >= num) {
                result[i] = -1;
                continue;
            }

            //先看有没有桌子了
            if (people[i][1] == child && childTableCount < cnt) {
                childTableWaiting.add(i);
            } else if (people[i][1] != child && adultTableCount >= num - cnt) {
                result[i] = -1;
            } else {
                adultTableWaiting.add(i);
            }
        }

        while (!adultTableWaiting.isEmpty()) {
            result[adultTableWaiting.pop()] = -1;
        }

        while (!childTableWaiting.isEmpty()) {
            result[childTableWaiting.pop()] = -1;
        }

        return result;
    }
}
