package leetcode.problems;

public class Test1031_两个非重叠子数组的最大和 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxSumTwoNoOverlap(
                new int[]{0, 6, 5, 2, 2, 5, 1, 9, 4}, 1, 2
        ));
        System.out.println(new Solution().maxSumTwoNoOverlap(
                new int[]{3, 8, 1, 3, 2, 1, 8, 9, 0}, 3, 2
        ));
        System.out.println(new Solution().maxSumTwoNoOverlap(
                new int[]{2, 1, 5, 6, 0, 9, 5, 0, 3, 8}, 4, 3
        ));
    }

    static class Solution {
        public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
            // 计算前缀和
            int len = nums.length;
            int[] prefixSum = new int[len + 1];
            for (int i = 1; i <= len; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            }
            // 计算两段最大和
            int maxSum = 0;
            for (int i = 0; i + firstLen <= len; i++) {
                // 第一部分和
                int firstSum = prefixSum[i + firstLen] - prefixSum[i];
                // 第二部分和（可能在前可能在后）
                for (int j = 0; j + secondLen <= i; j++) {
                    int secondSum = prefixSum[j + secondLen] - prefixSum[j];
                    maxSum = Math.max(maxSum, firstSum + secondSum);
                }
                for (int j = i + firstLen + 1; j + secondLen <= len; j++) {
                    int secondSum = prefixSum[j + secondLen] - prefixSum[j];
                    maxSum = Math.max(maxSum, firstSum + secondSum);
                }
            }
            return maxSum;
        }
    }

}
