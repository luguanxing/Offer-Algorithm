package leetcode.problems;

public class Test2981_找出出现至少三次的最长特殊子字符串I {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumLength("aaaa"));
        System.out.println(new Solution().maximumLength("abcdef"));
        System.out.println(new Solution().maximumLength("abcaba"));
    }

    static class Solution {
        public int maximumLength(String s) {
            int max = -1;
            for (char c = 'a'; c <= 'z'; c++) {
                if (s.indexOf(c) == -1) {
                    continue;
                }
                for (int len = 1; len <= s.length(); len++) {
                    String str = "";
                    for (int i = 0; i < len; i++) {
                        str += c;
                    }
                    int index1 = s.indexOf(str);
                    int index2 = s.indexOf(str, index1 + 1);
                    int index3 = s.indexOf(str, index2 + 1);
                    if (index1 != -1 && index2 != -1 && index3 != -1) {
                        max = Math.max(max, len);
                    }
                }
            }
            return max;
        }
    }

}
