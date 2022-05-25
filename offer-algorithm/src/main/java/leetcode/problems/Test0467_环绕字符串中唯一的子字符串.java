package leetcode.problems;

import java.util.Arrays;

public class Test0467_环绕字符串中唯一的子字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().findSubstringInWraproundString("a"));
        System.out.println(new Solution().findSubstringInWraproundString("cac"));
        System.out.println(new Solution().findSubstringInWraproundString("zab"));
    }

    static class Solution {
        public int findSubstringInWraproundString(String p) {
            int len = p.length();
            int[] dp = new int[len];
            int[] maxEndLen = new int[26];
            dp[0] = 1;
            maxEndLen[p.charAt(0) - 'a'] = 1;
            for (int i = 1; i < len; i++) {
                dp[i] = p.charAt(i) == (p.charAt(i - 1) == 'z' ? 'a' : p.charAt(i - 1) + 1) ? dp[i - 1] + 1 : 1;
                maxEndLen[p.charAt(i) - 'a'] = Math.max(maxEndLen[p.charAt(i) - 'a'], dp[i]);
            }
            return Arrays.stream(maxEndLen).sum();
        }
    }

}
