package leetcode.problems;

import java.util.Arrays;

public class Test0396_旋转函数 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxRotateFunction(new int[]{4, 3, 2, 6}));
        System.out.println(new Solution().maxRotateFunction(new int[]{100}));
    }

    static class Solution {
        public int maxRotateFunction(int[] nums) {
            // 由题意：
            // F(0) = 0*A[0]+1*A[1]+2*A[2]+3*A[3]
            // F(1) = 0*A[3]+1*A[0]+2*A[1]+3*A[2]
            // F(2) = 0*A[2]+1*A[3]+2*A[0]+3*A[1]
            // F(3) = 0*A[1]+1*A[2]+2*A[3]+3*A[0]

            // 相减得到：
            // F(1)-F(0) = A[0]+A[1]+A[2]-3*A[3] = A[0]+A[1]+A[2]+A[3]-4*A[3]
            // F(2)-F(1) = A[0]+A[1]+A[3]-3*A[2] = A[0]+A[1]+A[2]+A[3]-4*A[2]
            // F(3)-F(2) = A[0]+A[2]+A[3]-3*A[1] = A[0]+A[1]+A[2]+A[3]-4*A[1]

            // 总结规律：
            // F(i+1) - F(i) = SUM(nums) - n * nums[n-i-1]
            int n = nums.length;
            int[] F = new int[n];
            for (int i = 0; i < n; i++) {
                F[0] += i * nums[i];
            }
            int sum = Arrays.stream(nums).sum();
            for (int i = 1; i < n; i++) {
                F[i] = F[i - 1] + sum - n * nums[n - i];
            }
            return Arrays.stream(F).max().orElse(0);
        }
    }

}
