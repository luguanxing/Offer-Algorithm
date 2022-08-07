package leetcode.contest.week305;

import java.util.Arrays;

public class Test6138_最长理想子序列 {

    public static void main(String[] args) {
        System.out.println(new Solution().longestIdealString("acfgbd", 2));
        System.out.println(new Solution().longestIdealString("abcd", 3));
    }

    static class Solution {
        public int longestIdealString(String s, int k) {
            int len = s.length();
            // dp[i]表示以'a'+i结尾相邻不超过k的最长长度
            // dp[i] = max(dp[i-j])+1
            int[] dp = new int[26];
            for (char c : s.toCharArray()) {
                int cIndex = c - 'a';
                int max = 1;
                for (int j = cIndex - k; j <= cIndex + k; j++) {
                    if (j < 0 || j >= 26) {
                        continue;
                    }
                    max = Math.max(max, dp[j] + 1);
                }
                dp[cIndex] = max;
            }
            return Arrays.stream(dp).max().getAsInt();
        }
    }

}
