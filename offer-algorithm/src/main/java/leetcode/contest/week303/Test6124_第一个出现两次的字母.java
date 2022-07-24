package leetcode.contest.week303;

public class Test6124_第一个出现两次的字母 {

    public static void main(String[] args) {
        System.out.println(new Solution().repeatedCharacter("abccbaacz"));
        System.out.println(new Solution().repeatedCharacter("abcdd"));
    }

    static class Solution {
        public char repeatedCharacter(String s) {
            int[] map = new int[26];
            for (char c : s.toCharArray()) {
                map[c - 'a']++;
                if (map[c - 'a'] == 2) {
                    return c;
                }
            }
            return 0;
        }
    }

}
