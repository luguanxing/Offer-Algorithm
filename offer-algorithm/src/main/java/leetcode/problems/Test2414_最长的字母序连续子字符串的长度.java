package leetcode.problems;

public class Test2414_最长的字母序连续子字符串的长度 {

    public static void main(String[] args) {
        System.out.println(new Solution().longestContinuousSubstring("abacaba"));
        System.out.println(new Solution().longestContinuousSubstring("abcde"));
    }

    static class Solution {
        public int longestContinuousSubstring(String s) {
            int max = 1;
            int currentCnt = 1;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1) + 1) {
                    currentCnt++;
                } else {
                    currentCnt = 1;
                }
                max = Math.max(max, currentCnt);
            }
            return max;
        }
    }

}
