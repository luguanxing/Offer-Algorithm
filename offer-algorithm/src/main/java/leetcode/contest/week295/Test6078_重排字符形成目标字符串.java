package leetcode.contest.week295;

public class Test6078_重排字符形成目标字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().rearrangeCharacters("ilovecodingonleetcode", "code"));
        System.out.println(new Solution().rearrangeCharacters("abcba", "abc"));
        System.out.println(new Solution().rearrangeCharacters("abbaccaddaeea", "aaaaa"));
    }

    static class Solution {
        public int rearrangeCharacters(String s, String target) {
            int[] sourceMap = new int[26];
            int[] targetMap = new int[26];
            for (char c : s.toCharArray()) {
                sourceMap[c - 'a']++;
            }
            for (char c : target.toCharArray()) {
                targetMap[c - 'a']++;
            }
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < 26; i++) {
                if (targetMap[i] != 0) {
                    res = Integer.min(res, sourceMap[i] / targetMap[i]);
                }
            }
            return res;
        }
    }

}
