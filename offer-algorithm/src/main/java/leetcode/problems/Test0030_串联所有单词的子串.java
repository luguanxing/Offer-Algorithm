package leetcode.problems;

import java.util.*;

public class Test0030_串联所有单词的子串 {

    public static void main(String[] args) {
        System.out.println(new Solution().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(new Solution().findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
        System.out.println(new Solution().findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
        System.out.println(new Solution().findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
    }

    static class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            // 初始化
            Map<String, Integer> wordMap = new TreeMap<>();
            for (String word : words) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
            int wordLen = words[0].length();
            int wordCount = words.length;
            // 循环匹配比较
            List<Integer> list = new ArrayList<>();
            Map<String, Integer> currentWordMap = new TreeMap<>();
            for (int i = 0; i + wordCount * wordLen <= s.length(); i++) {
                String subStr = s.substring(i, i + wordCount * wordLen);
                boolean isOk = true;
                currentWordMap.clear();
                while (!subStr.isEmpty()) {
                    String word = subStr.substring(0, wordLen);
                    if (!wordMap.containsKey(word)) {
                        isOk = false;
                        break;
                    } else {
                        currentWordMap.put(word, currentWordMap.getOrDefault(word, 0) + 1);
                    }
                    subStr = subStr.substring(wordLen);
                }
                if (isOk && currentWordMap.toString().equals(wordMap.toString())) {
                    list.add(i);
                }
            }
            return list;
        }
    }

}
