package leetcode.problems;

public class Test0045_跳跃游戏II {

    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new Solution().jump(new int[]{3, 2, 1, 0, 5}));
        System.out.println(new Solution().jump(new int[]{0}));
    }

    static class Solution {
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
