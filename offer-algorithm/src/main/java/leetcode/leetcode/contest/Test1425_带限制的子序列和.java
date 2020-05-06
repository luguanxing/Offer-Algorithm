package leetcode.leetcode.contest;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Test1425_带限制的子序列和 {

    public static void main(String[] args) {
        System.out.println(new Solution().constrainedSubsetSum(new int[]{10, 2, -10, 5, 20}, 2));
        System.out.println(new Solution().constrainedSubsetSum(new int[]{10, -2, -10, -5, 20}, 2));
        System.out.println(new Solution().constrainedSubsetSum(new int[]{-8269, 3217, -4023, -4138, -683, 6455, -3621, 9242, 4015, -3790}, 1));
        System.out.println(new Solution().constrainedSubsetSum(new int[]{-1, -2, -3}, 1));
        System.out.println(new Solution().constrainedSubsetSum(new int[]{-5266, 4019, 7336, -3681, -5767}, 2));
        System.out.println(new Solution().constrainedSubsetSum(new int[]{-8269, 3217, -4023, -4138, -683, 6455, -3621, 9242, 4015, -3790}, 1));
    }

    static class Solution {
        public int constrainedSubsetSum(int[] nums, int k) {
            // 动态规划：dp[i] = max(max(dp[i-1], dp[i-2], ... dp[i-k]) + nums[i], nums[i])
            TreeSet<Integer> maxHeap = new TreeSet<>();
            List<Integer> heapList = new ArrayList<>();
            maxHeap.add(nums[0]);
            heapList.add(nums[0]);
            for (int i = 1; i < k; i++) {
                int currentMax = Math.max(maxHeap.last() + nums[i], nums[i]);
                heapList.add(currentMax);
                maxHeap.add(currentMax);
            }
            // 维持一个长度为k最大堆
            int max = maxHeap.last();
            for (int i = k; i < nums.length; i++) {
                int currentMax = Math.max(maxHeap.last() + nums[i], nums[i]);
                heapList.add(currentMax);
                maxHeap.add(currentMax);
                maxHeap.remove(heapList.get(i - k));
                max = Math.max(max, maxHeap.last());
            }
            return max;
        }
    }

    static class Solution_超时 {
        public int constrainedSubsetSum(int[] nums, int k) {
            // 动态规划：dp[i] = max(max(dp[i-1], dp[i-2], ... dp[i-k]) + nums[i], nums[i])
            Integer[] dp = new Integer[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int max = dp[i - 1];
                for (int left = 2; 0 <= i - left && left <= k; left++) {
                    max = Math.max(max, dp[i - left]);
                }
                dp[i] = Math.max(max, 0) + nums[i];
            }
            int max = Stream.of(dp).max(Integer::compareTo).orElse(0);
            return max;
        }
    }

}
