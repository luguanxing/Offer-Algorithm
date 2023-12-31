package leetcode.contest.week378;

import java.util.*;

public class Test100184_找出出现至少三次的最长特殊子字符串II {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumLength("aaaa"));
        System.out.println(new Solution().maximumLength("abcdef"));
        System.out.println(new Solution().maximumLength("abcaba"));
        System.out.println(new Solution().maximumLength("ereerrrererrrererre"));
        System.out.println(new Solution().maximumLength("bbc"));
    }

    static class Solution {
        public int maximumLength(String s) {
            Map<Character, List<Integer>> map = new HashMap<>();
            char[] chars = s.toCharArray();
            int count = 1;

            // 遍历字符串
            map.computeIfAbsent(chars[0], k -> new ArrayList<>()).add(count);
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == chars[i - 1]) {
                    count++;
                } else {
                    count = 1; // 重置计数
                }
                map.computeIfAbsent(chars[i], k -> new ArrayList<>()).add(count);
            }

            // 查找出现至少三次的最长特殊子字符串
            int maxLength = -1;
            for (List<Integer> counts : map.values()) {
                if (counts.size() >= 3) {
                    Collections.sort(counts);
                    maxLength = Math.max(maxLength, counts.get(counts.size() - 3));
                }
            }

            return maxLength;
        }
    }





}
