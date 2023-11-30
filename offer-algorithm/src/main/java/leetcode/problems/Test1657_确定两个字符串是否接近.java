package leetcode.problems;

import java.util.Arrays;

public class Test1657_确定两个字符串是否接近 {

    public static void main(String[] args) {
        // word1 = "abc", word2 = "bca"
        System.out.println(new Solution().closeStrings("abc", "bca"));
        // word1 = "a", word2 = "aa"
        System.out.println(new Solution().closeStrings("a", "aa"));
        // word1 = "cabbba", word2 = "abbccc"
        System.out.println(new Solution().closeStrings("cabbba", "abbccc"));
        // word1 = "cabbba", word2 = "aabbss"
        System.out.println(new Solution().closeStrings("cabbba", "aabbss"));
        // word1 ="abbbzcf", word2 = "babzzcz"
        System.out.println(new Solution().closeStrings("abbbzcf", "babzzcz"));
        // "abbzzca", "babzzcz"
        System.out.println(new Solution().closeStrings("abbzzca", "babzzcz"));
    }

    static class Solution {
        public boolean closeStrings(String word1, String word2) {
            // 1. 两个字符串的字符长度必须相同
            if (word1.length() != word2.length()) {
                return false;
            }
            // 2. 两个字符串的字符种类必须相同
            int[] map1 = new int[26];
            int[] map2 = new int[26];
            for (char c : word1.toCharArray()) {
                map1[c - 'a']++;
            }
            for (char c : word2.toCharArray()) {
                map2[c - 'a']++;
            }
            for (char c : word1.toCharArray()) {
                if (map2[c - 'a'] == 0) {
                    return false;
                }
            }
            for (char c : word2.toCharArray()) {
                if (map1[c - 'a'] == 0) {
                    return false;
                }
            }
            // 3. 两个字符串的字符频次结构必须相同
            Arrays.sort(map1);
            Arrays.sort(map2);
            return Arrays.toString(map1).equals(Arrays.toString(map2));
        }
    }

}
