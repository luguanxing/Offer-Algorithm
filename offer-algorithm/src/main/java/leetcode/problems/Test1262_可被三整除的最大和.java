package leetcode.problems;

public class Test1262_可被三整除的最大和 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxSumDivThree(new int[]{5, 1, 3, 6, 8}));
        System.out.println(new Solution().maxSumDivThree(new int[]{3, 6, 5, 1, 8}));
        System.out.println(new Solution().maxSumDivThree(new int[]{4}));
        System.out.println(new Solution().maxSumDivThree(new int[]{1, 2, 3, 4, 4}));
    }

    static class Solution {
        public int maxSumDivThree(int[] nums) {
            int len = nums.length;
            // dp[i][m]表示前i位模为m的最大和
            int[][] dp = new int[len][3];
            dp[0][nums[0] % 3] = nums[0];
            // dp[i][m] = max(dp[i-1][m], dp[i-1][(m-(nums[i]%3)+3)%3]+nums[i]
            for (int i = 1; i < len; i++) {
                for (int iMod = 0; iMod < 3; iMod++) {
                    int currentNum = nums[i];
                    int currentMod = nums[i] % 3;
                    int lastMod = (iMod - currentMod + 3) % 3;
                    int lastCnt = dp[i - 1][lastMod];
                    if (lastCnt != 0) {
                        dp[i][iMod] = Math.max(dp[i - 1][iMod], lastCnt + currentNum);
                    } else {
                        dp[i][iMod] = Math.max(dp[i - 1][iMod], currentMod == iMod ? currentNum : 0);
                    }
                }
            }
            return dp[len - 1][0];
        }
    }

}
