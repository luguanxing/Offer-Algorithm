package leetcode.contest.week262;

import java.util.Arrays;

public class Test5897_将数组分成两个数组并最小化数组和的差 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumDifference(new int[]{3, 9, 7, 3}));
        System.out.println(new Solution().minimumDifference(new int[]{-36, 36}));
        System.out.println(new Solution().minimumDifference(new int[]{2, -1, 0, 4, -2, -9}));
    }


    static class Solution {
        public int minimumDifference(int[] nums) {
            sum = Arrays.stream(nums).sum();
            comb(nums, nums.length, nums.length / 2, 0);
            return ret;
        }

        int ret = Integer.MAX_VALUE;
        int sum = 0;

        //从n选出k组合放入res
        public void comb(int[] nums, int n, int k, int curSum) {
            if (k == 0) {
                ret = Math.min(ret, Math.abs(sum - 2 * curSum));
                return;
            }
            if (n == 0) {
                return;
            }
            comb(nums, n - 1, k - 1, curSum + nums[n - 1]);
            comb(nums, n - 1, k, curSum);
        }
    }

}
