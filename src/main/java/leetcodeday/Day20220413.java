package leetcodeday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 * 380. O(1) 时间插入、删除和获取随机元素
 */
public class Day20220413 {
    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        rs.insert(0);
        rs.insert(1);
        rs.remove(0);
        rs.insert(2);
        rs.remove(1);
        System.out.println(2 == rs.getRandom());


        Random random = new Random();
        random.nextInt(123);
    }

    /**
     * 重点看remove方法
     * 官方思路是，删除元素时，把要删除的元素和最后一个元素交换，然后在删除最后一个元素，就不会破坏数组的顺序和结构
     */
    static class RandomizedSet {
        HashMap<Integer, Integer> set;
        List<Integer> vals;

        public RandomizedSet() {
            set = new HashMap<>();
            vals = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (set.containsKey(val)) {
                return false;
            }
            set.put(val, vals.size());
            vals.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!set.containsKey(val)) {
                return false;
            }

            int index = set.get(val);
            int lastVal = vals.get(vals.size() - 1);
            set.put(lastVal, index);
            vals.set(index, lastVal);

            vals.remove(vals.size() - 1);
            set.remove(val);
            return true;
        }

        public int getRandom() {
            return vals.get((int) (Math.random() * vals.size()));
        }
    }

    /**
     * 重点看getRandom方法
     * 我的思路是，采用hash方式增加和删除，随机访问的时候，提取所有的value变成一个数组
     */
    class RandomizedSet1 {
        HashMap<Integer, Integer> set;

        public RandomizedSet1() {
            set = new HashMap<>();
        }

        public boolean insert(int val) {
            if (set.containsKey(val)) {
                return false;
            }
            set.put(val, val);
            return true;
        }

        public boolean remove(int val) {
            if (!set.containsKey(val)) {
                return false;
            }
            set.remove(val);
            return true;
        }

        public int getRandom() {
            Object[] vals = set.values().toArray();
            return (int) vals[(int) (Math.random() * vals.length)];
        }
    }
}
