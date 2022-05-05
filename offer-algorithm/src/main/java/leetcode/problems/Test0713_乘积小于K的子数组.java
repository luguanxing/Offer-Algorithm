package leetcode.problems;

public class Test0713_乘积小于K的子数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(new Solution().numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
        System.out.println(new Solution().numSubarrayProductLessThanK(new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3}, 19));
    }

    static class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            if (k == 0 || k == 1) {
                return 0;
            }
            // 快慢指针，中间先找出nums[r]结尾不超过k的最大乘积，然后中间子集都符合条件，总数为right - left + 1
            int res = 0;
            int left = 0;
            int current = 1;
            for (int right = 0; right < nums.length; right++) {
                current *= nums[right];
                while (current >= k) {
                    current /= nums[left++];
                }
                res += right - left + 1;
            }
            return res;
        }
    }

    static class Solution_DP {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            // dp[i]表示以nums[i]结尾时的子数组数,
            // dp[i] = dp[i-1] + left*(left+1)/2，其中left表示以nums[i]结尾的向左延伸的乘积不超过k最长长度
            int len = nums.length;
            int[] dp = new int[len];
            dp[0] = nums[0] < k ? 1 : 0;
            for (int i = 1; i < len; i++) {
                int current = nums[i];
                int leftLen =  current < k ? 1 : 0;
                for (int left = 1; i - left >= 0; left++) {
                    current *= nums[i - left];
                    if (current < k) {
                        leftLen = left + 1;
                    } else {
                        break;
                    }
                }
                dp[i] = dp[i - 1] + leftLen;
            }
            return dp[len - 1];
        }
    }

}
