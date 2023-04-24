package leetcode.problems;

public class Test1163_按字典序排在最后的子串 {

    public static void main(String[] args) {
        System.out.println(new Solution().lastSubstring("abab"));
        System.out.println(new Solution().lastSubstring("leetcode"));
    }

    static class Solution {
        public String lastSubstring(String s) {
            int len = s.length();
            String res = null;
            for (int i = 0; i < len; i++) {
                String subStr = s.substring(i);
                if (res == null || subStr.compareTo(res) > 0) {
                    res = subStr;
                }
            }
            return res;
        }
    }

}
