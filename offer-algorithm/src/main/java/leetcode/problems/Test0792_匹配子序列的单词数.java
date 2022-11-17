package leetcode.problems;

import java.util.TreeSet;

public class Test0792_匹配子序列的单词数 {

    public static void main(String[] args) {
        System.out.println(new Solution().numMatchingSubseq(
                "abcde",
                new String[]{"a", "bb", "acd", "ace"}
        ));
        System.out.println(new Solution().numMatchingSubseq(
                "dsahjpjauf",
                new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"}
        ));
    }

    static class Solution {
        public int numMatchingSubseq(String s, String[] words) {
            // 存储字符的邻接表用于快速查找
            TreeSet<Integer>[] charMap = new TreeSet[26];
            for (char c = 'a'; c <= 'z'; c++) {
                charMap[c - 'a'] = new TreeSet<>();
            }
            for (int i = 0; i < s.length(); i++) {
                charMap[s.charAt(i) - 'a'].add(i);
            }
            int res = 0;
            for (String word : words) {
                if (isSubSeq(word, charMap)) {
                    res++;
                }
            }
            return res;
        }

        private boolean isSubSeq(String word, TreeSet<Integer>[] charMap) {
            int idx = -1;
            for (char c : word.toCharArray()) {
                Integer nextIdx = charMap[c - 'a'].higher(idx);
                if (nextIdx == null) {
                    return false;
                }
                idx = nextIdx;
            }
            return true;
        }
    }

    static class Solution_暴力 {
        public int numMatchingSubseq(String s, String[] words) {
            int res = 0;
            for (String word : words) {
                if (isSubSeq(s, word)) {
                    res++;
                }
            }
            return res;
        }

        private boolean isSubSeq(String s, String word) {
            int idx = 0;
            for (char c : word.toCharArray()) {
                while (idx < s.length() && s.charAt(idx) != c) {
                    idx++;
                }
                if (idx < s.length() && s.charAt(idx) == c) {
                    idx++;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

}
