package leetcode.problems;

import java.util.*;
import java.util.function.Function;

public class Test2901_最长相邻不相等子序列II {

    public static void main(String[] args) {
        System.out.println(new Solution().getWordsInLongestSubsequence(
                new String[]{"bab", "dab", "cab"},
                new int[]{1, 2, 2}
        ));
        System.out.println(new Solution().getWordsInLongestSubsequence(
                new String[]{"a", "b", "c", "d"},
                new int[]{1, 2, 3, 4}
        ));
        System.out.println(new Solution().getWordsInLongestSubsequence(
                new String[]{"adbe", "acace"},
                new int[]{2, 2}
        ));
        System.out.println(new Solution().getWordsInLongestSubsequence(
                new String[]{"ac", "caa", "cda", "ba"},
                new int[]{3, 1, 2, 3}
        ));
        System.out.println(new Solution().getWordsInLongestSubsequence(
                new String[]{"cb", "dc", "ab", "aa", "ac", "bb", "ca", "bcc", "cdd", "aad", "bba", "bc", "ddb"},
                new int[]{12, 6, 10, 11, 4, 8, 9, 11, 2, 11, 3, 2, 5}
        ));
    }

    static class Solution {
        public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
            int len = words.length;
            Map<Integer, List<String>> dpMap = new HashMap<>();
            dpMap.put(0, Arrays.asList(words[0]));
            int[] dp = new int[len];
            dp[0] = 1;
            int maxLen = 1;
            for (int i = 1; i < len; i++) {
                dp[i] = 1;
                dpMap.put(i, Arrays.asList(words[i]));
                for (int j = 0; j < i; j++) {
                    if (groups[j] != groups[i] && isHanmingOk(words[j], words[i]) && dp[j] >= dp[i]) {
                        dp[i] = dp[j] + 1;
                        List<String> newList = new ArrayList<>(dpMap.get(j));
                        newList.add(words[i]);
                        dpMap.put(i, newList);
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
            for (List<String> list : dpMap.values()) {
                if (list.size() == maxLen) {
                    return list;
                }
            }
            return dpMap.get(len - 1);
        }

        private boolean isHanmingOk(String w1, String w2) {
            if (w1.length() != w2.length()) {
                return false;
            }
            int diffCnt = 0;
            for (int i = 0; i < w1.length(); i++) {
                if (w1.charAt(i) != w2.charAt(i)) {
                    diffCnt++;
                }
            }
            return diffCnt <= 1;
        }
    }

}
