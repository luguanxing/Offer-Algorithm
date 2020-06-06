package leetcode.problems;

public class Test0091_解码方法 {

    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("12"));
        System.out.println(new Solution().numDecodings("226"));
        System.out.println(new Solution().numDecodings("272"));
        System.out.println(new Solution().numDecodings("0"));
        System.out.println(new Solution().numDecodings(""));
        System.out.println(new Solution().numDecodings("10"));
        System.out.println(new Solution().numDecodings("01"));
        System.out.println(new Solution().numDecodings("100"));
        System.out.println(new Solution().numDecodings("101"));
        System.out.println(new Solution().numDecodings("110"));
        System.out.println(new Solution().numDecodings("230"));
        System.out.println(new Solution().numDecodings("27"));
    }

    static class Solution {
        public int numDecodings(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }
            if (s.charAt(0) == '0') {
                return 0;
            }
            // dp[i]表示到s[0-i]的解码数
            int[] dp = new int[s.length()];
            dp[0] = s.charAt(0) == '0' ? 0 : 1;
            // 能拆成两个数则为dp[i-1]+dp[i-2]，否则还是dp[i-1]
            // dp[i] = dp[i-1] + (1 <= s[i-1]s[i] <= 26) ? dp[i-2] : 0;
            for (int i = 1; i < s.length(); i++) {
                String numStr = s.charAt(i - 1) + "" + s.charAt(i);
                int num = Integer.parseInt(numStr);
                if (s.charAt(i) == '0') {
                    if (1 <= num && num <= 26) {
                        dp[i] = i >= 2 ? dp[i - 2] : 1;
                    } else {
                        dp[i] = 0;
                    }
                } else if (1 <= num && num <= 26 && s.charAt(i - 1) != '0') {
                    dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
                } else {
                    dp[i] = dp[i - 1];
                }
            }
            return dp[s.length() - 1];
        }
    }

}
