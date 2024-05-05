package leetcode.contest.week396;

public class Test100284_有效单词 {

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("234Adas"));
        System.out.println(new Solution().isValid("b3"));
        System.out.println(new Solution().isValid("a3$e"));
        System.out.println(new Solution().isValid("b33"));
        System.out.println(new Solution().isValid("b33A"));
        System.out.println(new Solution().isValid("b33a"));
    }

    static class Solution {
        public boolean isValid(String word) {
            if (word.length() < 3) {
                return false;
            }
            for (char c : word.toCharArray()) {
                if (!('a' <= c && c <= 'z') && !('A' <= c && c <= 'Z') && !('0' <= c && c <= '9')) {
                    return false;
                }
            }
            if (!word.matches(".*[aeiouAEIOU].*")) {
                return false;
            }
            if (!word.matches(".*[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ].*")) {
                return false;
            }
            return true;
        }
    }

}
