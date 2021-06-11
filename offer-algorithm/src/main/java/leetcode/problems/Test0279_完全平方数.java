package leetcode.problems;

public class Test0279_完全平方数 {

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(12));
        System.out.println(new Solution().numSquares(13));
        System.out.println(new Solution().numSquares(4));
        System.out.println(new Solution().numSquares(1));
        System.out.println(new Solution().numSquares(2));
    }

    static class Solution {
        public int numSquares(int n) {
            // dp[i]表示使用最少平方数凑出n的个数
            // dp[i]=min(dp[i-j*j]+1)
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = i;
                for (int j = 1; j * j <= i; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
            return dp[n];
        }
    }

}
