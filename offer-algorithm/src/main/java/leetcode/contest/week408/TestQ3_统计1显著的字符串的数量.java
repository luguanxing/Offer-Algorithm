package leetcode.contest.week408;

public class TestQ3_统计1显著的字符串的数量 {

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfSubstrings("00011"));
        System.out.println(new Solution().numberOfSubstrings("101101"));
    }

    static class Solution {
        public int numberOfSubstrings(String s) {
            int len = s.length();
            int res = 0;
            for (int l = 0; l < len; l++) {
                int cnt0 = 0;
                int cnt1 = 0;
                for (int r = l; r < len; r++) {
                    if (s.charAt(r) == '0') {
                        cnt0++;
                    } else {
                        cnt1++;
                    }
                    if (cnt0 * cnt0 <= cnt1) {
                        res++;
                    }
                }
            }
            return res;
        }
    }


}
