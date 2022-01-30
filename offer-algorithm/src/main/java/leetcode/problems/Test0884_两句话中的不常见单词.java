package leetcode.problems;

import java.util.*;

public class Test0884_两句话中的不常见单词 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().uncommonFromSentences("this apple is sweet", "this apple is sour")));
        System.out.println(Arrays.toString(new Solution().uncommonFromSentences("apple apple", "banana")));
    }

    static class Solution {
        public String[] uncommonFromSentences(String s1, String s2) {
            Map<String, Integer> map1 = new HashMap<>();
            Map<String, Integer> map2 = new HashMap<>();
            for (String word : s1.split(" ")) {
                map1.put(word, map1.getOrDefault(word, 0) + 1);
            }
            for (String word : s2.split(" ")) {
                map2.put(word, map2.getOrDefault(word, 0) + 1);
            }
            Set<String> set = new HashSet<>();
            for (String word : map1.keySet()) {
                if (map1.get(word) == 1 && !map2.containsKey(word)) {
                    set.add(word);
                }
            }
            for (String word : map2.keySet()) {
                if (map2.get(word) == 1 && !map1.containsKey(word)) {
                    set.add(word);
                }
            }
            String[] res = new String[set.size()];
            int index = 0;
            for (String word : set) {
                res[index++] = word;
            }
            return res;
        }
    }

}
