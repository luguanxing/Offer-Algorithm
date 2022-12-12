package leetcode.problems;

import java.util.Arrays;

public class Test1781_所有子字符串美丽值之和 {

    public static void main(String[] args) {
        System.out.println(new Solution().beautySum("aabcb"));
        System.out.println(new Solution().beautySum("aabcbaa"));
    }

    static class Solution {
        public int beautySum(String s) {
            char[] chars = s.toCharArray();
            int len = chars.length;
            int sum = 0;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j <= len; j++) {
                    String subStr = s.substring(i, j);
                    sum += get(subStr);
                }
            }
            return sum;
        }

        private int get(String subStr) {
            int[] map = new int[26];
            for (char c : subStr.toCharArray()) {
                map[c - 'a']++;
            }
            return Arrays.stream(map).filter(num -> num > 0).max().getAsInt() - Arrays.stream(map).filter(num -> num > 0).min().getAsInt();
        }
    }

}
