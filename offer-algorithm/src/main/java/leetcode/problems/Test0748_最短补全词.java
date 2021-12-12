package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

public class Test0748_最短补全词 {

    public static void main(String[] args) {
        System.out.println(new Solution().shortestCompletingWord(
                "1s3 PSt",
                new String[]{"step", "steps", "stripe", "stepple"}
        ));
        System.out.println(new Solution().shortestCompletingWord(
                "1s3 456",
                new String[]{"looks", "pest", "stew", "show"}
        ));
    }

    static class Solution {
        public String shortestCompletingWord(String licensePlate, String[] words) {
            int[] map = new int[26];
            for (char c : licensePlate.toCharArray()) {
                if (Character.isAlphabetic(c)) {
                    map[Character.toLowerCase(c) - 'a']++;
                }
            }
            Arrays.sort(words, Comparator.comparingInt(String::length));
            for (String word : words) {
                int[] currentMap = new int[26];
                for (char c : word.toCharArray()) {
                    currentMap[c - 'a']++;
                }
                boolean isOk = true;
                for (int i = 0; i < 26; i++) {
                    if (currentMap[i] < map[i]) {
                        isOk = false;
                    }
                }
                if (isOk) {
                    return word;
                }
            }
            return "";
        }
    }

}
