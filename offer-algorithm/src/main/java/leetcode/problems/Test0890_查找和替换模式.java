package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test0890_查找和替换模式 {

    public static void main(String[] args) {
        System.out.println(new Solution().findAndReplacePattern(
                new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"},
                "abb"
        ));
    }

    static class Solution {
        public List<String> findAndReplacePattern(String[] words, String pattern) {
            List<String> result = new ArrayList<>();
            for (String word : words) {
                if (isMatch(word, pattern)) {
                    result.add(word);
                }
            }
            return result;
        }

        private boolean isMatch(String word, String pattern) {
            int len = pattern.length();
            Map<Character, Character> wordMap = new HashMap<>();
            Map<Character, Character> patternMap = new HashMap<>();
            for (int i = 0; i < len; i++) {
                wordMap.put(word.charAt(i), pattern.charAt(i));
                patternMap.put(pattern.charAt(i), word.charAt(i));
            }
            String newWord = "";
            String newPattern = "";
            for (int i = 0; i < len; i++) {
                char oldWordChar = word.charAt(i);
                char newWordChar = wordMap.get(oldWordChar);
                newWord += newWordChar;
                char oldPatternChar = pattern.charAt(i);
                char newPatternChar = patternMap.get(oldPatternChar);
                newPattern += newPatternChar;
            }
            return newWord.equals(pattern) && newPattern.equals(word);
        }
    }

}
