package leetcode.contest.week374;

import java.util.*;

public class Test100145_统计完全子字符串 {

    public static void main(String[] args) {
        // word = "igigee", k = 2
        System.out.println(new Solution().countCompleteSubstrings("igigee", 2));
        // word = "aaabbbccc", k = 3
        System.out.println(new Solution().countCompleteSubstrings("aaabbbccc", 3));
    }

    /*
        给你一个字符串 word 和一个整数 k 。
        如果 word 的一个子字符串 s 满足以下条件，我们称它是 完全字符串：
            1. s中每个字符恰好出现k次。
            2. 相邻字符在字母表中的顺序至多相差2 。也就是说，s 中两个相邻字符 c1 和 c2 ，它们在字母表中的位置相差 至多 为 2 。
        请你返回 word 中 完全 子字符串的数目。
        子字符串 指的是一个字符串中一段连续 非空 的字符序列。
     */
    static class Solution {
        private int[][] prefixSums;
        private TreeSet<Integer> invalidIndices;

        public int countCompleteSubstrings(String word, int k) {
            int count = 0;
            int len = word.length();
            // 初始化前缀和数组和无效索引树
            prefixSums = new int[26][len + 1];
            invalidIndices = new TreeSet<>();
            // 填充前缀和数组和无效索引树
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < 26; j++) {
                    prefixSums[j][i + 1] = prefixSums[j][i];
                }
                prefixSums[word.charAt(i) - 'a'][i + 1]++;
                if (i < len - 1 && Math.abs(word.charAt(i) - word.charAt(i + 1)) > 2) {
                    invalidIndices.add(i);
                }
            }
            // 检查每个可能的子字符串
            for (int windowSize = k; windowSize <= 26 * k; windowSize += k) {
                if (windowSize > len) {
                    break;
                }
                for (int start = 0; start <= len - windowSize; start++) {
                    if (isCompleteSubstring(start, start + windowSize, k)) {
                        count++;
                    }
                }
            }
            return count;
        }

        private boolean isCompleteSubstring(int start, int end, int k) {
            for (int i = 0; i < 26; i++) {
                if (prefixSums[i][end] == prefixSums[i][start]) {
                    continue;
                }
                if (prefixSums[i][end] - prefixSums[i][start] != k) {
                    return false;
                }
            }
            // 使用 TreeSet 快速检查范围内是否有无效索引
            Integer invalidIndex = invalidIndices.ceiling(start);
            return invalidIndex == null || invalidIndex >= end - 1;
        }
    }

}
