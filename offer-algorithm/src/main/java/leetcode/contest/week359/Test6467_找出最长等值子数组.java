package leetcode.contest.week359;

import java.util.*;

public class Test6467_找出最长等值子数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().longestEqualSubarray(
                Arrays.asList(1, 3, 2, 3, 1, 3), 3
        ));
        System.out.println(new Solution().longestEqualSubarray(
                Arrays.asList(1, 1, 2, 2, 1, 1), 2
        ));
    }

    static class Solution {
        public int longestEqualSubarray(List<Integer> nums, int k) {
            int left = 0;
            int right = 0;
            int maxFreq = 0;
            int maxLength = 0;
            Map<Integer, Integer> countMap = new HashMap<>();
            for (right = 0; right < nums.size(); right++) {
                int num = nums.get(right);
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
                maxFreq = Math.max(maxFreq, countMap.get(num));
                // 如果窗口中需要删除的元素数量超过 k，移动左指针
                while (right - left + 1 - maxFreq > k) {
                    countMap.put(nums.get(left), countMap.get(nums.get(left)) - 1);
                    left++;
                }
                maxLength = Math.max(maxLength, maxFreq);
            }
            return maxLength;
        }
    }

}
