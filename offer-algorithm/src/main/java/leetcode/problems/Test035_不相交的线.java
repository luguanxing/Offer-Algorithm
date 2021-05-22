package leetcode.problems;

public class Test035_不相交的线 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxUncrossedLines(
                new int[]{1, 4, 2},
                new int[]{1, 2, 4}
        ));
        System.out.println(new Solution().maxUncrossedLines(
                new int[]{2, 5, 1, 2, 5},
                new int[]{10, 5, 2, 1, 5, 2}
        ));
        System.out.println(new Solution().maxUncrossedLines(
                new int[]{1, 3, 7, 1, 7, 5},
                new int[]{1, 9, 2, 5, 1}
        ));
        System.out.println(new Solution().maxUncrossedLines(
                new int[]{2, 1},
                new int[]{1, 2, 1, 3, 3, 2}
        ));
    }

    static class Solution {
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            int[][] dp = new int[nums1.length][nums2.length];
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    int macthIJ = (i > 0 && j > 0 ? dp[i - 1][j - 1] : 0) + (nums1[i] == nums2[j] ? 1 : 0);
                    int ingoreI = (i > 0 ? dp[i - 1][j] : 0);
                    int ingoreJ = (j > 0 ? dp[i][j - 1] : 0);
                    dp[i][j] = Math.max(macthIJ, ingoreI);
                    dp[i][j] = Math.max(dp[i][j], ingoreJ);
                }
            }
            return dp[nums1.length - 1][nums2.length - 1];
        }
    }

}
