package leetcode.contest.week220;

import java.util.HashSet;
import java.util.Set;

public class Test5630_删除子数组的最大得分 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumUniqueSubarray(
                new int[]{4, 2, 4, 5, 6}
        ));
        System.out.println(new Solution().maximumUniqueSubarray(
                new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}
        ));
    }

    static class Solution {
        public int maximumUniqueSubarray(int[] nums) {
            int maxSum = 0;
            int currentSum = 0;
            int left = 0;
            int right = 0;
            Set<Integer> set = new HashSet();
            // 两个指针(左闭右开)，如果右边的发现重复则左边的移动直到不重复为止
            while (left < nums.length) {
                // 如果右边未到尽头，不断向右探测，否则左边移动直到结束
                if (right < nums.length) {
                    int currentNum = nums[right];
                    if (set.contains(currentNum)) {
                        currentSum -= nums[left];
                        set.remove(nums[left]);
                        left++;
                    } else {
                        currentSum += currentNum;
                        set.add(currentNum);
                        right++;
                    }
                } else {
                    break;
                }
                maxSum = Math.max(maxSum, currentSum);
            }
            return maxSum;
        }
    }

}
