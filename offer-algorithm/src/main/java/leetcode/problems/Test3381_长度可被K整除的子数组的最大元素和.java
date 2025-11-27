package leetcode.problems;

import java.util.Arrays;

public class Test3381_长度可被K整除的子数组的最大元素和 {

    public static void main(String[] args) {
        // nums = [1,2], k = 1
        System.out.println(new Solution().maxSubarraySum(new int[]{1, 2}, 1));
        // nums = [-1,-2,-3,-4,-5], k = 4
        System.out.println(new Solution().maxSubarraySum(new int[]{-1, -2, -3, -4, -5}, 4));
        // nums = [-5,1,2,-3,4], k = 2
        System.out.println(new Solution().maxSubarraySum(new int[]{-5, 1, 2, -3, 4}, 2));
    }

    static class Solution {
        public long maxSubarraySum(int[] nums, int k) {
            int len = nums.length;
            // mod[l%k]表示长度为l时，l%k的前缀和的最小值
            long[] mod = new long[k];
            // 初始化除了mod[0]之外的值为正无穷
            Arrays.fill(mod, Long.MAX_VALUE / 2);
            mod[0] = 0;
            // 不断更新前缀和以及结果，注意序号为i时，前缀和长度为i+1
            long sum = 0;
            long res = Long.MIN_VALUE;
            for (int i = 0; i < len; i++) {
                sum += nums[i];
                int l = i + 1;
                res = Math.max(res, sum - mod[l % k]);
                mod[l % k] = Math.min(mod[l % k], sum);
            }
            return res;
        }
    }

}
