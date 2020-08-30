package leetcode.contest.week204;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test5500_乘积为正数的最长子数组长度 {

    public static void main(String[] args) {
        System.out.println(new Solution().getMaxLen(new int[]{1, -2, -3, 4}));
        System.out.println(new Solution().getMaxLen(new int[]{0, 1, -2, -3, -4}));
        System.out.println(new Solution().getMaxLen(new int[]{-1, -2, -3, 0, 1}));
        System.out.println(new Solution().getMaxLen(new int[]{-1, 2}));
        System.out.println(new Solution().getMaxLen(new int[]{1, 2, 3, 5, -6, 4, 0, 10}));
        System.out.println(new Solution().getMaxLen(new int[]{6, 2, 10, 1, -2, 8}));
        System.out.println(new Solution().getMaxLen(new int[]{-1}));
        System.out.println(new Solution().getMaxLen(new int[]{5, -20, -20, -39, -5, 0, 0, 0, 36, -32, 0, -7, -10, -7, 21, 20, -12, -34, 26, 2}));
    }

    static class Solution {
        public int getMaxLen(int[] nums) {
            // 简化数值大小
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0) {
                    nums[i] = -1;
                } else if (nums[i] > 0) {
                    nums[i] = 1;
                } else {
                    nums[i] = 0;
                }
            }
            // 根据0切分list
            List<Integer> numList = Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.toList());
            List<List<Integer>> list = new ArrayList<>();
            while (numList.indexOf(0) >= 0) {
                int index = numList.indexOf(0);
                List<Integer> subNumList = numList.subList(0, index);
                if (subNumList.size() != 0) {
                    list.add(subNumList);
                }
                numList = numList.subList(index + 1, numList.size());
            }
            list.add(numList);
            // 滑动窗口
            int max = 0;
            for (List<Integer> subNumList : list) {
                max = Math.max(getMax(subNumList), max);
            }
            return max;
        }

        private int getMax(List<Integer> subNumList) {
            int left = 0;
            int right = 0;
            int maxLen = 0;
            int prod = 1;
            while (left < subNumList.size()) {
                // 如果右边未到尽头，不断向右探测，否则左边移动直到结束
                if (right < subNumList.size()) {
                    prod *= subNumList.get(right++);
                } else {
                    prod /= subNumList.get(left++);
                }
                if (prod > 0) {
                    maxLen = Math.max(maxLen, right - left);
                }
            }
            return maxLen;
        }
    }

}
