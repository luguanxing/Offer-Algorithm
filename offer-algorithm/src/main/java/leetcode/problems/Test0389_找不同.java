package leetcode.problems;

import java.util.Arrays;

public class Test0389_找不同 {

    public static void main(String[] args) {
        System.out.println(new Solution().findTheDifference("abcd", "abcde"));
        System.out.println(new Solution().findTheDifference("", "y"));
        System.out.println(new Solution().findTheDifference("a", "aa"));
        System.out.println(new Solution().findTheDifference("ae", "aea"));
    }

    static class Solution {
        public char findTheDifference(String s, String t) {
            int[] chars1 = new int[26];
            int[] chars2 = new int[26];
            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();
            Arrays.sort(sChars);
            Arrays.sort(tChars);
            for (char c : sChars) {
                chars1[c - 'a']++;
            }
            for (char c : tChars) {
                chars2[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (chars1[i] < chars2[i]) {
                    return (char) ('a' + i);
                }
            }
            return 0;
        }
    }

}
