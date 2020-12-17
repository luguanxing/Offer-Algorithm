package leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test0290_单词规律 {

    public static void main(String[] args) {
        System.out.println(new Solution().wordPattern("abba", "dog cat cat dog"));
        System.out.println(new Solution().wordPattern("abba", "dog cat cat fish"));
        System.out.println(new Solution().wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(new Solution().wordPattern("abba", "dog dog dog dog"));
    }

    static class Solution {
        public boolean wordPattern(String pattern, String s) {
            char[] chars = pattern.toCharArray();
            String[] strs = s.split(" ");
            if (strs.length != chars.length) {
                return false;
            }
            // 对应匹配检查
            Map<Character, String> map = new HashMap<>();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                String str = strs[i];
                if (!map.containsKey(c)) {
                    map.put(c, str);
                } else {
                    String existedStr = map.get(c);
                    if (!str.equals(existedStr)) {
                        return false;
                    }
                }
            }
            // 重复检查
            Set<String> set = new HashSet<>();
            for (String str : map.values()) {
                if (!set.contains(str)) {
                    set.add(str);
                } else {
                    return false;
                }
            }
            return true;
        }
    }

}
