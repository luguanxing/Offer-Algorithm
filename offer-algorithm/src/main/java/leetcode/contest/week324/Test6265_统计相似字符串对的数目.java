package leetcode.contest.week324;

import java.util.Arrays;

public class Test6265_统计相似字符串对的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().similarPairs(new String[]{"aba", "aabb", "abcd", "bac", "aabc"}));
        System.out.println(new Solution().similarPairs(new String[]{"aabb", "ab", "ba"}));
        System.out.println(new Solution().similarPairs(new String[]{"nba", "cba", "dba"}));
    }

    static class Solution {
        public int similarPairs(String[] words) {
            int res = 0;
            for (int i = 0; i < words.length; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if (isSimiliar(words[i], words[j])) {
                        res++;
                    }
                }
            }
            return res;
        }

        private boolean isSimiliar(String w1, String w2) {
            int[] cmp1 = new int[26];
            int[] cmp2 = new int[26];
            for (char c : w1.toCharArray()) {
                cmp1[c - 'a'] = 1;
            }
            for (char c : w2.toCharArray()) {
                cmp2[c - 'a'] = 1;
            }
            return Arrays.toString(cmp1).equals(Arrays.toString(cmp2));
        }
    }

}
