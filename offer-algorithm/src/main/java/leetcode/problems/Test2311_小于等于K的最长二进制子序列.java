package leetcode.problems;

import java.math.BigInteger;

public class Test2311_小于等于K的最长二进制子序列 {

    public static void main(String[] args) {
        // s = "1001010", k = 5
        System.out.println(new Solution().longestSubsequence("1001010", 5));
        // s = "00101001", k = 1
        System.out.println(new Solution().longestSubsequence("00101001", 1));
        System.out.println(new Solution().longestSubsequence("0", 583196182));
        System.out.println(new Solution().longestSubsequence("1011", 281854076));
        System.out.println(new Solution().longestSubsequence("1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", 1));
    }

    static class Solution {
        public int longestSubsequence(String s, int k) {
            int len = s.length();
            // 直接枚举右边的情况，只要满足小于k，然后左边剩下全要0
            int res = 0;
            int idx = len - 1;
            StringBuilder sb = new StringBuilder();
            while (idx >= 0) {
                sb.insert(0, s.charAt(idx));
                if (new BigInteger(sb.toString(), 2).compareTo(new BigInteger(String.valueOf(k))) > 0) {
                    break;
                }
                int cnt0 = 0;
                for (int i = idx - 1; i >= 0; i--) {
                    if (s.charAt(i) == '0') {
                        cnt0++;
                    }
                }
                res = Math.max(res, sb.length() + cnt0);
                idx--;
            }
            return res;
        }
    }

}
