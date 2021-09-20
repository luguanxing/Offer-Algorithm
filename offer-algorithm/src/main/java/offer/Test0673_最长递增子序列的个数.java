package offer;

import java.util.Arrays;

public class Test0673_最长递增子序列的个数 {

    public static void main(String[] args) {
        System.out.println(new Solution().findNumberOfLIS(new int[]{
                1, 3, 5, 4, 7
        }));
        System.out.println(new Solution().findNumberOfLIS(new int[]{
                2, 2, 2, 2, 2
        }));
        System.out.println(new Solution().findNumberOfLIS(new int[]{
                1, 2, 4, 3, 5, 4, 7, 2
        }));
    }

    static class Solution {
        public int findNumberOfLIS(int[] nums) {
            // dp[i]表示以nums[i]结尾的最长递增子序列长度
            // cnt[i]表示以nums[i]结尾组成的最长递增子序列的个数
            int[] dp = new int[nums.length];
            int[] cnt = new int[nums.length];
            dp[0] = 1;
            cnt[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                dp[i] = 1;
                cnt[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        if (dp[j] + 1 > dp[i]) {
                            // 更新最长子序列长度的结果
                            dp[i] = dp[j] + 1;
                            cnt[i] = cnt[j];
                        } else if (dp[j] + 1 == dp[i]) {
                            // 记住能到当前最大的个数
                            cnt[i] += cnt[j];
                        }
                    }
                }
            }
            int max = Arrays.stream(dp).max().orElse(1);
            int res = 0;
            for (int i = 0; i < dp.length; i++) {
                if (dp[i] == max) {
                    res += cnt[i];
                }
            }
            return res;
        }
    }

}
