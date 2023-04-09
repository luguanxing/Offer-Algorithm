package leetcode.contest.week340;

public class Test6361_对角线上的质数 {

    public static void main(String[] args) {
        System.out.println(new Solution().diagonalPrime(new int[][]{{1, 2, 3}, {5, 6, 7}, {9, 10, 11}}));
        System.out.println(new Solution().diagonalPrime(new int[][]{{1, 2, 3}, {5, 17, 7}, {9, 11, 10}}));
    }

    static class Solution {
        public int diagonalPrime(int[][] nums) {
            int len = nums.length;
            int res = 0;
            for (int i = 0; i < len; i++) {
                if (isPrime(nums[i][i])) {
                    res = Math.max(res, nums[i][i]);
                }
                if (isPrime(nums[len - 1 - i][i])) {
                    res = Math.max(res, nums[len - 1 - i][i]);
                }
            }
            return res;
        }

        private boolean isPrime(int n) {
            if (n == 1) {
                return false;
            }
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
