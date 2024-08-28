package leetcode.problems;

import java.util.*;

public class Test3144_分割字符频率相等的最少子字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumSubstringsInPartition("fabccddg"));
        System.out.println(new Solution().minimumSubstringsInPartition("abababaccddb"));
    }

    static class Solution {
        public int minimumSubstringsInPartition(String s) {
            int len = s.length();
            // 提前计算isBalanced[i][j]
            boolean[][] isBalanced = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                Map<Character, Integer> map = new HashMap<>();
                for (int j = i; j < len; j++) {
                    map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                    int cnt = map.get(s.charAt(j));
                    boolean balanced = true;
                    for (int value : map.values()) {
                        if (value != cnt) {
                            balanced = false;
                            break;
                        }
                    }
                    isBalanced[i][j] = balanced;
                }
            }
            // 令dp[i]表示s[0:i]中最少的子串数量
            // dp[i] = min(dp[j] + 1) 且 s[j:i]是一个平衡子串
            int[] dp = new int[len];
            dp[0] = 1;
            for (int i = 1; i < len; i++) {
                dp[i] = dp[i - 1] + 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (isBalanced[j][i]) {
                        dp[i] = Math.min(dp[i], j == 0 ? 1 : dp[j - 1] + 1);
                    }
                }
            }
            return dp[len - 1];
        }
    }

}
