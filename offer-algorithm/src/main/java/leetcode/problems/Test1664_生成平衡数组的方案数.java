package leetcode.problems;

public class Test1664_生成平衡数组的方案数 {

    public static void main(String[] args) {
        System.out.println(new Solution().waysToMakeFair(new int[]{2, 1, 6, 4}));
        System.out.println(new Solution().waysToMakeFair(new int[]{1, 1, 1}));
        System.out.println(new Solution().waysToMakeFair(new int[]{1, 2, 3}));
    }

    static class Solution {
        public int waysToMakeFair(int[] nums) {
            int len = nums.length;
            int[] oddPrefixSum = new int[len];
            int[] evenPrefixSum = new int[len];
            int[] oddSuffixSum = new int[len];
            int[] evenSuffixSum = new int[len];
            init(nums, oddPrefixSum, evenPrefixSum, oddSuffixSum, evenSuffixSum);
            int res = 0;
            for (int i = 0; i < len; i++) {
                int oddSum = 0;
                int evenSum = 0;
                if (i % 2 == 0) {
                    oddSum += (i - 1 < 0 ? 0 : oddPrefixSum[i - 1]);
                    evenSum += (i - 2 < 0 ? 0 : evenPrefixSum[i - 2]);
                    oddSum += (i + 2 >= len ? 0 : evenSuffixSum[i + 2]);
                    evenSum += (i + 1 >= len ? 0 : oddSuffixSum[i + 1]);
                } else {
                    oddSum += (i - 2 < 0 ? 0 : oddPrefixSum[i - 2]);
                    evenSum += (i - 1 < 0 ? 0 : evenPrefixSum[i - 1]);
                    oddSum += (i + 1 >= len ? 0 : evenSuffixSum[i + 1]);
                    evenSum += (i + 2 >= len ? 0 : oddSuffixSum[i + 2]);
                }
                if (oddSum == evenSum) {
                    res++;
                }
            }
            return res;
        }

        private void init(int[] nums, int[] oddPrefixSum, int[] evenPrefixSum, int[] oddSuffixSum, int[] evenSuffixSum) {
            int len = nums.length;
            int oddSum = 0;
            int evenSum = 0;
            for (int i = 0; i < len; i++) {
                if (i % 2 == 0) {
                    evenSum += nums[i];
                    evenPrefixSum[i] = evenSum;
                } else {
                    oddSum += nums[i];
                    oddPrefixSum[i] = oddSum;
                }
            }
            oddSum = 0;
            evenSum = 0;
            for (int i = len - 1; i >= 0; i--) {
                if (i % 2 == 0) {
                    evenSum += nums[i];
                    evenSuffixSum[i] = evenSum;
                } else {
                    oddSum += nums[i];
                    oddSuffixSum[i] = oddSum;
                }
            }
        }
    }

}
