package leetcode.problems;

import java.util.*;

public class Test2364_统计坏数对的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().countBadPairs(new int[]{4, 1, 3, 3}));
        System.out.println(new Solution().countBadPairs(new int[]{1, 2, 3, 4, 5}));
    }

    static class Solution {
        public long countBadPairs(int[] nums) {
            int len = nums.length;
            // 先记好数，即拥有相同的nums[i] - i == nums[j] - j
            Map<Integer, Integer> goodNumMap = new HashMap<>();
            for (int i = 0; i < len; i++) {
                goodNumMap.put(nums[i] - i, goodNumMap.getOrDefault(nums[i] - i, 0) + 1);
            }
            long goodNumPairsCnt = 0;
            for (int cnt : goodNumMap.values()) {
                goodNumPairsCnt += (long) cnt * (cnt - 1) / 2;
            }
            // 总数对-好数对=坏数对
            return (long) len * (len - 1) / 2 - goodNumPairsCnt;
        }
    }

}
