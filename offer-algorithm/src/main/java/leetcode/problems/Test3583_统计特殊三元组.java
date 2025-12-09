package leetcode.problems;

import java.util.*;

public class Test3583_统计特殊三元组 {

    public static void main(String[] args) {
        // nums = [6,3,6]
        System.out.println(new Solution().specialTriplets(new int[]{6, 3, 6}));
        // nums = [0,1,0,0]
        System.out.println(new Solution().specialTriplets(new int[]{0, 1, 0, 0}));
        // nums = [8,4,2,8,4]
        System.out.println(new Solution().specialTriplets(new int[]{8, 4, 2, 8, 4}));
    }

    static class Solution {
        public int specialTriplets(int[] nums) {
            Map<Integer, Integer> totalFreqMap = new HashMap<>();
            for (int num : nums) {
                totalFreqMap.put(num, totalFreqMap.getOrDefault(num, 0) + 1);
            }
            Map<Integer, Integer> currentFreqMap = new HashMap<>();
            int res = 0;
            int MOD = (int)(1e9 + 7);
            for (int num : nums) {
                currentFreqMap.put(num, currentFreqMap.getOrDefault(num, 0) + 1);
                int previousFreq = currentFreqMap.getOrDefault(num * 2, 0);
                int afterFreq = totalFreqMap.getOrDefault(num * 2, 0) - currentFreqMap.getOrDefault(num * 2, 0);
                if (num == num * 2) {
                    // 0的特殊处理
                    afterFreq = totalFreqMap.getOrDefault(0, 0) - currentFreqMap.getOrDefault(0, 0) - 1;
                }
                if (previousFreq > 0 && afterFreq > 0) {
                    res = (res + (int)(((long)previousFreq * afterFreq) % MOD)) % MOD;
                }
            }
            return res;
        }
    }

}
