package leetcode.test2;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {-4, 0, 1, 3, 5, 7, 10};
        //
        // System.out.println(findMagicIndex(nums));
        a(null, 0);

    }


    public static int findMagicIndex(int[] nums) {
        return getAnswer(nums, 0, nums.length - 1);
    }

    public static int getAnswer(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (right - left) / 2 + left;
        int leftAnswer = getAnswer(nums, left, mid - 1); //先找左边
        if (leftAnswer != -1) {
            return leftAnswer;
        } else if (nums[mid] == mid) {
            return mid;
        }
        return getAnswer(nums, mid + 1, right);//左边没有找右边
    }


    public static void a(int[] nums, int target) {
        nums = new int[]{2, 7, 11, 15};
        target = 9;
        HashMap<Integer, Integer> map = new HashMap<>();
        int diff;
        for (int i = 0; i < nums.length; i++) {
            diff = target - nums[i];
            if (map.keySet().contains(diff)) {
                System.out.println(map.get(nums[i]) + "," + i);
                break;
            }
            map.put(nums[i], i);
        }
    }
}
