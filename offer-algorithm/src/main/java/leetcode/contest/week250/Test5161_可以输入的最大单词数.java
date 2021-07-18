package leetcode.contest.week250;

public class Test5161_可以输入的最大单词数 {

    public static void main(String[] args) {
        System.out.println(new Solution().canBeTypedWords("hello world", "ad"));
        System.out.println(new Solution().canBeTypedWords("leet code", "lt"));
        System.out.println(new Solution().canBeTypedWords("leet code", "e"));
    }

    static class Solution {
        public int canBeTypedWords(String text, String brokenLetters) {
            boolean[] broken = new boolean[26];
            for (char c : brokenLetters.toCharArray()) {
                broken[c - 'a'] = true;
            }
            int res = 0;
            for (String word : text.split(" ")) {
                boolean isOk = true;
                for (char c : word.toCharArray()) {
                    if (broken[c - 'a']) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    res++;
                }
            }
            return res;
        }
    }

}
