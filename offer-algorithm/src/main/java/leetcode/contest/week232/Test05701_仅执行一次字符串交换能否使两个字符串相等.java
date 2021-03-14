package leetcode.contest.week232;

import java.util.Arrays;

public class Test05701_仅执行一次字符串交换能否使两个字符串相等 {

    public static void main(String[] args) {
        System.out.println(new Solution().areAlmostEqual("bank", "kanb"));
        System.out.println(new Solution().areAlmostEqual("attack", "defend"));
        System.out.println(new Solution().areAlmostEqual("kelb", "kelb"));
        System.out.println(new Solution().areAlmostEqual("abcd", "dcba"));
        System.out.println(new Solution().areAlmostEqual("abcd", "abck"));
        System.out.println(new Solution().areAlmostEqual("abkc", "abck"));
    }

    static class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            int first = -1;
            int last = -1;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    if (first == -1) {
                        first = i;
                    } else if (last == -1) {
                        last = i;
                    } else {
                        return false;
                    }
                }
            }
            if (first == -1) {
                return true;
            }
            if (last == -1) {
                return false;
            }
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            char tmp = chars1[first];
            chars1[first] = chars1[last];
            chars1[last] = tmp;
            return Arrays.equals(chars1, chars2);
        }
    }

}
