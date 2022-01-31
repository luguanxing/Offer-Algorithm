package leetcode.problems;

public class Test1763_最长的美好子字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().longestNiceSubstring("YazaAay"));
        System.out.println(new Solution().longestNiceSubstring("Bb"));
        System.out.println(new Solution().longestNiceSubstring("c"));
        System.out.println(new Solution().longestNiceSubstring("dDzeE"));
    }

    static class Solution {
        public String longestNiceSubstring(String s) {
            int len = s.length();
            String res = "";
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j <= len; j++) {
                    String subStr = s.substring(i, j);
                    if (isOk(subStr)) {
                        if (subStr.length() > res.length()) {
                            res = subStr;
                        }
                    }
                }
            }
            return res;
        }

        private boolean isOk(String str) {
            for (char c : str.toCharArray()) {
                if (Character.isLowerCase(c) && !str.contains("" + Character.toUpperCase(c))) {
                    return false;
                } else if (Character.isUpperCase(c) && !str.contains("" + Character.toLowerCase(c))) {
                    return false;
                }
            }
            return true;
        }
    }

}
