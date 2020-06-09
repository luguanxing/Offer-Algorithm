package leetcode.interview;

public class Test46_把数字翻译成字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().translateNum(12258));
        System.out.println(new Solution().translateNum(12000));
        System.out.println(new Solution().translateNum(12001));
        System.out.println(new Solution().translateNum(26));
        System.out.println(new Solution().translateNum(5));
        System.out.println(new Solution().translateNum(0));
    }

    static class Solution {
        public int translateNum(int num) {
            if (num < 10) {
                return 1;
            }
            String numStr = String.valueOf(num);
            char[] numChars = numStr.toCharArray();
            // dp[i] = (0 < dp[i-1][i] <= 25) ? dp[i-2]+dp[i-1] : dp[i-1]
            int[] dp = new int[numChars.length];
            dp[0] = 1;
            dp[1] = Integer.parseInt(numChars[0] + "" + numChars[1]) <= 25 ? 2 : 1;
            for (int i = 2; i < numChars.length; i++) {
                int two = Integer.parseInt(numChars[i - 1] + "" + numChars[i]);
                if (numChars[i - 1] != '0' && 0 < two && two <= 25) {
                    dp[i] = dp[i - 2] + dp[i - 1];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
            return dp[numChars.length - 1];
        }
    }

}
