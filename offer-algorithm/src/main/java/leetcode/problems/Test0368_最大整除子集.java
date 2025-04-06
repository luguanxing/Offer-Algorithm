package leetcode.problems;

import java.util.*;

public class Test0368_最大整除子集 {

    public static void main(String[] args) {
        System.out.println(new Solution().largestDivisibleSubset(new int[]{1, 2, 3}));
        System.out.println(new Solution().largestDivisibleSubset(new int[]{1, 2, 4, 8}));
        System.out.println(new Solution().largestDivisibleSubset(new int[]{4, 8, 10, 240}));
        System.out.println(new Solution().largestDivisibleSubset(new int[]{2, 3, 4, 9, 8}));
        System.out.println(new Solution().largestDivisibleSubset(new int[]{1}));
    }

    static class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            int len = nums.length;
            // 计算最长子集长度
            Arrays.sort(nums);
            int[] dp = new int[len];
            int maxCnt = 1;
            int maxNum = nums[0];
            for (int i = 0; i < len; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] % nums[j] == 0) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                if (dp[i] > maxCnt) {
                    maxCnt = dp[i];
                    maxNum = nums[i];
                }
            }
            // 倒推
            List<Integer> res = new ArrayList<>();
            int currentNum = maxNum;
            int currentCnt = maxCnt;
            res.add(currentNum);
            for (int i = len - 1; i >= 0; i--) {
                if (dp[i] == currentCnt - 1 && currentNum % nums[i] == 0) {
                    currentCnt--;
                    currentNum = nums[i];
                    res.add(currentNum);
                }
            }
            return res;
        }
    }

}
