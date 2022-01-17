package leetcode.problems;

import java.util.Arrays;

public class Test1220_统计元音字母序列的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().countVowelPermutation(1));
        System.out.println(new Solution().countVowelPermutation(2));
        System.out.println(new Solution().countVowelPermutation(5));
        System.out.println(new Solution().countVowelPermutation(144));
        System.out.println(new Solution().countVowelPermutation(158));
    }

    static class Solution {
        public int countVowelPermutation(int n) {
            int MOD = (int) (Math.pow(10, 9) + 7);
            // dp[i][c]表示第i个字符元音c结尾时的数量
            long[][] dp = new long[n][5];
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < 5; k++) {
                    dp[i][k] = 1;
                }
            }
            // dp[i][c] = sum(dp[i-1][能到达c的字符])
            for (int i = 1; i < n; i++) {
                dp[i][idx('a')] = (dp[i - 1][idx('i')] + dp[i - 1][idx('e')] + dp[i - 1][idx('u')]) % MOD;
                dp[i][idx('e')] = (dp[i - 1][idx('a')] + dp[i - 1][idx('i')]) % MOD;
                dp[i][idx('i')] = (dp[i - 1][idx('e')] + dp[i - 1][idx('o')]) % MOD;
                dp[i][idx('o')] = (dp[i - 1][idx('i')]) % MOD;
                dp[i][idx('u')] = (dp[i - 1][idx('o')] + dp[i - 1][idx('i')]) % MOD;
            }
            long res = 0;
            for (int k = 0; k < 5; k++) {
                res += dp[n - 1][k];
            }
            return (int) (res % MOD);
        }

        private int idx(char c) {
            switch (c) {
                case 'a':
                    return 0;
                case 'e':
                    return 1;
                case 'i':
                    return 2;
                case 'o':
                    return 3;
                case 'u':
                    return 4;
            }
            return 0;
        }
    }

}
