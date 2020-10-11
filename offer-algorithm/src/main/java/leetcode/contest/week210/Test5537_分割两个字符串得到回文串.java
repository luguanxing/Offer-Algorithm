package leetcode.contest.week210;

public class Test5537_分割两个字符串得到回文串 {

    public static void main(String[] args) {
        System.out.println(new Solution().checkPalindromeFormation("x", "y"));
        System.out.println(new Solution().checkPalindromeFormation("ulacfd", "jizalu"));
        System.out.println(new Solution().checkPalindromeFormation("xbdef", "xecab"));
        System.out.println(new Solution().checkPalindromeFormation("pvhmupgqeltozftlmfjjde", "yjgpzbezspnnpszebzmhvp"));
    }

    static class Solution {
        public boolean checkPalindromeFormation(String a, String b) {
            if (isHui(a) || isHui(b)) {
                return true;
            }
            // 翻转后找最远匹配
            String bReverse = new StringBuilder(b).reverse().toString();
            int aMatch = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == bReverse.charAt(i)) {
                    aMatch++;
                } else {
                    break;
                }
            }
            String aReverse = new StringBuilder(a).reverse().toString();
            int bMatch = 0;
            for (int i = 0; i < b.length(); i++) {
                if (b.charAt(i) == aReverse.charAt(i)) {
                    bMatch++;
                } else {
                    break;
                }
            }
            if (aMatch == 0 && bMatch == 0) {
                return false;
            }
            return isHui(a.substring(0, aMatch) + b.substring(b.length() - aMatch)) ||
                    isHui(b.substring(0, bMatch) + a.substring(a.length() - bMatch));
        }

        private boolean isHui(String s) {
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }

}
