package leetcode.problems;

import java.util.*;

public class Test1696_跳跃游戏VI {

    public static void main(String[] args) {
        // nums = [1,-1,-2,4,-7,3], k = 2
        System.out.println(new Solution().maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2));
        // nums = [10,-5,-2,4,0,3], k = 3
        System.out.println(new Solution().maxResult(new int[]{10, -5, -2, 4, 0, 3}, 3));
        // nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
        System.out.println(new Solution().maxResult(new int[]{1, -5, -20, 4, -1, 3, -6, -3}, 2));
    }

    static class Solution {
        public int maxResult(int[] nums, int k) {
            int len = nums.length;
            // dp[i]表示跳到i处最大得分
            int[] dp = new int[len];
            dp[0] = nums[0];
            // 使用treemap存储最近k个dp[j]
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int cnt = 0;
            // dp[i] = nums[i] + max(dp[j]) (i-k <= j < i)
            for (int i = 1; i < len; i++) {
                map.put(dp[i - 1], map.getOrDefault(dp[i - 1], 0) + 1);
                cnt++;
                if (cnt > k) {
                    int key = dp[i - k - 1];
                    if (map.get(key) == 1) {
                        map.remove(key);
                    } else {
                        map.put(key, map.get(key) - 1);
                    }
                    cnt--;
                }
                dp[i] = nums[i] + map.lastKey();
            }
            return dp[len - 1];
        }
    }

}
