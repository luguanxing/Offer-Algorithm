package leetcode.interview;

import java.util.TreeSet;

public class Test17_11_单词距离 {

    public static void main(String[] args) {
        System.out.println(new Solution().findClosest(new String[]{"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"}, "a", "student"));
    }

    static class Solution {
        public int findClosest(String[] words, String word1, String word2) {
            TreeSet<Integer> word1Indexs = new TreeSet<>();
            TreeSet<Integer> word2Indexs = new TreeSet<>();
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (word.equals(word1)) {
                    word1Indexs.add(i);
                }
                if (word.equals(word2)) {
                    word2Indexs.add(i);
                }
            }
            int min = Integer.MAX_VALUE;
            for (int word1Index : word1Indexs) {
                Integer lowerIndex = word2Indexs.lower(word1Index);
                Integer higherIndex = word2Indexs.higher(word1Index);
                if (lowerIndex != null) {
                    min = Math.min(min, word1Index - lowerIndex);
                }
                if (higherIndex != null) {
                    min = Math.min(min, higherIndex - word1Index);
                }
            }
            return min;
        }
    }

}
