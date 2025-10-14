package leetcode.problems;

import java.util.Arrays;
import java.util.List;

public class Test3349_检测相邻递增子数组I {

    public static void main(String[] args) {
        // nums = [2,5,7,8,9,2,3,4,3,1], k = 3
        System.out.println(new Solution().hasIncreasingSubarrays(Arrays.asList(2, 5, 7, 8, 9, 2, 3, 4, 3, 1), 3));
        // nums = [1,2,3,4,4,4,4,5,6,7], k = 5
        System.out.println(new Solution().hasIncreasingSubarrays(Arrays.asList(1, 2, 3, 4, 4, 4, 4, 5, 6, 7), 5));
        // nums = [-15, 9], k = 1
        System.out.println(new Solution().hasIncreasingSubarrays(Arrays.asList(-15, 9), 1));
    }

    static class Solution {
        public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
            int len = nums.size();
            int[] dp = new int[len];
            dp[0] = 1;
            for (int i = 1; i < len; i++) {
                if (nums.get(i) > nums.get(i - 1)) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = 1;
                }
                if (dp[i] >= k && i - k >= 0 && dp[i - k] >= k) {
                    return true;
                }
            }
            return false;
        }
    }

}
