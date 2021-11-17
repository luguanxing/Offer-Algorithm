package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0318_最大单词长度乘积 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
        System.out.println(new Solution().maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
        System.out.println(new Solution().maxProduct(new String[]{"a", "aa", "aaa", "aaaa"}));
    }

    static class Solution {
        public int maxProduct(String[] words) {
            List<WordStat> list = new ArrayList<>();
            for (String word : words) {
                list.add(new WordStat(word));
            }
            int res = 0;
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    res = Math.max(res, list.get(i).compare(list.get(j)));
                }
            }
            return res;
        }

        class WordStat {
            // 每个单词只保留出现字符和长度
            boolean[] map = new boolean[26];
            int len;

            public WordStat(String word) {
                this.len = word.length();
                for (char c : word.toCharArray()) {
                    map[c - 'a'] = true;
                }
            }

            public int compare(WordStat wordStat) {
                for (int i = 0; i < 26; i++) {
                    if (this.map[i] && wordStat.map[i]) {
                        return 0;
                    }
                }
                return this.len * wordStat.len;
            }
        }
    }

}
