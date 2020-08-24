package leetcode.problems;

public class Test0459_重复的子字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().repeatedSubstringPattern("abab"));
        System.out.println(new Solution().repeatedSubstringPattern("aba"));
        System.out.println(new Solution().repeatedSubstringPattern("abcabcabcabc"));
    }

    static class Solution {
        public boolean repeatedSubstringPattern(String s) {
            if (s == null || s.isEmpty()) {
                return false;
            }
            int len = s.length();
            for (int i = 1; i < len; i++) {
                if (len % i != 0) {
                    continue;
                }
                String pattern = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 1; j <= len / i; j++) {
                    sb.append(pattern);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
            return false;
        }
    }

}
