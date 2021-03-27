package leetcode.n373;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        Solution s = new Solution();
        System.out.println(JSON.toJSONString(s.kSmallestPairs(nums1, nums2, k)));
    }


    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int length = nums1.length == 0 ? 1 : nums1.length * nums2.length == 0 ? 1 : nums2.length;

        List<List<Integer>> result = new ArrayList<>();
        PriorityBlockingQueue<Integer[]> queue = new PriorityBlockingQueue<>(length, Comparator.comparingInt(a -> a[1] + a[0]));
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                queue.add(new Integer[]{nums1[i], nums2[j]});
            }
        }
        while (!queue.isEmpty() && result.size() < k) {
            result.add(Arrays.asList(queue.poll()));
        }
        return result;
    }
}
