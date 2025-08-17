package leetcode.problems;

public class Test0837_新21点 {

    public static void main(String[] args) {
        System.out.println(new Solution().new21Game(10, 1, 10));
        System.out.println(new Solution().new21Game(6, 1, 10));
        System.out.println(new Solution().new21Game(21, 17, 10));
    }

    static class Solution {
        public double new21Game(int n, int k, int maxPts) {
            // dp[i] 表示当当前分数为 i 时，获胜的概率
            double[] dp = new double[n + 1];
            // 当 i >= k 时，获胜的概率为 1
            // 否则 dp[i] = (dp[i+1] + dp[i+2] + ... + dp[i+maxPts]) / maxPts
            double sum = 0.0;
            for (int i = n; i >= 0; i--) {
                if (i >= k) {
                    dp[i] = 1.0;
                } else {
                    dp[i] = sum / maxPts;
                }
                sum += dp[i];
                if (i + maxPts <= n) {
                    sum -= dp[i + maxPts];
                }
            }
            return dp[0];
        }
    }

}
