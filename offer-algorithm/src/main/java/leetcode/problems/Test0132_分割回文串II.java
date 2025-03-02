package leetcode.problems;

import java.util.Arrays;

public class Test0132_分割回文串II {

    public static void main(String[] args) {
        System.out.println(new Solution().minCut("aab"));
        System.out.println(new Solution().minCut("a"));
        System.out.println(new Solution().minCut("ab"));
    }

    static class Solution {
        public int minCut(String s) {
            char[] chars = s.toCharArray();
            int len = s.length();
            // dp[i] 表示 s[0:i] 的最小分割次数
            int[] dp = new int[len];
            // dp[i] = min(dp[j-1] + 1) if s[j:i] 是回文串
            for (int i = 0; i < len; i++) {
                dp[i] = i;
                for (int j = 0; j <= i; j++) {
                    if (isPalindrome(chars, j, i)) {
                        dp[i] = j == 0 ? 0 : Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
            return dp[len - 1];
        }

        private boolean isPalindrome(char[] chars, int left, int right) {
            while (left < right) {
                if (chars[left] != chars[right]) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }

    static class Solution_OLD {
        public int minCut(String s) {
            int len = s.length();
            boolean[][] isHui = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                Arrays.fill(isHui[i], true);
            }
            for (int y = len - 1; y >= 0; y--) {
                for (int x = y + 1; x < len; x++) {
                    isHui[y][x] = (s.charAt(y) == s.charAt(x)) && (isHui[y + 1][x - 1]);
                }
            }
            int[] res = new int[len];
            for (int i = 0; i < len; i++) {
                res[i] = Integer.MAX_VALUE;
                if (isHui[0][i]) {
                    res[i] = 0;
                } else {
                    for (int j = 0; j < i; j++) {
                        if (isHui[j + 1][i]) {
                            res[i] = Math.min(res[i], res[j] + 1);
                        }
                    }
                }
            }
            return res[len - 1];
        }
    }

}
