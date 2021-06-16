package leetcode.problems;

public class Test0486_预测赢家 {

    public static void main(String[] args) {
        System.out.println(new Solution().PredictTheWinner(new int[]{0}));
        System.out.println(new Solution().PredictTheWinner(new int[]{1, 5, 2}));
        System.out.println(new Solution().PredictTheWinner(new int[]{1, 5, 233, 7}));
    }

    static class Solution {
        public boolean PredictTheWinner(int[] nums) {
            // dp[i][j]表示i,j取范围之差最大的数
            int len = nums.length;
            int[][] dp = new int[len][len];
            for (int i = 0; i < len; i++) {
                dp[i][i] = nums[i];
            }
            // dp[i][j] = max(nums[i]-dp[i+1][j], nums[j]-dp[i][j-1])
            for (int i = len - 2; i >= 0; i--) {
                for (int j = i + 1; j < len; j++) {
                    dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
                }
            }
            return dp[0][len - 1] >= 0;
        }
    }

    static class Solution_递归 {
        public boolean PredictTheWinner(int[] nums) {
            // 判断Alice最赚的最大分数扣掉bob赚的最大分数是否大于0
            return check(nums, 0, nums.length - 1, true) >= 0;
        }

        private int check(int[] nums, int start, int end, boolean isAlice) {
            if (start == end) {
                return nums[start] * (isAlice ? 1 : -1);
            }
            if (isAlice) {
                // Alice本轮尽可能拿最大的数
                int aliceTakeFirst = nums[start] + check(nums, start + 1, end, !isAlice);
                int aliceTakeLast = nums[end] + check(nums, start, end - 1, !isAlice);
                return Math.max(aliceTakeFirst, aliceTakeLast);
            } else {
                // Bob本轮尽可能拿最小的数
                int bobTakeFirst = nums[start] * -1 + check(nums, start + 1, end, !isAlice);
                int bobTakeLast = nums[end] * -1 + check(nums, start, end - 1, !isAlice);
                return Math.min(bobTakeFirst, bobTakeLast);
            }
        }
    }

}
