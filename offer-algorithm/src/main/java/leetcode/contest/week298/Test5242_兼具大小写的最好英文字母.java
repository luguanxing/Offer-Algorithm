package leetcode.contest.week298;

public class Test5242_兼具大小写的最好英文字母 {

    public static void main(String[] args) {
        System.out.println(new Solution().greatestLetter("lEeTcOdE"));
        System.out.println(new Solution().greatestLetter("arRAzFif"));
        System.out.println(new Solution().greatestLetter("AbCdEfGhIjK"));
    }

    static class Solution {
        public String greatestLetter(String s) {
            boolean[] isLow = new boolean[26];
            boolean[] isHigh = new boolean[26];
            for (char c : s.toCharArray()) {
                if (Character.isLowerCase(c)) {
                    isLow[c - 'a'] = true;
                } else {
                    isHigh[c - 'A'] = true;
                }
            }
            String res = "";
            for (char c = 'A'; c <= 'Z'; c++) {
                if (isLow[c - 'A'] && isHigh[c - 'A']) {
                    res = c + "";
                }
            }
            return res;
        }
    }

}
