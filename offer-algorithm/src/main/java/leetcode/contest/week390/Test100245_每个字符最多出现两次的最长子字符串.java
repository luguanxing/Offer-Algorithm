package leetcode.contest.week390;

public class Test100245_每个字符最多出现两次的最长子字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumLengthSubstring("bcbbbcba"));
        System.out.println(new Solution().maximumLengthSubstring("aaaa"));
    }

    static class Solution {
        public int maximumLengthSubstring(String s) {
            int len = s.length();
            int max = 0;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j <= len; j++) {
                    if (checkStr(s.substring(i, j))) {
                        max = Math.max(max, j - i);
                    }
                }
            }
            return max;
        }

        private boolean checkStr(String substring) {
            int[] count = new int[26];
            for (char c : substring.toCharArray()) {
                count[c - 'a']++;
                if (count[c - 'a'] > 2) {
                    return false;
                }
            }
            return true;
        }
    }

}
