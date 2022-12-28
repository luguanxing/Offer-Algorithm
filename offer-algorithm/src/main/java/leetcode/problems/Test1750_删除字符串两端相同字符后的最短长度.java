package leetcode.problems;

public class Test1750_删除字符串两端相同字符后的最短长度 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumLength("ca"));
        System.out.println(new Solution().minimumLength("cabaabac"));
        System.out.println(new Solution().minimumLength("aabccabba"));
    }

    static class Solution {
        public int minimumLength(String s) {
            while (s.length() > 1 && s.charAt(0) == s.charAt(s.length() - 1)) {
                s = trim(s);
            }
            return s.length();
        }

        private String trim(String s) {
            char c = s.charAt(0);
            int l = 0;
            int r = 0;
            for (int i = 0; i < s.length(); i++) {
                if (c == s.charAt(i)) {
                    l++;
                } else {
                    break;
                }
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                if (c == s.charAt(i)) {
                    r++;
                } else {
                    break;
                }
            }
            if (l + r > s.length()) {
                return "";
            }
            return s.substring(l, s.length() - r);
        }
    }

}
