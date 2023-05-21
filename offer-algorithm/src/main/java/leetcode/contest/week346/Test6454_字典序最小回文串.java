package leetcode.contest.week346;

public class Test6454_字典序最小回文串 {

    public static void main(String[] args) {
        System.out.println(new Solution().makeSmallestPalindrome("egcfe"));
        System.out.println(new Solution().makeSmallestPalindrome("abcd"));
        System.out.println(new Solution().makeSmallestPalindrome("seven"));
    }

    static class Solution {
        public String makeSmallestPalindrome(String s) {
            char[] chars = s.toCharArray();
            int len = chars.length;
            for (int i = 0; i < len / 2; i++) {
                char c1 = chars[i];
                char c2 = chars[len - 1 - i];
                if (c1 == c2) {
                    continue;
                }
                if (c1 < c2) {
                    chars[len - 1 - i] = c1;
                } else {
                    chars[i] = c2;
                }
            }
            return new String(chars);
        }
    }

}
