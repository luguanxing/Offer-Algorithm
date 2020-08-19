package leetcode.problems;

public class Test0647_回文子串 {

    public static void main(String[] args) {
        System.out.println(new Solution().countSubstrings("abc"));
        System.out.println(new Solution().countSubstrings("aaa"));
        System.out.println(new Solution().countSubstrings("aabaca"));
    }

    static class Solution {
        public int countSubstrings(String s) {
            // dp[i][j]表示s.substr(i,j)是否回文
            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = true;
            }
            // 动态规划，使用上一步的状态，注意因为依赖左下，所以要先上到下从循环从左到右计算
            int res = 0;
            for (int j = 0; j < s.length(); j++) {
                for (int i = 0; i < s.length(); i++) {
                    if (i == j) {
                        // 同一个字符
                        dp[i][j] = true;
                        res++;
                    } else if (i + 1 == j && s.charAt(i) == s.charAt(j)) {
                        // 两个相邻的字符
                        dp[i][j] = true;
                        res++;
                    } else if (j - i > 1 && dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                        // 相邻两个以上的字符
                        dp[i][j] = true;
                        res++;
                    }
                }
            }
            return res;
        }
    }

}
