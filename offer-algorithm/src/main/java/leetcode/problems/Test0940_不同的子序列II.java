package leetcode.problems;

import java.util.Arrays;

public class Test0940_不同的子序列II {

    public static void main(String[] args) {
        System.out.println(new Solution().distinctSubseqII("abc"));
        System.out.println(new Solution().distinctSubseqII("aba"));
        System.out.println(new Solution().distinctSubseqII("aaa"));
        System.out.println(new Solution().distinctSubseqII("zzc"));
        System.out.println(new Solution().distinctSubseqII("pcrdhwdxmqdznbenhwjsenjhvulyve"));
    }

    static class Solution {
        public int distinctSubseqII(String s) {
            int MOD = 1000000007;
            // lastIdx[i]表示字母i最后出现的序号
            int[] lastIdx = new int[26];
            Arrays.fill(lastIdx, -1);
            // dp[i]表示以第i个字符结尾的子序列个数
            // dp[i] = sum(dp[last[i]])
            int[] dp = new int[s.length()];
            Arrays.fill(dp, 1);
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                for (int j = 0; j < 26; j++) {
                    if (lastIdx[j] != -1) {
                        dp[i] += dp[lastIdx[j]];
                        dp[i] %= MOD;
                    }
                }
                lastIdx[c - 'a'] = i;
            }
            int sum = 0;
            for (int j = 0; j < 26; j++) {
                if (lastIdx[j] != -1) {
                    sum += dp[lastIdx[j]];
                    sum %= MOD;
                }
            }
            return sum;
        }
    }

}
