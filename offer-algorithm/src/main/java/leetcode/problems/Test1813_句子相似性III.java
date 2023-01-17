package leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1813_句子相似性III {

    public static void main(String[] args) {
        System.out.println(new Solution().areSentencesSimilar("My name is Haley", "My Haley"));
        System.out.println(new Solution().areSentencesSimilar("of", "A lot of words"));
        System.out.println(new Solution().areSentencesSimilar("Eating right now", "Eating"));
        System.out.println(new Solution().areSentencesSimilar("Luky", "Lucccky"));
        System.out.println(new Solution().areSentencesSimilar(
                "TjZ ScAi m xz PNWaKigqqY p IyJ B rok",
                "TjZ ScAi m LlbJhCf gL u m R pZpiH mSk a og xz PNWaKigqqY p IyJ B rok"
        ));
        System.out.println(new Solution().areSentencesSimilar("A", "a A b A"));
        System.out.println(new Solution().areSentencesSimilar("B", "ByI BMyQIqce b bARkkMaABi vlR RLHhqjNzCN oXvyK zRXR q ff B yHS OD KkvJA P JdWksnH"));
        System.out.println(new Solution().areSentencesSimilar("Db C", "C Db"));
        System.out.println(new Solution().areSentencesSimilar("AaA AA", "a AaA AA A"));
    }

    static class Solution {
        public boolean areSentencesSimilar(String sentence1, String sentence2) {
            if (sentence1.length() > sentence2.length()) {
                String tmp = sentence1;
                sentence1 = sentence2;
                sentence2 = tmp;
            }

            List<String> words1 = Stream.of(sentence1.split(" ")).collect(Collectors.toList());
            List<String> words2 = Stream.of(sentence2.split(" ")).collect(Collectors.toList());
            if (words1.size() == 1 && (words2.get(0).equals(sentence1) || words2.get(words2.size() - 1).equals(sentence1))) {
                return true;
            }
            if (sentence2.indexOf(sentence1) > 0 && sentence2.indexOf(sentence1) != sentence2.length() - sentence1.length()) {
                return false;
            }
            for (String word : words1) {
                if (!sentence2.contains(word)) {
                    return false;
                }
            }
            List<String> diffWords = new ArrayList<>();
            while (words1.size() > 0 && words2.size() > 0) {
                String word1 = words1.get(0);
                String word2 = words2.get(0);
                if (word1.equals(word2)) {
                    words1.remove(0);
                    words2.remove(0);
                } else {
                    diffWords.add(word2);
                    words2.remove(0);
                }
            }
            if (!words2.isEmpty()) {
                diffWords.addAll(words2);
            }
            if (!words1.isEmpty()) {
                return false;
            }
            String diffSentence = String.join(" ", diffWords);
            return sentence2.contains(diffSentence);
        }
    }

}
