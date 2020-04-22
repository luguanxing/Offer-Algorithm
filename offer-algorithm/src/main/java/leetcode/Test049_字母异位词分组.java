package leetcode;

import java.util.*;

public class Test049_字母异位词分组 {

    public static void main(String[] args) {
        System.out.println(new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(new Solution().groupAnagrams(new String[]{"bur", "rub"}));
    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> keyMap = new HashMap<>();
            for (String str : strs) {
                String key = getKey(str);
                if (!keyMap.containsKey(key)) {
                    keyMap.put(key, new ArrayList<>());
                }
                keyMap.get(key).add(str);
            }
            return new ArrayList<>(keyMap.values());
        }

        public String getKey(String str) {
            // 需要使用TreeMap保证存入后取出时自动排序
            Map<Character, Integer> map = new TreeMap<>();
            for (char c : str.toCharArray()) {
                if (!map.containsKey(c)) {
                    map.put(c, 1);
                } else {
                    map.put(c, map.get(c) + 1);
                }
            }
            return map.toString();
        }
    }

}
