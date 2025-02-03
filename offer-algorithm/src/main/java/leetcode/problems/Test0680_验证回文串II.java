package leetcode.problems;

public class Test0680_验证回文串II {

    public static void main(String[] args) {
        System.out.println(new Solution().validPalindrome("aba"));
        System.out.println(new Solution().validPalindrome("abca"));
        System.out.println(new Solution().validPalindrome("abc"));
        System.out.println(new Solution().validPalindrome("cxcaac"));
    }

    static class Solution {
        public boolean validPalindrome(String s) {
            char[] chars = s.toCharArray();
            return isHui(chars, 0, chars.length-1, true);
        }

        private boolean isHui(char[] chars, int l, int r, boolean hasChance) {
            if (l >= r) {
                return true;
            }
            // 如果相等，继续向中间靠拢
            if (chars[l] == chars[r]) {
                return isHui(chars, l+1, r-1, hasChance);
            }
            // 如果不相等，且没有机会，返回失败
            if (!hasChance) {
                return false;
            }
            // 删除左边或删除右边，且用掉一次机会
            return isHui(chars, l+1, r, false) || isHui(chars, l, r-1, false);
        }
    }

}
