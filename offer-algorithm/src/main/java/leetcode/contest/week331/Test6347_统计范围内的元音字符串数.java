package leetcode.contest.week331;

import java.util.Arrays;

public class Test6347_统计范围内的元音字符串数 {

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
            int[] prefixSum = new int[len + 1];
            for (int i = 1; i <= len; i++) {
                prefixSum[i] = prefixSum[i - 1] + (isVowString(words[i - 1]) ? 1 : 0);
            }
            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int l = queries[i][0];
                int r = queries[i][1];
                res[i] = prefixSum[r + 1] - prefixSum[l];
            }
            return res;
        }

        private boolean isVowString(String word) {
            char c1 = word.charAt(0);
            char cn = word.charAt(word.length() - 1);
            if (c1 != 'a' && c1 != 'e' && c1 != 'i' && c1 != 'o' && c1 != 'u') {
                return false;
            }
            if (cn != 'a' && cn != 'e' && cn != 'i' && cn != 'o' && cn != 'u') {
                return false;
            }
            return true;
        }
    }

}
