package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0824_山羊拉丁文 {

    public static void main(String[] args) {
        System.out.println(new Solution().toGoatLatin("I speak Goat Latin"));
        System.out.println(new Solution().toGoatLatin("The quick brown fox jumped over the lazy dog"));
        System.out.println(new Solution().toGoatLatin("Each word consists of lowercase and uppercase letters only"));
    }

    static class Solution {
        public String toGoatLatin(String sentence) {
            String[] words = sentence.split(" ");
            List<String> newWords = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                String newWord = "";
                if (word.toLowerCase().startsWith("a") || word.toLowerCase().startsWith("e") || word.toLowerCase().startsWith("i") || word.toLowerCase().startsWith("o") || word.toLowerCase().startsWith("u")) {
                    newWord += word;
                } else {
                    newWord += word.substring(1) + word.charAt(0);
                }
                newWord += "ma";
                for (int j = 0; j < i + 1; j++) {
                    newWord += "a";
                }
                newWords.add(newWord);
            }
            return String.join(" ", newWords);
        }
    }

}
