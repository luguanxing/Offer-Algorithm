package leetcode.problems;

public class Test2938_区分黑球与白球 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumSteps("101"));
        System.out.println(new Solution().minimumSteps("100"));
        System.out.println(new Solution().minimumSteps("0111"));
        System.out.println(new Solution().minimumSteps("1110"));
        System.out.println(new Solution().minimumSteps("111010"));
    }

    static class Solution {
        public long minimumSteps(String s) {
            int len = s.length();
            long total = 0;
            int cnt1 = 0;
            for (int i = 0; i < len; i++) {
                // 遇到黑球不用动
                if (s.charAt(i) == '1') {
                    cnt1++;
                    continue;
                }
                // 遇到白球往前移动
                total += cnt1;
            }
            return total;
        }
    }

    static class Solution_dp {
        public long minimumSteps(String s) {
            int len = s.length();
            // dp[i]表示前i个球符合条件的步数
            long[] dp = new long[len];
            int cnt1 = s.charAt(0) == '1' ? 1 : 0;
            for (int i = 1; i < len; i++) {
                // 遇到黑球不用动
                if (s.charAt(i) == '1') {
                    cnt1++;
                    dp[i] = dp[i - 1];
                    continue;
                }
                // 遇到白球往前移动
                dp[i] = dp[i - 1] + cnt1;
            }
            return dp[len - 1];
        }
    }

}
