package leetcode.contest.week369;

public class Test100107_使数组变美的最小增量运算数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minIncrementOperations(new int[]{2, 3, 0, 0, 2}, 4));
        System.out.println(new Solution().minIncrementOperations(new int[]{0, 1, 3, 3}, 5));
        System.out.println(new Solution().minIncrementOperations(new int[]{1, 1, 2}, 1));
        System.out.println(new Solution().minIncrementOperations(new int[]{7, 7, 2, 7}, 9)); // 2
        System.out.println(new Solution().minIncrementOperations(new int[]{43, 31, 14, 4}, 73)); // 42
        System.out.println(new Solution().minIncrementOperations(new int[]{20, 38, 29, 34, 6}, 95)); // 66
    }

    static class Solution {
        public long minIncrementOperations(int[] nums, int k) {
            long dp1 = 0;
            long dp2 = 0;
            long dp3 = 0;
            for (int num : nums) {
                long oldDp1 = dp1;
                long oldDp2 = dp2;
                long oldDp3 = dp3;
                // 把当前数字调整为不小于 k 的数需要的操作数量为 max(0, k - num)，而此前需要的操作数量为 min(dp1, dp2, dp3)
                dp1 = Math.min(oldDp1, Math.min(oldDp2, oldDp3)) + Math.max(k - num, 0);
                dp2 = oldDp1;
                dp3 = oldDp2;
            }
            return Math.min(dp1, Math.min(dp2, dp3));
        }
    }


}
