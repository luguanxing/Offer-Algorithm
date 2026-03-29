package leetcode.problems;

public class Test2840_判断通过操作能否让字符串相等II {

    public static void main(String[] args) {
        // s1 = "abcdba", s2 = "cabdab"
        System.out.println(new Solution().checkStrings("abcdba", "cabdab"));
        // s1 = "abc", s2 = "bca"
        System.out.println(new Solution().checkStrings("abc", "bca"));
    }

    static class Solution {
        public boolean checkStrings(String s1, String s2) {
            int[] s1OddCnt = new int[26];
            int[] s2OddCnt = new int[26];
            int[] s1EvenCnt = new int[26];
            int[] s2EvenCnt = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                if (i % 2 == 0) {
                    s1EvenCnt[s1.charAt(i) - 'a']++;
                    s2EvenCnt[s2.charAt(i) - 'a']++;
                } else {
                    s1OddCnt[s1.charAt(i) - 'a']++;
                    s2OddCnt[s2.charAt(i) - 'a']++;
                }
            }
            for (int i = 0; i < 26; i++) {
                if (s1OddCnt[i] != s2OddCnt[i] || s1EvenCnt[i] != s2EvenCnt[i]) {
                    return false;
                }
            }
            return true;
        }
    }

}
