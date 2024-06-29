package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test0494_目标和 {

    public static void main(String[] args) {
        System.out.println(new Solution().findTargetSumWays(
                new int[]{1, 1, 1, 1, 1}, 3
        ));
        System.out.println(new Solution().findTargetSumWays(
                new int[]{1}, 1
        ));
    }

    static class Solution {
        Map<String, Integer> memo = new HashMap<>();

        public int findTargetSumWays(int[] nums, int target) {
            return dfs(nums, nums.length - 1, target);
        }

        private int dfs(int[] nums, int endIndex, int target) {
            if (endIndex == -1) {
                return target == 0 ? 1 : 0;
            }
            if (memo.containsKey(endIndex + "-" + target)) {
                return memo.get(endIndex + "-" + target);
            }
            int num = nums[endIndex];
            int res = 0;
            res += dfs(nums, endIndex - 1, target - num);
            res += dfs(nums, endIndex - 1, target + num);
            memo.put(endIndex + "-" + target, res);
            return res;
        }
    }

    class Solution_DP {
        public int findTargetSumWays(int[] nums, int target) {
            // sum(子集1) - sum(子集2) = target
            // sum(子集1) - (sum(全集) - sum(子集1)) = target
            // 2 * sum(子集1) = target + sum(全集)
            // 求出 sum(子集1) = (target + sum(全集)) / 2 方法数
            int sum = Arrays.stream(nums).sum();
            if (sum < target || (target + sum) % 2 == 1 || target + sum < 0) {
                return 0;
            }
            int[] dp = new int[(target + sum) / 2 + 1];
            dp[0] = 1;
            for (int num : nums) {
                for (int i = (target + sum) / 2; i >= num; i--) {
                    dp[i] += dp[i - num];
                }
            }
            return dp[(target + sum) / 2];
        }
    }

    static class Solution_递归 {
        int res = 0;

        public int findTargetSumWays(int[] nums, int target) {
            check(nums, 0, target);
            return res;
        }

        private void check(int[] nums, int index, int target) {
            if (index >= nums.length) {
                if (target == 0) {
                    res++;
                }
                return;
            }
            int num = nums[index];
            check(nums, index + 1, target - num);
            check(nums, index + 1, target + num);
        }
    }

}
