package leetcode.problems;

public class Test1035_不相交的线 {

    public static void main(String[] args) {
        // nums1 = [1,4,2], nums2 = [1,2,4]
        System.out.println(new Solution().maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
        // nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
        System.out.println(new Solution().maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));
        // nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
        System.out.println(new Solution().maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}));
        // nums1 = [2,3,1], nums2 = [3,1,3,3,3,3]
        System.out.println(new Solution().maxUncrossedLines(new int[]{2, 3, 1}, new int[]{3, 1, 3, 3, 3, 3}));
    }

    static class Solution {
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            // dp[i][j]表示两个数组以i和j结尾的答案
            // dp[i][j] = max(配对ij时dp[i-1][j-1]+1且nums1[i]==nums2[j]，忽略i时dp[i-1][j]，忽略j时dp[i][j-1])
            int len1 = nums1.length;
            int len2 = nums2.length;
            int[][] dp = new int[len1][len2];
            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len2; j++) {
                    // 配对ij
                    if (nums1[i] == nums2[j]) {
                        dp[i][j] = (i == 0 || j == 0 ? 0 : dp[i - 1][j - 1]) + 1;
                    }
                    // 忽略i
                    if (i != 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                    }
                    // 忽略j
                    if (j != 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[len1 - 1][len2 - 1];
        }
    }

    static class Solution_未优化 {
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            // dp[i][j]表示两个数组以i和j结尾的答案
            // dp[i][j] = max(不配对i时dp[i-1][j], 配对i时dp[i-1][k-1]+1且nums1[i]==nums2[k])
            int len1 = nums1.length;
            int len2 = nums2.length;
            int[][] dp = new int[len1][len2];
            for (int i = 0; i < len2; i++) {
                if (nums1[0] == nums2[i]) {
                    dp[0][i] = 1;
                } else if (i != 0) {
                    dp[0][i] = dp[0][i - 1];
                }
            }
            for (int i = 1; i < len1; i++) {
                for (int j = 0; j < len2; j++) {
                    dp[i][j] = dp[i - 1][j];
                    for (int k = 0; k <= j; k++) {
                        if (nums1[i] == nums2[k]) {
                            dp[i][j] = Math.max(dp[i][j], (k == 0 ? 0 : dp[i - 1][k - 1]) + 1);
                        }
                    }
                }
            }
            return dp[len1 - 1][len2 - 1];
        }
    }

}
