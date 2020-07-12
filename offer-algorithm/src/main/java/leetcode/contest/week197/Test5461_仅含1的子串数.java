package leetcode.contest.week197;

import java.math.BigInteger;

public class Test5461_仅含1的子串数 {

    public static void main(String[] args) {
        System.out.println(new Solution().numSub("0110111"));
        System.out.println(new Solution().numSub("101"));
        System.out.println(new Solution().numSub("111111"));
        System.out.println(new Solution().numSub("000"));
    }

    static class Solution {
        public int numSub(String s) {
            // 计算连续的1字符串有多少个1
            BigInteger[] dp = new BigInteger[100005];
            dp[1] = new BigInteger("1");
            dp[2] = new BigInteger("3");
            for (int i = 3; i < dp.length; i++) {
                dp[i] = dp[i - 1].multiply(new BigInteger("2")).add(new BigInteger("1")).subtract(dp[i - 2]);
            }
            // 计算当前字符串有多少个连续1
            BigInteger res = new BigInteger("0");
            int continus1 = 0;
            int len = 0;
            for (Character c : s.toCharArray()) {
                if (c == '1') {
                    continus1++;
                } else {
                    if (continus1 > 0) {
                        res = res.add(dp[continus1]);
                        continus1 = 0;
                    }
                }
                if (++len == s.length() && continus1 > 0) {
                    res = res.add(dp[continus1]);
                }
            }
            return res.mod(new BigInteger("1000000007")).intValue();
        }
    }

}
