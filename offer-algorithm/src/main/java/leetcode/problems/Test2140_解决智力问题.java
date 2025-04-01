package leetcode.problems;

import java.util.Arrays;

public class Test2140_解决智力问题 {

    public static void main(String[] args) {
        // questions = [[3,2],[4,3],[4,4],[2,5]]
        System.out.println(new Solution().mostPoints(new int[][]{{3, 2}, {4, 3}, {4, 4}, {2, 5}}));
        // questions = [[1,1],[2,2],[3,3],[4,4],[5,5]]
        System.out.println(new Solution().mostPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}}));
        // questions = [[12,46],[78,19],[63,15],[79,62],[13,10]]
        System.out.println(new Solution().mostPoints(new int[][]{{12, 46}, {78, 19}, {63, 15}, {79, 62}, {13, 10}}));
    }

    static class Solution {
        public long mostPoints(int[][] questions) {
            int len = questions.length;
            // dp[i]表示以第i个问题开始的最大分数
            // 因为根据后边找最大值确定，根据前面找最大值不确定，所以从后往前
            // dp[i] = max(dp[i+1], dp[i+questions[i][1]]+questions[i][0])
            long[] dp = new long[len];
            for (int i = len - 1; i >= 0; i--) {
                int score = questions[i][0];
                int cd = questions[i][1];
                long notTakeScore = (i + 1 >= len ? 0 : dp[i + 1]);
                long takeScore = (i + 1 + cd >= len ? 0 : dp[i + 1 + cd]) + score;
                dp[i] = Math.max(notTakeScore, takeScore);
            }
            return dp[0];
        }
    }

    static class Solution_超时DP {
        public long mostPoints(int[][] questions) {
            int len = questions.length;
            // dp[i]表示前i个问题的最大分数
            // dp[i] = max(dp[i-j]+questions[j][0]) && i-j>questions[j][1]
            long[] dp = new long[len];
            for (int i = 0; i < len; i++) {
                dp[i] = questions[i][0];
                for (int j = 0; j < i; j++) {
                    if (i - j > questions[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + questions[i][0]);
                    }
                }
            }
            return Arrays.stream(dp).max().getAsLong();
        }
    }

}
