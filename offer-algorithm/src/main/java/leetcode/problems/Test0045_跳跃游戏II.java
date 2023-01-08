package leetcode.problems;

import java.util.Arrays;

public class Test0045_跳跃游戏II {

    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new Solution().jump(new int[]{3, 2, 1, 0, 5}));
        System.out.println(new Solution().jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println(new Solution().jump(new int[]{0}));
    }

    static class Solution {
        public int jump(int[] nums) {
            // 每次找最远能跳的距离，记录次数
            int len = nums.length;
            int maxPosition = 0;
            int currenEnd = 0;
            int cnt = 0;
            for (int i = 0; i < len - 1; i++) {
                int distance = nums[i];
                maxPosition = Math.max(maxPosition, i + distance);
                if (i >= maxPosition) {
                    return -1;
                }
                if (i == currenEnd) {
                    cnt++;
                    currenEnd = maxPosition;
                }
            }
            return cnt;
        }
    }

    static class Solution_DP {
        public int jump(int[] nums) {
            // dp[i]表示跳到i处的最小步骤
            // dp[i] = min(dp[j] + 1)，其中j可跳到i
            int len = nums.length;
            int[] dp = new int[len];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (j + nums[j] >= i) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
            return dp[len - 1] == Integer.MAX_VALUE ? -1 : dp[len - 1];
        }
    }

    static class Solution_旧 {
        public int jump(int[] nums) {
            if (nums == null || nums.length == 0 || nums.length == 1) {
                return 0;
            }
            // 计算每个点能跳达最远的距离
            int[] canJumpTo = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                canJumpTo[i] = i + nums[i];
            }
            // 每次跳需从可达范围内跳去性价比最高的点
            int step = 0;
            int current = 0;
            while (current < nums.length - 1) {
                int nextRange = canJumpTo[current];
                if (nextRange >= nums.length - 1) {
                    break;
                }
                Integer nextStep = null;
                Integer nextMaxRange = null;
                for (int i = current + 1; i <= nextRange; i++) {
                    if (nextStep == null) {
                        nextStep = i;
                        nextMaxRange = canJumpTo[i];
                    } else {
                        if (nextMaxRange < canJumpTo[i]) {
                            nextMaxRange = canJumpTo[i];
                            nextStep = i;
                        }
                    }
                }
                if (nextStep == null) {
                    return -1;
                }
                step++;
                current = nextStep;
            }
            return step + 1;
        }
    }

    static class Solution_超时 {
        public int jump(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            // 使用minStep[i]表示到第i个点最少需要走的步数，minStep[i] = min(minStep[j]) + 1 并且要求 j + nums[j] >= i
            int[] minStep = new int[nums.length];
            for (int i = 1; i < nums.length; i++) {
                Integer min = null;
                for (int j = 0; j < i; j++) {
                    if (j + nums[j] >= i) {
                        if (min == null) {
                            min = minStep[j] + 1;
                        } else {
                            min = Math.min(min, minStep[j] + 1);
                        }
                    }
                }
                minStep[i] = min == null ? -1 : min;
            }
            return minStep[nums.length - 1];
        }
    }

}
