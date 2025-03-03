package leetcode.problems;

import java.util.Arrays;

public class Test1278_分割回文串III {

    public static void main(String[] args) {
        System.out.println(new Solution().palindromePartition("abc", 2));
        System.out.println(new Solution().palindromePartition("aabbc", 3));
        System.out.println(new Solution().palindromePartition("leetcode", 8));
    }

    static class Solution {
        public int palindromePartition(String s, int k) {
            char[] chars = s.toCharArray();
            int len = s.length();
            // dp[i][j] 表示 s[0:i] 分割成 j 个回文串的最小代价
            int[][] dp = new int[len + 1][k + 1];
            for (int[] row : dp) {
                Arrays.fill(row, len);
            }
            dp[0][0] = 0;
            // dp[i][cut] = min(dp[x][cut-1] + cost(x+1, i)) 其中 x < i且 s[x+1:i] 是修改后的回文串
            for (int i = 1; i <= len; i++) {
                for (int j = 1; j <= Math.min(k, i); j++) {
                    if (j == 1) {
                        dp[i][j] = palindromeCost(chars, 0, i - 1);
                    } else {
                        for (int x = 0; x < i; x++) {
                            dp[i][j] = Math.min(dp[i][j], dp[x][j - 1] + palindromeCost(chars, x, i - 1));
                        }
                    }
                }
            }
            return dp[len][k];
        }

        private int palindromeCost(char[] chars, int left, int right) {
            int cost = 0;
            while (left < right) {
                if (chars[left] != chars[right]) {
                    cost++;
                }
                left++;
                right--;
            }
            return cost;
        }
    }

}
