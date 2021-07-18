package leetcode.interview;

import java.util.*;

public class Test10_02_变位词组 {

    public static void main(String[] args) {
        System.out.println(new Solution().groupAnagrams(
                new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}
        ));
    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String word : strs) {
                Map<Character, Integer> keysMap = new TreeMap<>();
                for (char c : word.toCharArray()) {
                    keysMap.put(c, keysMap.getOrDefault(c, 0) + 1);
                }
                String key = keysMap.toString();
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(word);
                map.put(key, list);
            }
            return new ArrayList<>(map.values());
        }
    }

}
