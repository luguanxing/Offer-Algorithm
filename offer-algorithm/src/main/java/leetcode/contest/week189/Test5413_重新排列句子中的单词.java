package leetcode.contest.week189;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test5413_重新排列句子中的单词 {

    public static void main(String[] args) {
        System.out.println(new Solution().arrangeWords("Leetcode is cool"));
        System.out.println(new Solution().arrangeWords("Keep calm and code on"));
        System.out.println(new Solution().arrangeWords("To be or not to be"));
    }

    static class Solution {
        public String arrangeWords(String text) {
            // 按字符串长度保存对应list
            Map<Integer, List<String>> map = new TreeMap<>();
            String[] texts = text.split(" ");
            for (String word : texts) {
                int wordLen = word.length();
                if (!map.containsKey(wordLen)) {
                    map.put(wordLen, new ArrayList<>());
                }
                map.get(wordLen).add(word.toLowerCase());
            }
            // 重新组成对应字符串
            String newText = map
                    .values()
                    .stream()
                    .map(list -> list.stream().collect(Collectors.joining(" ")))
                    .collect(Collectors.joining(" "));
            return newText.substring(0, 1).toUpperCase() + newText.substring(1);
        }
    }

}
