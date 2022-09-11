package leetcode.contest.week310;

import java.util.Map;
import java.util.TreeMap;

public class Test6176_出现最频繁的偶数元素 {

    public static void main(String[] args) {
        System.out.println(new Solution().mostFrequentEven(new int[]{0, 1, 2, 2, 4, 4, 1}));
        System.out.println(new Solution().mostFrequentEven(new int[]{4, 4, 4, 9, 2, 4}));
        System.out.println(new Solution().mostFrequentEven(new int[]{29, 47, 21, 41, 13, 37, 25, 7}));
    }

    static class Solution {
        public int mostFrequentEven(int[] nums) {
            Map<Integer, Integer> cntMap = new TreeMap<>();
            for (int num : nums) {
                if (num % 2 == 0) {
                    cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
                }
            }
            if (cntMap.isEmpty()) {
                return -1;
            }
            int maxFreq = cntMap.values().stream().max(Integer::compare).get();
            for (int num : cntMap.keySet()) {
                if (cntMap.get(num) == maxFreq) {
                    return num;
                }
            }
            return -1;
        }
    }

}
