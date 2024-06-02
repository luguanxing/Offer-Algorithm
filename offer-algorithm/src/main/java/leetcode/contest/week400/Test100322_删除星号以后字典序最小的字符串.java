package leetcode.contest.week400;

import java.util.TreeMap;

public class Test100322_删除星号以后字典序最小的字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().clearStars("aaba*"));
        System.out.println(new Solution().clearStars("abc"));
    }

    static class Solution {
        public String clearStars(String s) {
            // 构建Map和子序列
            TreeMap<Character, Integer> map = new TreeMap<>();
            StringBuilder result = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c != '*') {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                    result.append(c);
                } else {
                    if (!map.isEmpty()) {
                        char minChar = map.firstKey();
                        if (map.get(minChar) == 1) {
                            map.remove(minChar);
                        } else {
                            map.put(minChar, map.get(minChar) - 1);
                        }
                        int index = result.lastIndexOf(String.valueOf(minChar));
                        result.deleteCharAt(index);
                    }
                }
            }
            return result.toString();
        }
    }
}
