package leetcode.problems;

public class Test0474_一和零 {

    public static void main(String[] args) {
        // strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
        System.out.println(new Solution().findMaxForm(
                new String[]{"10", "0001", "111001", "1", "0"},
                5,
                3
        ));
        // strs = ["10", "0", "1"], m = 1, n = 1
        System.out.println(new Solution().findMaxForm(
                new String[]{"10", "0", "1"},
                1,
                1
        ));
        System.out.println(new Solution().findMaxForm(
                new String[]{"00","000"},
                1,
                10
        ));
    }

    static class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int len = strs.length;
            // dp[x][i][j]表示在前x个字符串有i个0和j个1的情况下，能组成的字符串的最大数量
            int[][][] dp = new int[len + 1][m + 1][n + 1];
            // 对于dp[x]考虑两种情况：要么不选第x个字符串，要么选第x个字符串（在能选的情况下）
            // dp[x][i][j] = max(dp[x-1][i][j], dp[x-1][i - cntsX[0]][j - cntsX[1]] + 1)
            for (int x = 1; x <= len; x++) {
                int[] cntsX = getCnts(strs[x - 1]);
                for (int i = 0; i <= m; i++) {
                    for (int j = 0; j <= n; j++) {
                        dp[x][i][j] = dp[x - 1][i][j];
                        if (i >= cntsX[0] && j >= cntsX[1]) {
                            dp[x][i][j] = Math.max(
                                    dp[x][i][j],
                                    dp[x - 1][i - cntsX[0]][j - cntsX[1]] + 1
                            );
                        }
                    }
                }
            }
            return dp[len][m][n];
        }

        private int[] getCnts(String str) {
            int[] cnts = new int[2];
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    cnts[0]++;
                } else {
                    cnts[1]++;
                }
            }
            return cnts;
        }
    }

}
