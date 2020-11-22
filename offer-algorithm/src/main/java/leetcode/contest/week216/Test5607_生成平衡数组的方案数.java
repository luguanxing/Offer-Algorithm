package leetcode.contest.week216;

public class Test5607_生成平衡数组的方案数 {

    public static void main(String[] args) {
        System.out.println(new Solution().waysToMakeFair(new int[]{2, 1, 6, 4}));
        System.out.println(new Solution().waysToMakeFair(new int[]{1, 1, 1}));
        System.out.println(new Solution().waysToMakeFair(new int[]{1, 2, 3}));
    }

    static class Solution {
        public int waysToMakeFair(int[] nums) {
            // 初始化前后缀
            int[] prefix = new int[nums.length];
            int[] suffix = new int[nums.length];
            int oddPrefixSum = 0;
            int evenPrefixSum = 0;
            int oddSuffixSum = 0;
            int evenSuffixSum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i % 2 == 0) {
                    evenPrefixSum += nums[i];
                    prefix[i] = evenPrefixSum;
                    evenSuffixSum += nums[nums.length - 1 - i];
                    suffix[nums.length - 1 - i] = evenSuffixSum;
                } else {
                    oddPrefixSum += nums[i];
                    prefix[i] = oddPrefixSum;
                    oddSuffixSum += nums[nums.length - 1 - i];
                    suffix[nums.length - 1 - i] = oddSuffixSum;
                }
            }
            // 根据i计算前后缀判断是否为平衡数组
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                int oddSum = 0;
                int evenSum = 0;
                if (i % 2 == 0) {
                    if (i - 2 >= 0) {
                        evenSum += prefix[i - 2];
                    }
                    if (i + 1 < nums.length) {
                        evenSum += suffix[i + 1];
                    }
                    if (i - 1 >= 0) {
                        oddSum += prefix[i - 1];
                    }
                    if (i + 2 < nums.length) {
                        oddSum += suffix[i + 2];
                    }
                } else {
                    if (i - 1 >= 0) {
                        evenSum += prefix[i - 1];
                    }
                    if (i + 2 < nums.length) {
                        evenSum += suffix[i + 2];
                    }
                    if (i - 2 >= 0) {
                        oddSum += prefix[i - 2];
                    }
                    if (i + 1 < nums.length) {
                        oddSum += suffix[i + 1];
                    }
                }
                if (oddSum == evenSum) {
                    res++;
                }
            }
            return res;
        }
    }

}
