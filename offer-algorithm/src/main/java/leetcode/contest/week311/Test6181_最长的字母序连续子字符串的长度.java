package leetcode.contest.week311;

public class Test6181_最长的字母序连续子字符串的长度 {

    public static void main(String[] args) {
        System.out.println(new Solution().longestContinuousSubstring("abacaba"));
        System.out.println(new Solution().longestContinuousSubstring("abcde"));
        System.out.println(new Solution().longestContinuousSubstring("yrpjofyzubfsiypfre"));
        System.out.println(new Solution().longestContinuousSubstring("z"));
    }

    static class Solution {
        public int longestContinuousSubstring(String s) {
            int len = 1;
            int max = 1;
            for (int idx = 1; idx < s.length(); idx++) {
                if (s.charAt(idx) == s.charAt(idx - 1) + 1) {
                    len++;
                } else {
                    len = 1;
                }
                max = Math.max(max, len);
            }
            return max;
        }
    }

}
