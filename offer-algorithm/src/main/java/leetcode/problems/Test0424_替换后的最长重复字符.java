package leetcode.problems;

public class Test0424_替换后的最长重复字符 {

    public static void main(String[] args) {
        System.out.println(new Solution().characterReplacement("ABAB", 2));
        System.out.println(new Solution().characterReplacement("AABABBA", 1));
    }

    static class Solution {
        public int characterReplacement(String s, int k) {
            if (s.length() < 2) {
                return s.length();
            }
            int len = s.length();
            int[] count = new int[26];
            int currentMaxCount = 0;
            int left = 0;
            int right = 0;
            int res = 0;
            while (right < len) {
                count[s.charAt(right) - 'A']++;
                currentMaxCount = Math.max(currentMaxCount, count[s.charAt(right++) - 'A']);
                if (right - left > currentMaxCount + k) {
                    count[s.charAt(left++) - 'A']--;
                }
                res = Math.max(res, right - left);
            }
            return res;
        }
    }

}
