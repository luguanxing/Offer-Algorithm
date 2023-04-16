package leetcode.contest.week341;

public class Test6375_构造有效字符串的最少插入数 {

    public static void main(String[] args) {
        System.out.println(new Solution().addMinimum("b"));
        System.out.println(new Solution().addMinimum("aaa"));
        System.out.println(new Solution().addMinimum("abc"));
        System.out.println(new Solution().addMinimum("aaaabb"));
        System.out.println(new Solution().addMinimum("aaaaac"));
    }

    static class Solution {
        public int addMinimum(String word) {
            String fullWord = word;
            fullWord = fullWord.replaceAll("abc", "X");
            fullWord = fullWord.replaceAll("ab", "V");
            fullWord = fullWord.replaceAll("bc", "V");
            fullWord = fullWord.replaceAll("ac", "V");
            fullWord = fullWord.replaceAll("a", "T");
            fullWord = fullWord.replaceAll("b", "T");
            fullWord = fullWord.replaceAll("c", "T");
            int res = 0;
            for (char c : fullWord.toCharArray()) {
                if (c == 'X') {
                    res += 0;
                } else if (c == 'V') {
                    res += 1;
                } else if (c == 'T') {
                    res += 2;
                }
            }
            return res;
        }
    }

}
