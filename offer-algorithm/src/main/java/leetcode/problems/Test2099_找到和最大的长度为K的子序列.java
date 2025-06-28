package leetcode.problems;

import java.util.*;

public class Test2099_找到和最大的长度为K的子序列 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().maxSubsequence(
                new int[]{2, 1, 3, 3}, 2
        )));
        System.out.println(Arrays.toString(new Solution().maxSubsequence(
                new int[]{-1, -2, 3, 4}, 3
        )));
        System.out.println(Arrays.toString(new Solution().maxSubsequence(
                new int[]{3, 4, 3, 3}, 2
        )));
    }

    static class Solution {
        public int[] maxSubsequence(int[] nums, int k) {
            int len = nums.length;
            int[] sortedNums = nums.clone();
            Arrays.sort(sortedNums);
            // 先要后面k个
            Map<Integer, Integer> targetMap = new HashMap<>();
            for (int i = 1; i <= k; i++) {
                int num = sortedNums[len - i];
                targetMap.put(num, targetMap.getOrDefault(num, 0) + 1);
            }
            // 按顺序排列回来
            int[] res = new int[k];
            int resIdx = 0;
            for (int num : nums) {
                if (targetMap.containsKey(num)) {
                    res[resIdx++] = num;
                    targetMap.put(num, targetMap.get(num) - 1);
                    if (targetMap.get(num) == 0) {
                        targetMap.remove(num);
                    }
                }
            }
            return res;
        }
    }

}
