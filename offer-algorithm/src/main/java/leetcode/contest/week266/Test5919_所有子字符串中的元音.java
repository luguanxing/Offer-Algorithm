package leetcode.contest.week266;

import java.util.Arrays;

public class Test5919_所有子字符串中的元音 {

    public static void main(String[] args) {
        System.out.println(new Solution().countVowels("aba"));
        System.out.println(new Solution().countVowels("abc"));
        System.out.println(new Solution().countVowels("ltcd"));
        System.out.println(new Solution().countVowels("noosabasboosa"));
    }

    static class Solution {
        public long countVowels(String word) {
            int len = word.length();
            long res = 0;
            for (long i = 0; i < len; i++) {
                char c = word.charAt((int) i);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    // 往前有i+1个可能，往后有len-i个可能
                    res += (i + 1) * (len - i);
                }
            }
            return res;
        }
    }

    static class Solution_超时 {
        public long countVowels(String word) {
            long res = 0;
            int len = word.length();
            int[] dp = new int[len];
            for (int i = 0; i < len; i++) {
                char ci = word.charAt(i);
                if (ci == 'a' || ci == 'e' || ci == 'i' || ci == 'o' || ci == 'u') {
                    dp[i] = 1;
                    res += dp[i];
                }
                for (int j = i + 1; j < len; j++) {
                    char cj = word.charAt(j);
                    if (cj == 'a' || cj == 'e' || cj == 'i' || cj == 'o' || cj == 'u') {
                        dp[j] = dp[j - 1] + 1;
                    } else {
                        dp[j] = dp[j - 1];
                    }
                    res += dp[j];
                }
                if (i < len - 1) {
                    dp[i + 1] = 0;
                }
            }
            return res;
        }
    }

    static class Solution_超内存限制 {
        public long countVowels(String word) {
            int len = word.length();
            int[][] dp = new int[len][len];
            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    dp[i][i] = 1;
                }
            }
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    char c = word.charAt(j);
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                        dp[i][j] = dp[i][j - 1] + 1;
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
            long res = 0;
            for (int[] row : dp) {
                res += Arrays.stream(row).sum();
            }
            return res;
        }
    }

}
