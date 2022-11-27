package leetcode.contest.week321;

public class Test6246_追加字符以获得子序列 {

    public static void main(String[] args) {
        System.out.println(new Solution().appendCharacters("coaching", "coding"));
        System.out.println(new Solution().appendCharacters("abcde", "a"));
        System.out.println(new Solution().appendCharacters("z", "abcde"));
    }

    static class Solution {
        public int appendCharacters(String s, String t) {
            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();
            int i = 0, j = 0;
            while (i < s.length()) {
                if (j == t.length()) {
                    return 0;
                }
                if (sChars[i] == tChars[j]) {
                    i++;
                    j++;
                    continue;
                } else {
                    i++;
                }
            }
            return t.length() - j;
        }
    }

}
