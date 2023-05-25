package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test2451_差值数组不同的字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().oddString(new String[]{"adc", "wzy", "abc"}));
        System.out.println(new Solution().oddString(new String[]{"aaa", "bob", "ccc", "ddd"}));
    }

    static class Solution {
        public String oddString(String[] words) {
            Map<String, Integer> patternCnt = new HashMap<>();
            for (String word : words) {
                String pattern = getPattern(word);
                patternCnt.put(pattern, patternCnt.getOrDefault(pattern, 0) + 1);
            }
            for (String word : words) {
                String pattern = getPattern(word);
                if (patternCnt.get(pattern) == 1) {
                    return word;
                }
            }
            return null;
        }

        private String getPattern(String word) {
            int len = word.length();
            int[] diff = new int[len - 1];
            for (int i = 0; i < len - 1; i++) {
                diff[i] = word.charAt(i + 1) - word.charAt(i);
            }
            return Arrays.toString(diff);
        }
    }

}
