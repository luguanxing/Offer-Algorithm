package leetcode.problems;

import java.util.Arrays;
import java.util.List;

public class Test3350_检测相邻递增子数组II {

    public static void main(String[] args) {
        // nums = [2,5,7,8,9,2,3,4,3,1]
        System.out.println(new Solution().maxIncreasingSubarrays(Arrays.asList(2, 5, 7, 8, 9, 2, 3, 4, 3, 1)));
        // nums = [1,2,3,4,4,4,4,5,6,7]
        System.out.println(new Solution().maxIncreasingSubarrays(Arrays.asList(1, 2, 3, 4, 4, 4, 4, 5, 6, 7)));
    }

    static class Solution {
        public int maxIncreasingSubarrays(List<Integer> nums) {
            int len = nums.size();
            int[] dp = new int[len];
            int maxK = 1;
            dp[0] = 1;
            for (int i = 1; i < len; i++) {
                if (nums.get(i) > nums.get(i - 1)) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = 1;
                }
                // 前一段和后一段分开递增
                int curLen = dp[i];
                if (i - curLen >= 0 && dp[i - curLen] >= curLen) {
                    maxK = Math.max(maxK, curLen);
                }
                // 前一段和后一段一直递增
                if (i - curLen / 2 >= 0 && dp[i - curLen / 2] >= curLen / 2) {
                    maxK = Math.max(maxK, curLen / 2);
                }
            }
            return maxK;
        }
    }

    static class Solution_二分 {
        public int maxIncreasingSubarrays(List<Integer> nums) {
            int len = nums.size();
            int l = 0;
            int r = len;
            while (l < r) {
                int mid = (l + r) / 2;
                if (hasIncreasingSubarrays(nums, mid)) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l - 1;
        }

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
                // 当前位置和前k个位置都满足递增子数量>=k
                if (dp[i] >= k && i - k >= 0 && dp[i - k] >= k) {
                    return true;
                }
            }
            return false;
        }
    }

}
