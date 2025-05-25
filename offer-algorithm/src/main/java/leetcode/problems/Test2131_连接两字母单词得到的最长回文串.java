package leetcode.problems;

import java.util.*;

public class Test2131_连接两字母单词得到的最长回文串 {

    public static void main(String[] args) {
        // words = ["lc","cl","gg"]
        System.out.println(new Solution().longestPalindrome(new String[]{"lc", "cl", "gg"}));
        // words = ["ab","ty","yt","lc","cl","ab"]
        System.out.println(new Solution().longestPalindrome(new String[]{"ab", "ty", "yt", "lc", "cl", "ab"}));
        // words = ["cc","ll","xx"]
        System.out.println(new Solution().longestPalindrome(new String[]{"cc", "ll", "xx"}));
        System.out.println(new Solution().longestPalindrome(new String[]{"dd", "aa", "bb", "dd", "aa", "dd", "bb", "dd", "aa", "cc", "bb", "cc", "dd", "cc"}));
        System.out.println(new Solution().longestPalindrome(new String[]{"qo", "fo", "fq", "qf", "fo", "ff", "qq", "qf", "of", "of", "oo", "of", "of", "qf", "qf", "of"}));
    }

    static class Solution {
        public int longestPalindrome(String[] words) {
            // 对称组合aa bb等数目统计
            int[] syn2Cnt = new int[26];
            // 非对称组合ak fi等数目统计
            Map<String, Integer> patternMap = new HashMap<>();
            int asym4Cnt = 0;
            for (String word : words) {
                char c1 = word.charAt(0);
                char c2 = word.charAt(1);
                String key = c1 + "" + c2;
                String asymKey = c2 + "" + c1;
                if (c1 == c2) {
                    syn2Cnt[c1 - 'a']++;
                } else if (patternMap.containsKey(asymKey)) {
                    asym4Cnt++;
                    patternMap.put(asymKey, patternMap.get(asymKey) - 1);
                    if (patternMap.get(asymKey) == 0) {
                        patternMap.remove(asymKey);
                    }
                } else {
                    patternMap.put(key, patternMap.getOrDefault(key, 0) + 1);
                }
            }
            int res = 0;
            // 对称组合取偶数对+1（如有奇数）
            res += Arrays.stream(syn2Cnt).map(num -> num - (num % 2)).sum() * 2;
            res += Arrays.stream(syn2Cnt).anyMatch(num -> num % 2 == 1) ? 2 : 0;
            // 不对称组合任意加
            res += asym4Cnt * 4;
            return res;
        }
    }

}
