package leetcode.problems;

import java.util.Arrays;

public class Test2559_统计范围内的元音字符串数 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().vowelStrings(
                new String[]{"aba", "bcb", "ece", "aa", "e"},
                new int[][]{{0, 2}, {1, 4}, {1, 1}}
        )));
        System.out.println(Arrays.toString(new Solution().vowelStrings(
                new String[]{"a", "e", "i"},
                new int[][]{{0, 2}, {0, 1}, {2, 2}}
        )));
    }

    static class Solution {
        public int[] vowelStrings(String[] words, int[][] queries) {
            int len = words.length;
            int[] sum = new int[len + 1];
            for (int i = 0; i < len; i++) {
                sum[i + 1] = sum[i];
                if (isVowelString(words[i])) {
                    sum[i + 1]++;
                }
            }
            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int l = queries[i][0];
                int r = queries[i][1];
                res[i] = sum[r + 1] - sum[l];
            }
            return res;
        }

        private boolean isVowelString(String word) {
            char c1 = word.charAt(0);
            char c2 = word.charAt(word.length() - 1);
            return (c1 == 'a' || c1 == 'e' || c1 == 'i' || c1 == 'o' || c1 == 'u') &&
                    (c2 == 'a' || c2 == 'e' || c2 == 'i' || c2 == 'o' || c2 == 'u');
        }
    }

}
