package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2273_移除字母异位词后的结果数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().removeAnagrams(new String[]{"abba", "baba", "bbaa", "cd", "cd"}));
        System.out.println(new Solution().removeAnagrams(new String[]{"a", "b", "c", "d", "e"}));
    }

    static class Solution {
        public List<String> removeAnagrams(String[] words) {
            String[] aWords = words.clone();
            int len = words.length;
            for (int i = 0; i < len; i++) {
                String word = aWords[i];
                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                aWords[i] = String.valueOf(chars);
            }
            List<String> res = new ArrayList<>();
            res.add(words[0]);
            for (int i = 1; i < len; i++) {
                if (!aWords[i].equals(aWords[i - 1])) {
                    res.add(words[i]);
                }
            }
            return res;
        }
    }
}
