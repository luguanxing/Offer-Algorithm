package leetcode.problems;

import java.util.*;

public class Test3297_统计重新排列后包含另一个字符串的子字符串数目I {

    public static void main(String[] args) {
        System.out.println(new Solution().validSubstringCount("bcca", "abc"));
        System.out.println(new Solution().validSubstringCount("abcabc", "abc"));
        System.out.println(new Solution().validSubstringCount("abcabc", "aaabc"));
    }

    static class Solution {
        public long validSubstringCount(String word1, String word2) {
            int len = word1.length();
            long res = 0;
            // 滑动窗口统计所有符合条件的右侧
            int[] diff = new int[26];
            for (char c : word2.toCharArray()) {
                diff[c - 'a']++;
            }
            int l = 0;
            int r = 0;
            while (l <= r && r < len) {
                diff[word1.charAt(r) - 'a']--;
                while (!Arrays.stream(diff).anyMatch(i -> i > 0)) {
                    res += len - r;
                    diff[word1.charAt(l) - 'a']++;
                    l++;
                }
                r++;
            }
            return res;
        }
    }

    static class Solution_TLE {
        public long validSubstringCount(String word1, String word2) {
            int len = word1.length();
            long res = 0;
            // 滑动窗口统计所有符合条件的len-r
            int l = 0;
            int r = 1;
            while (l <= r && r <= len) {
                while (canMake(word1.substring(l, r), word2)) {
                    res += len - r + 1;
                    l++;
                }
                r++;
            }
            return res;
        }

        private boolean canMake(String str1, String str2) {
            int[] map1 = new int[26];
            int[] map2 = new int[26];
            for (char c : str1.toCharArray()) {
                map1[c - 'a']++;
            }
            for (char c : str2.toCharArray()) {
                map2[c - 'a']++;
                if (map1[c - 'a'] < map2[c - 'a']) {
                    return false;
                }
            }
            return true;
        }
    }

}
