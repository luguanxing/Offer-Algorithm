package leetcode.contest.week378;

public class Test100185_找出出现至少三次的最长特殊子字符串I {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumLength("aaaa"));
        System.out.println(new Solution().maximumLength("abcdef"));
        System.out.println(new Solution().maximumLength("abcaba"));
    }

    static class Solution {
        public int maximumLength(String s) {
            // 穷举
            for (int length = s.length(); length > 0; length--) {
                for (int start = 0; start <= s.length() - length; start++) {
                    if (isSpecial(s, start, start + length)) {
                        return length;
                    }
                }
            }
            return -1;
        }

        private boolean isSpecial(String s, int start, int end) {
            char c = s.charAt(start);
            int count = 0;
            for (int i = start; i < end; i++) {
                if (s.charAt(i) != c) {
                    return false;
                }
            }
            for (int i = 0; i <= s.length() - (end - start); i++) {
                if (s.startsWith(s.substring(start, end), i)) {
                    count++;
                    if (count >= 3) {
                        return true;
                    }
                }
            }
            return false;
        }
    }


}
