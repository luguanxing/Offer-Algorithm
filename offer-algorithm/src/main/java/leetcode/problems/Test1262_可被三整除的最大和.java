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
            // dp[m]表示模为m的最大和
            int[] dp = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};
            // 遍历每个数
            for (int num : nums) {
                int[] nextDp = new int[3];
                System.arraycopy(dp, 0, nextDp, 0, dp.length);
                // 更新每个模m加上num后对于应的模的最大和
                for (int m = 0; m < dp.length; m++) {
                    int sum = dp[m];
                    int nextSum = sum + num;
                    nextDp[(m + num) % 3] = Math.max(nextDp[(m + num) % 3], nextSum);
                }
                dp = nextDp;
            }
            return dp[0];
        }
    }

    static class Solution_OLD {
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
