package leetcode.problems;

import java.util.Arrays;

public class Test0132_分割回文串II {

    public static void main(String[] args) {
        System.out.println(new Solution().minCut("aab"));
        System.out.println(new Solution().minCut("a"));
        System.out.println(new Solution().minCut("ab"));
    }

    static class Solution {
        public int minCut(String s) {
            int len = s.length();
            boolean[][] isHui = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                Arrays.fill(isHui[i], true);
            }
            for (int y = len - 1; y >= 0; y--) {
                for (int x = y + 1; x < len; x++) {
                    isHui[y][x] = (s.charAt(y) == s.charAt(x)) && (isHui[y + 1][x - 1]);
                }
            }
            int[] res = new int[len];
            for (int i = 0; i < len; i++) {
                res[i] = Integer.MAX_VALUE;
                if (isHui[0][i]) {
                    res[i] = 0;
                } else {
                    for (int j = 0; j < i; j++) {
                        if (isHui[j + 1][i]) {
                            res[i] = Math.min(res[i], res[j] + 1);
                        }
                    }
                }
            }
            return res[len - 1];
        }
    }

}
