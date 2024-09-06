package leetcode.problems;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test3176_求出最长好子序列I {

    public static void main(String[] args) {
        // nums = [1,2,1,1,3], k = 2
        System.out.println(new Solution().maximumLength(new int[]{1, 2, 1, 1, 3}, 2));
        // nums = [1,2,3,4,5,1], k = 0
        System.out.println(new Solution().maximumLength(new int[]{1, 2, 3, 4, 5, 1}, 0));
    }

    static class Solution {
        public int maximumLength(int[] nums, int k) {
            int len = nums.length;
            // dp[k][n] 表示前n个数中，选取k个数，且以第n个数结尾的最长好子序列的长度
            int[][] dp = new int[k+1][len];
            // 初始化第一行，dp[0][x]即nums[x]在之前出现的个数
            Map<Integer, Integer> row0 = new HashMap<>();
            for (int x = 0; x < len; x++) {
                dp[0][x] = row0.getOrDefault(nums[x], 0) + 1;
                row0.put(nums[x], dp[0][x]);
            }
            // dp[k][n] = max(dp[k][j])+1若nums[n]=nums[j]
            // dp[k][n] = max(dp[k-1][j])+1若nums[n]!=nums[j]
            for (int x = 1; x < len; x++) {
                for (int y = 1; y <= k; y++) {
                    for (int z = 0; z < x; z++) {
                        if (nums[x] == nums[z]) {
                            dp[y][x] = Math.max(dp[y][x], dp[y][z] + 1);
                        } else {
                            dp[y][x] = Math.max(dp[y][x], dp[y-1][z] + 1);
                        }
                    }
                }
            }
            // 计算dp中的最大值
            return Arrays.stream(dp)
                    .mapToInt(row -> Arrays.stream(row).max().getAsInt())
                    .max().getAsInt();
        }
    }

}
