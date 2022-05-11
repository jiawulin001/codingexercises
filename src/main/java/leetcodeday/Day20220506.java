package leetcodeday;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/number-of-recent-calls/
 * 933. 最近的请求次数
 */
public class Day20220506 {
    public static void main(String[] args) {
        RecentCounter counter = new RecentCounter();
        System.out.println(1 == counter.ping(1));
        System.out.println(2 == counter.ping(100));
        System.out.println(3 == counter.ping(3001));
        System.out.println(3 == counter.ping(3002));
    }
}

/**
 * 自己有list记录的，因为是递增的，所以list倒着比较就可以
 */
class RecentCounter1 {
    List<Integer> counters;


    public RecentCounter1() {
        counters = new ArrayList<>();
    }

    public int ping(int t) {
        counters.add(t);
        int time = t - 3000;
        for (int i = counters.size() - 1; i >= 0; i--) {
            if (counters.get(i) < time) {
                return counters.size() - i - 1;
            }
        }
        return counters.size();
    }
}

/**
 * 自己做的，使用队列
 */
class RecentCounter {
    LinkedList<Integer> counters;


    public RecentCounter() {
        counters = new LinkedList<>();
    }

    public int ping(int t) {
        counters.add(t);
        int time = t - 3000;
        //因为每次都会把当前加入进来，当前肯定是满足要求的，所以不需要判断队列是否为空
        while (counters.peek() < time) {
            counters.poll();
        }
        return counters.size();
    }
}
