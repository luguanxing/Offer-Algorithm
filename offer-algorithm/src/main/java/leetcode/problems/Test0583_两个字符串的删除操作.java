package leetcode.problems;

public class Test0583_两个字符串的删除操作 {

    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("sea", "eat"));
        System.out.println(new Solution().minDistance("leetcode", "etco"));
        System.out.println(new Solution().minDistance("mart", "karma"));
    }

    static class Solution {
        public int minDistance(String word1, String word2) {
            // 先找最长公共子序列长度
            int[][] dp = new int[word2.length()][word1.length()];
            for (int x = 0; x < word1.length(); x++) {
                if (word1.substring(0, x + 1).contains(word2.charAt(0) + "")) {
                    dp[0][x] = 1;
                }
            }
            for (int y = 0; y < word2.length(); y++) {
                if (word2.substring(0, y + 1).contains(word1.charAt(0) + "")) {
                    dp[y][0] = 1;
                }
            }
            for (int y = 1; y < word2.length(); y++) {
                for (int x = 1; x < word1.length(); x++) {
                    dp[y][x] = 0;
                    if (word2.charAt(y) == word1.charAt(x)) {
                        dp[y][x] = Math.max(dp[y][x], dp[y - 1][x - 1] + 1);
                    }
                    dp[y][x] = Math.max(dp[y][x], dp[y - 1][x]);
                    dp[y][x] = Math.max(dp[y][x], dp[y][x - 1]);
                }
            }
            int maxLen = dp[word2.length() - 1][word1.length() - 1];
            // 再计算两个字符串变成最长公共子序列的操作数
            return (word1.length() - maxLen) + (word2.length() - maxLen);
        }
    }

    static class Solution_删除DP {
        public int minDistance(String word1, String word2) {
            // dp[i][j]表示word1[0-i]和word2[0-j]通过删除达到相同的最少步数
            int[][] dp = new int[word2.length()][word1.length()];
            if (word1.charAt(0) != word2.charAt(0)) {
                dp[0][0] = 2;
            }
            for (int x = 1; x < word1.length(); x++) {
                if (word1.substring(0, x + 1).contains(word2.charAt(0) + "")) {
                    dp[0][x] = x;
                } else {
                    dp[0][x] = x + 2;
                }
            }
            for (int y = 1; y < word2.length(); y++) {
                if (word2.substring(0, y + 1).contains(word1.charAt(0) + "")) {
                    dp[y][0] = y;
                } else {
                    dp[y][0] = y + 2;
                }
            }
            /**
             * dp[i][j] = min(
             *      当word1[i]==word2[j]时，dp[i-1][j-1]
             *      删word1[i]时，dp[i-1][j]
             *      删word2[j]时，dp[i][j-1]
             *      删word1[i]和word2[j]时，dp[i-1][j-1]
             *  )
             */
            for (int y = 1; y < word2.length(); y++) {
                for (int x = 1; x < word1.length(); x++) {
                    dp[y][x] = Integer.MAX_VALUE;
                    if (word1.charAt(x) == word2.charAt(y)) {
                        dp[y][x] = Math.min(dp[y][x], dp[y - 1][x - 1]);
                    }
                    dp[y][x] = Math.min(dp[y][x], dp[y - 1][x] + 1);
                    dp[y][x] = Math.min(dp[y][x], dp[y][x - 1] + 1);
                    dp[y][x] = Math.min(dp[y][x], dp[y - 1][x - 1] + 2);
                }
            }
            return dp[word2.length() - 1][word1.length() - 1];
        }
    }

}
