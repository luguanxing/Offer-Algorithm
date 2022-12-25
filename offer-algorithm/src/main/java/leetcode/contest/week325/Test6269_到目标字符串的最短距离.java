package leetcode.contest.week325;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test6269_到目标字符串的最短距离 {

    public static void main(String[] args) {
        System.out.println(new Solution().closetTarget(
                new String[]{"hello", "a", "i", "am", "leetcode", "hello"},
                "hello",
                2
        ));
        System.out.println(new Solution().closetTarget(
                new String[]{"a", "b", "leetcode"},
                "leetcode",
                0
        ));
        System.out.println(new Solution().closetTarget(
                new String[]{"i", "eat", "leetcode"},
                "ate",
                0
        ));
    }

    static class Solution {
        public int closetTarget(String[] words, String target, int startIndex) {
            if (!Arrays.stream(words).collect(Collectors.toSet()).contains(target)) {
                return -1;
            }
            int min = Integer.MAX_VALUE;
            List<String> wordList = Arrays.stream(words).collect(Collectors.toList());
            List<String> wordWordList = new ArrayList<>();
            // 找右边
            wordWordList.addAll(wordList);
            wordWordList.addAll(wordList);
            for (int i = startIndex; i < wordWordList.size(); i++) {
                if (wordWordList.get(i).equals(target)) {
                    min = i - startIndex;
                    break;
                }
            }
            // 找左边
            for (int i = startIndex + wordList.size(); i >= 0; i--) {
                if (wordWordList.get(i).equals(target)) {
                    min = Math.min(min, startIndex + wordList.size() - i);
                    break;
                }
            }
            return min;
        }
    }

}
