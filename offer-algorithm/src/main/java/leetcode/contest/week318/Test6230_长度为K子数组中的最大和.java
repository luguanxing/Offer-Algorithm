package leetcode.contest.week318;

import java.util.HashMap;
import java.util.Map;

public class Test6230_长度为K子数组中的最大和 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3));
        System.out.println(new Solution().maximumSubarraySum(new int[]{4, 4, 4}, 3));
        System.out.println(new Solution().maximumSubarraySum(new int[]{1, 5, 4, 8, 9, 9, 9}, 3));
    }

    static class Solution {
        public long maximumSubarraySum(int[] nums, int k) {
            long maxSum = 0;
            Map<Integer, Integer> window = new HashMap<>();
            long windowSum = 0;
            // init window
            for (int i = 0; i < k; i++) {
                int num = nums[i];
                windowSum += num;
                window.put(num, window.getOrDefault(num, 0) + 1);
            }
            if (window.size() == k) {
                maxSum = windowSum;
            }
            // slide window
            for (int i = k; i < nums.length; i++) {
                int currentNum = nums[i];
                int lastNum = nums[i - k];
                window.put(currentNum, window.getOrDefault(currentNum, 0) + 1);
                window.put(lastNum, window.getOrDefault(lastNum, 0) - 1);
                windowSum += currentNum;
                windowSum -= lastNum;
                if (window.get(lastNum) == 0) {
                    window.remove(lastNum);
                }
                if (window.size() == k && windowSum > maxSum) {
                    maxSum = windowSum;
                }
            }
            return maxSum;
        }
    }

}
