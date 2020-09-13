package leetcode.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test0322_零钱兑换 {

    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new Solution().coinChange(new int[]{2}, 3));
        System.out.println(new Solution().coinChange(new int[]{186, 419, 83, 408}, 6249));
    }

    static class Solution {
        public int coinChange(int[] coins, int amount) {
            // dp[i]表示凑出i元使用的最少硬币数量
            int[] dp = new int[amount + 1];
            Set<Integer> coinSet = Arrays
                    .stream(coins)
                    .boxed()
                    .collect(Collectors.toSet());
            // 凑出i元时肯定是(i - coin)元加上coin元凑出来的
            for (int i = 1; i <= amount; i++) {
                if (coinSet.contains(i)) {
                    dp[i] = 1;
                } else {
                    // 不能用最大的数，因为+1会溢出
                    dp[i] = Integer.MAX_VALUE / 2;
                    for (int coin : coinSet) {
                        if (coin <= i) {
                            dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                        }
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }

}
