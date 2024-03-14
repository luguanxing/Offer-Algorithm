package leetcode.problems;

public class Test2789_合并后数组中的最大元素 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxArrayValue(new int[]{2, 3, 7, 9, 3}));
        System.out.println(new Solution().maxArrayValue(new int[]{5, 3, 3}));
        System.out.println(new Solution().maxArrayValue(new int[]{77}));
    }

    static class Solution {
        public long maxArrayValue(int[] nums) {
            long currentNum = nums[nums.length - 1];
            long currentSum = currentNum;
            long res = currentSum;
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] <= currentSum) {
                    currentSum += nums[i];
                    currentNum = nums[i];
                } else {
                    currentSum = nums[i];
                    currentNum = nums[i];
                }
                res = Math.max(res, currentSum);
            }
            return res;
        }
    }

}
