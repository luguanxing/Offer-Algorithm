package leetcode.contest.week220;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test5631_跳跃游戏VI {

    public static void main(String[] args) {
        System.out.println(new Solution().maxResult(
                new int[]{1, -1, -2, 4, -7, 3}, 2
        ));
        System.out.println(new Solution().maxResult(
                new int[]{10, -5, -2, 4, 0, 3}, 3
        ));
        System.out.println(new Solution().maxResult(
                new int[]{1, -5, -20, 4, -1, 3, -6, -3}, 2
        ));
    }

    static class Solution {
        public int maxResult(int[] nums, int k) {
            k = Math.min(k, 1000);
            int[] dp = new int[nums.length];
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            dp[0] = nums[0];
            queue.add(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                int max = queue.peek();
                dp[i] = max + nums[i];
                if (queue.size() == k) {
                    queue.remove(dp[i - k]);
                }
                queue.add(dp[i]);
            }
            return dp[nums.length - 1];
        }
    }


}
