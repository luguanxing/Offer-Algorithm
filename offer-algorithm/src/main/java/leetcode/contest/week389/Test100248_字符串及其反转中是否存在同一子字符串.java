package leetcode.contest.week389;

public class Test100248_字符串及其反转中是否存在同一子字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().isSubstringPresent("leetcode"));
        System.out.println(new Solution().isSubstringPresent("abcba"));
        System.out.println(new Solution().isSubstringPresent("abcd"));
        System.out.println(new Solution().isSubstringPresent("ausoee"));
    }

    static class Solution {
        public boolean isSubstringPresent(String s) {
            String sr = new StringBuilder(s).reverse().toString();
            for (int i = 2; i <= s.length(); i++) {
                String word = s.substring(i - 2, i);
                if (sr.contains(word)) {
                    return true;
                }
            }
            return false;
        }
    }

}
