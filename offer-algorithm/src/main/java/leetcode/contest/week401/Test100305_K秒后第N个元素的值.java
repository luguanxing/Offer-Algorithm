package leetcode.contest.week401;

import java.util.Arrays;

public class Test100305_K秒后第N个元素的值 {

    public static void main(String[] args) {
        System.out.println(new Solution().valueAfterKSeconds(4, 5));
        System.out.println(new Solution().valueAfterKSeconds(5, 3));
    }

    static class Solution {
        public int valueAfterKSeconds(int n, int k) {
            long MOD = 1000000007;
            long[][] martix = new long[k+1][n];
            Arrays.fill(martix[0], 1L);
            for (int i = 1; i <= k; i++) {
                long[] nums = martix[i];
                nums[0] = 1L;
                if (n > 1) {
                    nums[1] = i + 1;
                }
            }
            for (int y = 1; y <= k; y++) {
                for (int x = 2; x < n; x++) {
                    martix[y][x] = martix[y - 1][x] + martix[y][x - 1];
                    martix[y][x] %= MOD;
                }
            }
            return (int) martix[k][n-1];
        }
    }

}
