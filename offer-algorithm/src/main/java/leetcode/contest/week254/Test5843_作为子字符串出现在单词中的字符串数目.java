package leetcode.contest.week254;

public class Test5843_作为子字符串出现在单词中的字符串数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().numOfStrings(
                new String[]{"a","abc","bc","d"}, "abc"
        ));
        System.out.println(new Solution().numOfStrings(
                new String[]{"a","b","c"}, "aaaaabbbbb"
        ));
        System.out.println(new Solution().numOfStrings(
                new String[]{"a","a","a"}, "ab"
        ));
    }

    static class Solution {
        public int numOfStrings(String[] patterns, String word) {
            int res = 0;
            for (String pattern : patterns) {
                if (word.contains(pattern)) {
                    res++;
                }
            }
            return res;
        }
    }

}
