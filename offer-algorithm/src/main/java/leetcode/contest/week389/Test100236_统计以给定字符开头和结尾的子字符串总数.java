package leetcode.contest.week389;

public class Test100236_统计以给定字符开头和结尾的子字符串总数 {

    public static void main(String[] args) {
        // s = "abada", c = "a"
        System.out.println(new Solution().countSubstrings("abada", 'a'));
        // s = "zzz", c = "z"
        System.out.println(new Solution().countSubstrings("zzz", 'z'));
    }

    static class Solution {
        public long countSubstrings(String s, char c) {
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    cnt++;
                }
            }
            return (long) cnt * (cnt + 1) / 2;
        }
    }

}
