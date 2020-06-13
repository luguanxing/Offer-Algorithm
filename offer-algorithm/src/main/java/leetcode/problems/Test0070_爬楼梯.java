package leetcode.problems;

public class Test0070_爬楼梯 {

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(1));
        System.out.println(new Solution().climbStairs(2));
        System.out.println(new Solution().climbStairs(3));
    }

    static class Solution {
        public int climbStairs(int n) {
            if (n <= 0) {
                return 0;
            }
            int[] dp = new int[n + 2];
            dp[1] = 1;
            dp[2] = 2;
            // 第N层楼可由第N-1楼或第N-2楼上来
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

}
