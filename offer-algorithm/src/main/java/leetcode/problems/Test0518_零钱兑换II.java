package leetcode.problems;

public class Test0518_零钱兑换II {

    public static void main(String[] args) {
        System.out.println(new Solution().change(5, new int[]{1, 2, 5}));
        System.out.println(new Solution().change(3, new int[]{2}));
        System.out.println(new Solution().change(10, new int[]{10}));
    }

    static class Solution {
        public int change(int amount, int[] coins) {
            // dp[i][j]表示用前i枚硬币凑出j元的方法
            int[][] dp = new int[coins.length + 1][amount + 1];
            for (int i = 0; i <= coins.length; i++) {
                dp[i][0] = 1;
            }
            for (int i = 1; i <= coins.length; i++) {
                for (int j = 1; j <= amount; j++) {
                    int coin = coins[i - 1];
                    if (j < coin) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        int withI = dp[i][j - coin];
                        int withoutI = dp[i - 1][j];
                        dp[i][j] = withI + withoutI;
                    }
                }
            }
            return dp[coins.length][amount];
        }
    }

}
