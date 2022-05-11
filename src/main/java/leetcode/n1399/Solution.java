package leetcode.n1399;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.getNumbSum(108);
        System.out.println(s.countLargestGroup(174));
    }

    public int countLargestGroup(int n) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int maxValue = 0;
        for (int i = 1; i <= n; ++i) {
            int key = 0, i0 = i;
            while (i0 != 0) {
                key += i0 % 10;
                i0 /= 10;
            }
            if (key == 9) {
                System.out.println(i);
            }
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
            maxValue = Math.max(maxValue, hashMap.get(key));
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> kvpair : hashMap.entrySet()) {
            if (kvpair.getValue() == maxValue) {
                ++count;
            }
        }
        return count;
    }

    public int countLargestGroup1(int n) {
        int[] map = new int[n + 1];
        int sum;
        int maxCount = 0;
        int countGroup = 0;
        for (int i = 1; i <= n; i++) {
            sum = getNumbSum(i);
            if (sum == 9 || sum == 10) {
                System.out.println(sum + ":" + i);
            }
            map[sum] += 1;
            if (maxCount < map[sum]) {
                countGroup = 1;
                maxCount = map[sum];
            } else if (maxCount == map[sum]) {
                countGroup++;
            }
        }
        return countGroup;
    }

    private int getNumbSum(int num) {
        int remainder = num;
        int sum = 0;
        do {
            sum += remainder % 10;
            remainder = remainder / 10;
        } while (remainder > 9);
        sum += remainder;
        return sum;
    }

    private String getNumbs(int num) {
        System.out.println("------" + num);
        StringBuffer sb = new StringBuffer();
        int remainder = num;
        int val;
        do {
            val = remainder % 10;
            remainder = remainder / 10;
            sb.append(val);
            sb.append(" ");
        } while (remainder > 10);
        sb.append(remainder);
        return sb.reverse().toString();
    }
}