package leetcode.problems;

import java.util.Arrays;

public class Test0152_乘积最大子数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(new Solution().maxProduct(new int[]{-2, 0, -1}));
        System.out.println(new Solution().maxProduct(new int[]{-2}));
        System.out.println(new Solution().maxProduct(new int[]{0, 2}));
    }

    static class Solution {
        public int maxProduct(int[] nums) {
            int[] max = new int[nums.length];
            int[] min = new int[nums.length];
            max[0] = nums[0];
            min[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int res1 = max[i - 1] * nums[i];
                int res2 = min[i - 1] * nums[i];
                int res3 = nums[i];
                max[i] = Math.max(res3, Math.max(res1, res2));
                min[i] = Math.min(res3, Math.min(res1, res2));
            }
            return Arrays.stream(max).max().orElse(0);
        }
    }

    static class Solution_暴力 {
        public int maxProduct(int[] nums) {
            int max = nums[0];
            for (int i = 0; i < nums.length; i++) {
                int product = 1;
                for (int j = i; j < nums.length; j++) {
                    product *= nums[j];
                    max = Math.max(max, product);
                }
            }
            return max;
        }
    }

}
