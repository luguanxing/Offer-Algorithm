package leetcode.problems;

import java.util.Arrays;

public class Test1170_比较字符串最小字母出现频次 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().numSmallerByFrequency(
                new String[]{"cbd"},
                new String[]{"zaaaz"}
        )));
        System.out.println(Arrays.toString(new Solution().numSmallerByFrequency(
                new String[]{"bbb", "cc"},
                new String[]{"a", "aa", "aaa", "aaaa"}
        )));
        System.out.println(Arrays.toString(new Solution().numSmallerByFrequency(
                new String[]{"bba", "abaaaaaa", "aaaaaa", "bbabbabaab", "aba", "aa", "baab", "bbbbbb", "aab", "bbabbaabb"},
                new String[]{"aaabbb", "aab", "babbab", "babbbb", "b", "bbbbbbbbab", "a", "bbbbbbbbbb", "baaabbaab", "aa"}
        )));
    }

    static class Solution {
        public int[] numSmallerByFrequency(String[] queries, String[] words) {
            int len = queries.length;
            int[] res = new int[len];
            for (int i = 0; i < len; i++) {
                String query = queries[i];
                int r = 0;
                for (String word : words) {
                    if (f(query) < f(word)) {
                        r++;
                    }
                }
                res[i] = r;
            }
            return res;
        }

        private int f(String str) {
            char ch = 255;
            int cnt = 0;
            for (char c : str.toCharArray()) {
                if (c < ch) {
                    ch = c;
                    cnt = 0;
                }
                if (c == ch) {
                    cnt++;
                }
            }
            return cnt;
        }
    }

}
