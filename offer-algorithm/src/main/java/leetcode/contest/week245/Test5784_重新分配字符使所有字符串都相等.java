package leetcode.contest.week245;

import java.util.HashMap;
import java.util.Map;

public class Test5784_重新分配字符使所有字符串都相等 {

    public static void main(String[] args) {
        System.out.println(new Solution().makeEqual(new String[]{"abc", "aabc", "bc"}));
        System.out.println(new Solution().makeEqual(new String[]{"ab", "a"}));
        System.out.println(new Solution().makeEqual(new String[]{"b", "a"}));
        System.out.println(new Solution().makeEqual(new String[]{"b"}));
        System.out.println(new Solution().makeEqual(new String[]{"asdf"}));
        System.out.println(new Solution().makeEqual(new String[]{"abbab"}));
        System.out.println(new Solution().makeEqual(new String[]{"caaaaa","aaaaaaaaa","a","bbb","bbbbbbbbb","bbb","cc","cccccccccccc","ccccccc","ccccccc","cc","cccc","c","cccccccc","c"}));
    }

    static class Solution {
        public boolean makeEqual(String[] words) {
            if (words.length == 1) {
                return true;
            }
            Map<Character, Integer> map = new HashMap<>();
            for (String word : words) {
                for (char c : word.toCharArray()) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
            }
            for (int cnt : map.values()) {
                if (cnt % words.length != 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
