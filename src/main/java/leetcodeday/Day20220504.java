package leetcodeday;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/
 * 1823. 找出游戏的获胜者
 */
public class Day20220504 {
    public static void main(String[] args) {
        Day20220504 test = new Day20220504();
        System.out.println(1 == test.findTheWinner(5, 4));
        System.out.println(1 == test.findTheWinner(6, 5));
        System.out.println(3 == test.findTheWinner(5, 2));
    }

    public int findTheWinner1(int n, int k) {
        LinkedList nums = new LinkedList();
        for (int i = 0; i < n; i++) {
            nums.add(i);
        }
        return getResult(nums, k, 0);
    }

    //自己做，模拟方式，坐标计算：位置/数组长度，余数不为0就是实际要移动到的位置，为0就是末尾
    private int getResult(LinkedList<Integer> nums, int k, int start) {
        if (nums.size() == 1) {
            return nums.get(0) + 1;
        }
        int removeIndex = start + k - 1; //包括之间
        if (removeIndex < nums.size()) {
            nums.remove(removeIndex);
            start = removeIndex;
        } else {
            removeIndex = (removeIndex + 1) % nums.size();
            if (removeIndex == 0) {
                nums.remove(nums.size() - 1);
                start = 0;
            } else {
                nums.remove(removeIndex - 1);
                start = removeIndex - 1;
            }
        }
        return getResult(nums, k, start);
    }


    //官方的答案，用队列模拟行为，数完就加回去,第K个数就直接数不加回去
    public int findTheWinner(int n, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < k; i++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }
        return queue.poll();
    }

    //官方给的数学公式解
    public int findTheWinner2(int n, int k) {
        int winner = 1;
        for (int i = 2; i <= n; i++) {
            winner = (k + winner - 1) % i + 1;
        }
        return winner;
    }
}
