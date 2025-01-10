package leetcode.problems;

import java.util.Arrays;

public class Test3298_统计重新排列后包含另一个字符串的子字符串数目II {

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
                while (ok(diff)) {
                    res += len - r;
                    diff[word1.charAt(l) - 'a']++;
                    l++;
                }
                r++;
            }
            return res;
        }

        private boolean ok(int[] diff) {
            for (int d : diff) {
                if (d > 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
