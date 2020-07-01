package leetcode.problems;

public class Test0718_最长重复子数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
        System.out.println(new Solution().findLength(new int[]{1, 2, 3, 3, 1}, new int[]{3, 2, 1, 4, 7}));
    }

    static class Solution {
        public int findLength(int[] A, int[] B) {
            // dp[i][j]表示A[i]和B[j]相同时A[0-i]B[0-j]最长的公共子数组长度
            int[][] dp = new int[A.length][B.length];
            for (int i = 0; i < A.length; i++) {
                dp[i][0] = (B[0] == A[i]) ? 1 : 0;
            }
            for (int i = 0; i < B.length; i++) {
                dp[0][i] = (A[0] == B[i]) ? 1 : 0;
            }
            // dp[i][j] = (A[i] == B[j]) ? (dp[i-1][j-1] + 1) : 0;
            for (int i = 1; i < A.length; i++) {
                for (int j = 1; j < B.length; j++) {
                    dp[i][j] = (A[i] == B[j]) ? (dp[i - 1][j - 1] + 1) : 0;
                }
            }
            int max = 0;
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B.length; j++) {
                    max = Math.max(max, dp[i][j]);
                }
            }
            return max;
        }
    }

}
