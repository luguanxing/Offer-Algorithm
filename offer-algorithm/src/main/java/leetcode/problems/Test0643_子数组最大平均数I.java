package leetcode.problems;

public class Test0643_子数组最大平均数I {

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxAverage(
                new int[]{1, 12, -5, -6, 50, 3}, 4
        ));
    }

    static class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int currentSum = 0;
            int right = 0;
            while (right < k) {
                currentSum += nums[right++];
            }
            int maxSum = currentSum;
            while (right < nums.length) {
                currentSum += nums[right];
                currentSum -= nums[right++ - k];
                maxSum = Math.max(maxSum, currentSum);
            }
            return maxSum * 1.0 / k;
        }
    }

}
