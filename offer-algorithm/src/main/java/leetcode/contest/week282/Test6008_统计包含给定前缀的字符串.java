package leetcode.contest.week282;

public class Test6008_统计包含给定前缀的字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().prefixCount(new String[]{"pay", "attention", "practice", "attend"}, "at"));
        System.out.println(new Solution().prefixCount(new String[]{"leetcode", "win", "loops", "success"}, "code"));
    }

    static class Solution {
        public int prefixCount(String[] words, String pref) {
            int res = 0;
            for (String word : words) {
                if (word.startsWith(pref)) {
                    res++;
                }
            }
            return res;
        }
    }

}
