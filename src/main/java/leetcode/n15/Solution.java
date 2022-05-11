package leetcode.n15;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    //https://leetcode-cn.com/problems/3sum/

    public static void main(String[] args) {
        //int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        Solution s = new Solution();
        System.out.println(JSON.toJSONString(s.threeSum(nums)));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int num1;
        int num2;
        //a + b + c = 0; a = -b+c
        int begin, end;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            num1 = -nums[i];
            begin = i + 1;
            end = nums.length - 1;
            while (begin < end) {
                num2 = nums[begin] + nums[end];
                if (num1 == num2) {
                    result.add(Arrays.asList(nums[i], nums[begin], nums[end]));
                    while (begin < end && nums[begin] == nums[++begin]) ;
                    while (begin < end && nums[end] == nums[--end]) ;
                } else if (num1 > num2) {
                    begin++;
                } else if (num1 < num2) {
                    end--;
                }
            }
        }

        return result;
    }
}