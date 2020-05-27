package leetcode.problems;

import java.util.Arrays;
import java.util.List;

public class Test0139_单词拆分 {

    public static void main(String[] args) {
        System.out.println(new Solution().wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(new Solution().wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(new Solution().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }

    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            // canMatch[i]表示s[i]之前都可以被匹配到
            boolean[] canMatch = new boolean[s.length() + 1];
            canMatch[0] = true;
            // 动态规划
            for (int right = 1; right <= s.length(); right++) {
                for (int left = 0; left < right; left++) {
                    // s[0-left]和s[left-right]都能匹配
                    String subStr = s.substring(left, right);
                    if (canMatch[left] && wordDict.contains(subStr)) {
                        canMatch[right] = true;
                    }
                }
            }
            return canMatch[s.length()];
        }
    }

    static class Solution_暴力 {
        boolean result = false;

        public boolean wordBreak(String s, List<String> wordDict) {
            result = false;
            // 递归所有前缀匹配
            dfs(s, wordDict);
            return result;
        }

        private void dfs(String s, List<String> wordDict) {
            if (s.isEmpty() || result) {
                result = true;
                return;
            }
            for (String word : wordDict) {
                if (s.startsWith(word)) {
                    dfs(s.substring(word.length()), wordDict);
                }
            }
        }
    }

}
