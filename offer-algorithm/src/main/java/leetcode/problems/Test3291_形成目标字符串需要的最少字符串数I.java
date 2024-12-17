package leetcode.problems;

import java.util.*;

public class Test3291_形成目标字符串需要的最少字符串数I {

    public static void main(String[] args) {
        // words = ["abc","aaaaa","bcdef"], target = "aabcdabc"
        System.out.println(new Solution().minValidStrings(
                new String[]{"abc", "aaaaa", "bcdef"}, "aabcdabc"
        ));
        // words = ["abababab","ab"], target = "ababaababa"
        System.out.println(new Solution().minValidStrings(
                new String[]{"abababab", "ab"}, "ababaababa"
        ));
        // words = ["abcdef"], target = "xyz"
        System.out.println(new Solution().minValidStrings(
                new String[]{"abcdef"}, "xyz"
        ));
    }

    static class Solution {
        public int minValidStrings(String[] words, String target) {
            int len = target.length();
            // 构造前缀串
            Set<String> set = new HashSet<>();
            for (String word : words) {
                for (int i = 0; i <= word.length(); i++) {
                    set.add(word.substring(0, i));
                }
            }
            // dp[i]表示匹配到target[i]需要的最少个数
            // dp[i] = min(dp[j]+1)且word前缀中包含target[j-i]
            int[] dp = new int[len + 1];
            Arrays.fill(dp, 1, len + 1, Integer.MAX_VALUE / 2);
            for (int i = 1; i <= len; i++) {
                for (int j = 0; j < i; j++) {
                    if (set.contains(target.substring(j, i))) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
            return dp[len] == Integer.MAX_VALUE / 2 ? -1 : dp[len];
        }
    }

}
