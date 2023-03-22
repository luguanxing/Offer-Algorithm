package leetcode.problems;

import java.util.Arrays;

public class Test1626_无矛盾的最佳球队 {

    public static void main(String[] args) {
        System.out.println(new Solution().bestTeamScore(
                new int[]{1, 3, 5, 10, 15},
                new int[]{1, 2, 3, 4, 5}
        ));
        System.out.println(new Solution().bestTeamScore(
                new int[]{4, 5, 6, 5},
                new int[]{2, 1, 2, 1}
        ));
        System.out.println(new Solution().bestTeamScore(
                new int[]{1, 2, 3, 5},
                new int[]{8, 9, 10, 1}
        ));
    }

    static class Solution {
        public int bestTeamScore(int[] scores, int[] ages) {
            // 按分数、年龄升序排序
            int len = scores.length;
            int[][] players = new int[len][2];
            for (int i = 0; i < len; i++) {
                players[i][0] = scores[i];
                players[i][1] = ages[i];
            }
            Arrays.sort(players, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
            // 假设dp[i]为到第i名球员的最大分数
            // dp[i] = max( dp[j]+player[i][0] & player[i][1]>player[j][1] )
            int[] dp = new int[len];
            dp[0] = players[0][0];
            for (int i = 1; i < len; i++) {
                dp[i] = players[i][0];
                for (int j = 0; j < i; j++) {
                    if (players[i][1] >= players[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + players[i][0]);
                    }
                }
            }
            return Arrays.stream(dp).max().getAsInt();
        }
    }

}
