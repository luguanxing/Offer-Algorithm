package leetcode.problems;

import java.util.Arrays;

public class Test3040_相同分数的最大操作数目II {

    public static void main(String[] args) {
        System.out.println(new Solution_DFS().maxOperations(new int[]{3, 2, 1, 2, 3, 4}));
        System.out.println(new Solution_DFS().maxOperations(new int[]{3, 2, 6, 1, 4}));
        System.out.println(new Solution_DFS().maxOperations(new int[]{1, 1, 1, 1, 1, 1, 2, 1, 1, 2}));
        System.out.println(new Solution_DFS().maxOperations(new int[]{1, 9, 7, 3, 2, 7, 4, 12, 2, 6}));
        System.out.println(new Solution_DFS().maxOperations(new int[]{2, 2, 1, 2, 1}));
    }

    static class Solution {
        public int maxOperations(int[] nums) {
            int len = nums.length;
            int sum1 = nums[0] + nums[1];
            int sum2 = nums[0] + nums[len - 1];
            int sum3 = nums[len - 1] + nums[len - 2];
            int res1 = findMaxOperations(nums, sum1);
            int res2 = findMaxOperations(nums, sum2);
            int res3 = findMaxOperations(nums, sum3);
            return Math.max(res1, Math.max(res2, res3));
        }

        private int findMaxOperations(int[] nums, int sum) {
            int currentMax = 0;
            int len = nums.length;
            // dp[l][r]表示sum凑出从l到r的最大操作数目
            // dp[l][r] = max(dp[l][r], dp[l][r-2]，若后两位为sum)
            // dp[l][r] = max(dp[l][r], dp[l+2][r]，若前两位为sum)
            // dp[l][r] = max(dp[l][r], dp[l+1][r-1]，若前后两位为sum)
            // 综上，dp[l][r]由矩阵左边、下边和左下计算生成，因此遍历顺序从下到上，从左到右
            int[][] dp = new int[len][len];
            for (int l = len - 1; l >= 0; l--) {
                for (int r = l + 1; r < len; r++) {
                    if (r - 2 >= 0 && nums[r] + nums[r - 1] == sum) {
                        dp[l][r] = Math.max(dp[l][r], dp[l][r - 2] + 1);
                    }
                    if (l + 2 < len && nums[l] + nums[l + 1] == sum) {
                        dp[l][r] = Math.max(dp[l][r], dp[l + 2][r] + 1);
                    }
                    if (r - 1 >= 0 && l + 1 < len && nums[l] + nums[r] == sum) {
                        dp[l][r] = Math.max(dp[l][r], dp[l + 1][r - 1] + 1);
                    }
                    currentMax = Math.max(currentMax, dp[l][r]);
                }
            }
            return dp[0][len - 1];
        }
    }

    // 纯DFS会超时，可以使用记忆化进行优化
    static class Solution_DFS {
        private int[][] memo;

        public int maxOperations(int[] nums) {
            int len = nums.length;
            memo = new int[len][len];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }
            int max = 1;
            int sum1 = nums[0] + nums[1];
            max = Math.max(max, calculateMaxOperationsForSum(nums, sum1));
            int sum2 = nums[0] + nums[len - 1];
            max = Math.max(max, calculateMaxOperationsForSum(nums, sum2));
            int sum3 = nums[len - 1] + nums[len - 2];
            max = Math.max(max, calculateMaxOperationsForSum(nums, sum3));
            return max;
        }

        // 每次计算需要清除memo
        private int calculateMaxOperationsForSum(int[] nums, int sum) {
            int len = nums.length;
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }
            dfs(nums, 0, len - 1, sum);
            return memo[0][len - 1];
        }

        private int dfs(int[] nums, int left, int right, int target) {
            if (left >= right) {
                return 0;
            }
            if (memo[left][right] != -1) {
                return memo[left][right];
            }
            int currentMax = 0;
            if (nums[left] + nums[left + 1] == target) {
                int res = dfs(nums, left + 2, right, target);
                currentMax = Math.max(currentMax, res + 1);
            }
            if (nums[left] + nums[right] == target) {
                int res = dfs(nums, left + 1, right - 1, target);
                currentMax = Math.max(currentMax, res + 1);
            }
            if (nums[right] + nums[right - 1] == target) {
                int res = dfs(nums, left, right - 2, target);
                currentMax = Math.max(currentMax, res + 1);
            }
            memo[left][right] = currentMax;
            return currentMax;
        }
    }

}
