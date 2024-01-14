package leetcode.contest.week380;

import java.util.*;

public class Test100162_最大频率元素计数 {

    public static void main(String[] args) {
        // nums = [1,2,2,3,1,4]
        System.out.println(new Solution().maxFrequencyElements(new int[]{1, 2, 2, 3, 1, 4}));
        // nums = [1,2,3,4,5]
        System.out.println(new Solution().maxFrequencyElements(new int[]{1, 2, 3, 4, 5}));
    }

    static class Solution {
        public int maxFrequencyElements(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int max = map.values().stream().max(Comparator.comparingInt(o -> o)).get();
            int cnt = 0;
            for (int v : map.values()) {
                if (v == max) {
                    cnt += v;
                }
            }
            return cnt;
        }
    }

}
