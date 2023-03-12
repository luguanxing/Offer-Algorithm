package leetcode.contest.week336;

public class Test6315_统计范围内的元音字符串数 {

    public static void main(String[] args) {
        System.out.println(new Solution().vowelStrings(
                new String[]{"are", "amy", "u"}, 0, 2
        ));
        System.out.println(new Solution().vowelStrings(
                new String[]{"hey", "aeo", "mu", "ooo", "artro"}, 1, 4
        ));
    }

    static class Solution {
        public int vowelStrings(String[] words, int left, int right) {
            int res = 0;
            for (int i = left; i <= right; i++) {
                String word = words[i];
                if (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                    res++;
                }
            }
            return res;
        }

        private boolean isVowel(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }
    }

}
