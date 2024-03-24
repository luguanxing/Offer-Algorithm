package leetcode.contest.week390;

import java.util.*;

public class Test100258_最高频率的ID {

    public static void main(String[] args) {
        // nums = [2,3,2,1], freq = [3,2,-3,1]
        System.out.println(Arrays.toString(new Solution().mostFrequentIDs(new int[]{2, 3, 2, 1}, new int[]{3, 2, -3, 1})));
        // nums = [5,5,3], freq = [2,-2,1]
        System.out.println(Arrays.toString(new Solution().mostFrequentIDs(new int[]{5, 5, 3}, new int[]{2, -2, 1})));
    }

    static public class Solution {
        public long[] mostFrequentIDs(int[] nums, int[] freq) {
            HashMap<Long, Long> numFreqMap = new HashMap<>();
            TreeMap<Long, Long> freqCountMap = new TreeMap<>();
            long[] ans = new long[nums.length];
            for (int i = 0; i < nums.length; i++) {
                long num = nums[i];
                long frequency = freq[i];
                long currentFreq = numFreqMap.getOrDefault(num, 0L);
                long newFreq = currentFreq + frequency;
                // 更新numFreqMap
                if (newFreq == 0) {
                    numFreqMap.remove(num);
                } else {
                    numFreqMap.put(num, newFreq);
                }

                // 更新freqCountMap
                if (currentFreq > 0) {
                    freqCountMap.put(currentFreq, freqCountMap.get(currentFreq) - 1);
                    if (freqCountMap.get(currentFreq) == 0) {
                        freqCountMap.remove(currentFreq);
                    }
                }
                if (newFreq > 0) {
                    freqCountMap.put(newFreq, freqCountMap.getOrDefault(newFreq, 0L) + 1);
                }
                // 计算结果
                if (freqCountMap.isEmpty()) {
                    ans[i] = 0;
                } else {
                    ans[i] = freqCountMap.lastEntry().getKey();
                }
            }
            return ans;
        }
    }

}
