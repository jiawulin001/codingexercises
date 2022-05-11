package leetcodeday;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 * 442. 数组中重复的数据
 */
public class Day20220508 {

    public static void main(String[] args) {
        Day20220508 test = new Day20220508();
        List<Integer> result = test.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    //看评论提示自己做的
    //题目有一个约束：1 <= nums[i] <= n
    //说明数组中的数最大也是数组长度，而数组内的数字都是正整数所以可以利用输入数组来标记是否访问过了数字
    //标记方式：把访问过的数字和数组下标向对应，访问过了就对应相同数字下标内的数字变成负数，
    //所以每次访问前检测数字对应下标的数字是否为负数就知道是否访问过了
    //还有一种标记方式，因为数组内的数字最大也是数组长度，所以把数组内的数字加上N,就能知道是否访问过
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            } else {
                result.add(Math.abs(nums[i]));
            }
        }

        return result;
    }


    /**
     * 自己做的，偷懒用的HashSet
     */
    public List<Integer> findDuplicates1(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                result.add(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        return result;
    }
}
