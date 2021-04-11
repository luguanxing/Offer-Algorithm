package leetcode.contest.week236;

import java.util.Arrays;

public class Test5728_最少侧跳次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minSideJumps(new int[]{0, 1, 2, 3, 0}));
        System.out.println(new Solution().minSideJumps(new int[]{0, 1, 1, 3, 3, 0}));
        System.out.println(new Solution().minSideJumps(new int[]{0, 2, 1, 0, 3, 0}));
        System.out.println(new Solution().minSideJumps(new int[]{0, 1, 2, 3, 1, 2, 1, 0}));
        System.out.println(new Solution().minSideJumps(new int[]{0, 2, 3, 0}));
        System.out.println(new Solution().minSideJumps(new int[]{0, 2, 2, 1, 0, 3, 0, 3, 0, 1, 3, 1, 1, 0, 1, 3, 1, 1, 1, 0, 2, 0, 0, 3, 3, 0, 3, 2, 2, 0, 0, 3, 3, 3, 0, 0, 2, 0, 0, 3, 3, 0, 3, 3, 0, 0, 3, 1, 0, 1, 0, 2, 3, 1, 1, 0, 3, 3, 0, 3, 1, 3, 0, 2, 2, 0, 1, 3, 0, 1, 0, 3, 0, 1, 3, 1, 2, 2, 0, 0, 3, 0, 1, 3, 2, 3, 2, 1, 0, 3, 2, 2, 0, 3, 3, 0, 3, 0, 0, 1, 0, 2, 0, 0, 0, 2, 1, 2, 0, 2, 2, 3, 3, 3, 0, 0, 1, 1, 3, 0, 0, 0, 1, 2, 2, 1, 2, 1, 3, 2, 2, 3, 1, 3, 0, 1, 1, 1, 3, 0, 0, 0, 2, 0, 2, 0, 3, 1, 2, 3, 3, 2, 2, 2, 0, 0, 0, 1, 0, 0, 0, 0, 3, 0, 0, 0, 3, 0, 2, 1, 2, 3, 1, 0, 3, 3, 2, 0, 1, 1, 0, 1, 0, 2, 2, 2, 1, 3, 0, 3, 0, 2, 1, 1, 3, 1, 0, 1, 2, 2, 0, 2, 2, 0, 0, 3, 3, 1, 3, 0, 1, 1, 0, 3, 0, 2, 1, 2, 2, 0, 0, 0, 1, 2, 3, 1, 2, 1, 1, 2, 2, 1, 1, 0, 2, 3, 3, 3, 0, 2, 3, 2, 0, 0, 0, 1, 0, 2, 2, 0, 0, 2, 0, 2, 0, 1, 1, 0, 3, 1, 3, 3, 0, 1, 0, 3, 0, 3, 1, 2, 3, 1, 0, 0, 2, 3, 2, 0, 0, 3, 1, 2, 3, 2, 2, 3, 1, 3, 3, 2, 0, 1, 3, 0, 3, 2, 2, 3, 2, 1, 2, 2, 0, 3, 2, 0, 2, 1, 2, 2, 3, 1, 3, 2, 2, 0, 0, 1, 0, 3, 1, 3, 3, 0, 0, 2, 2, 2, 2, 0, 1, 0, 3, 1, 3, 3, 3, 0, 2, 3, 2, 0, 3, 3, 3, 3, 3, 3, 2, 2, 1, 1, 0, 3, 1, 3, 2, 3, 0, 0, 0, 2, 1, 1, 3, 1, 3, 2, 1, 3, 0, 1, 1, 3, 2, 2, 1, 0, 0, 3, 2, 1, 3, 2, 3, 3, 2, 1, 2, 0, 2, 2, 0, 2, 2, 3, 2, 0, 2, 3, 3, 1, 1, 2, 0, 1, 1, 1, 2, 3, 2, 1, 2, 1, 0, 2, 3, 1, 1, 3, 3, 2, 0, 1, 3, 2, 3, 3, 0, 1, 2, 3, 2, 1, 1, 2, 1, 0, 0, 1, 0, 3, 1, 1, 1, 0, 2, 0, 2, 2, 3, 0, 1, 0, 2, 0, 0, 3, 1, 1, 2, 0, 0, 2, 1, 1, 0, 2, 2, 2, 3, 1, 2, 0, 1, 2, 0, 1, 2, 1, 2, 3, 1, 1, 1, 1, 0, 3, 3, 2, 1, 0, 0, 1, 0, 3, 0, 0, 2, 2, 2, 1, 1, 2, 1, 2, 1, 1, 2, 0, 3, 1, 3, 2, 1, 2, 2, 3, 1, 0, 1, 1, 1, 0, 0, 0, 1, 3, 3, 2, 2, 1, 2, 0, 0, 0, 3, 1, 3, 2, 3, 1, 3, 2, 3, 1, 3, 2, 0, 1, 2, 1, 1, 2, 1, 3, 0, 1, 1, 1, 3, 3, 1, 0, 0, 3, 2, 2, 3, 1, 1, 0, 3, 0, 0, 3, 0, 3, 1, 2, 0, 2, 3, 2, 3, 0, 3, 2, 3, 0, 2, 2, 3, 0, 3, 3, 3, 1, 0, 1, 2, 2, 0, 3, 3, 1, 3, 2, 2, 3, 2, 1, 1, 0, 0, 0, 0, 2, 1, 0, 1, 1, 1, 1, 0, 3, 0, 1, 0, 0, 1, 0, 2, 0, 0, 1, 2, 0, 0, 0, 3, 3, 1, 0, 3, 2, 1, 2, 3, 2, 0, 3, 3, 0, 2, 3, 1, 1, 0, 2, 2, 3, 3, 0, 1, 0, 0, 3, 1, 2, 3, 0, 1, 2, 3, 2, 2, 0, 1, 2, 0, 3, 0, 3, 0, 1, 1, 3, 2, 2, 2, 3, 1, 2, 0, 0, 3, 0, 2, 3, 3, 1, 0, 3, 3, 0, 0, 0, 3, 2, 1, 1, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 0, 0, 1, 1, 1, 1, 2, 2, 0, 1, 0, 2, 2, 0, 2, 1, 3, 1, 1, 1, 2, 1, 1, 0, 3, 1, 0, 2, 3, 0, 1, 2, 0, 0, 3, 1, 2, 3, 0, 0, 3, 1, 0, 2, 2, 0, 1, 1, 2, 2, 1, 3, 1, 2, 1, 0, 1, 2, 3, 2, 3, 0, 3, 1, 3, 0, 2, 0, 3, 1, 1, 0, 3, 2, 0, 3, 0, 2, 0, 0, 3, 3, 1, 1, 1, 0, 0, 1, 1, 1, 2, 3, 1, 3, 1, 2, 0, 0, 3, 3, 0, 3, 3, 0, 0, 0, 3, 3, 0, 3, 3, 2, 3, 3, 3, 3, 1, 1, 1, 3, 1, 1, 3, 3, 1, 0, 0, 3, 1, 2, 0, 2, 0, 3, 0, 2, 1, 0, 1, 0, 2, 3, 3, 3, 2, 3, 3, 2, 0, 0, 0, 2, 2, 3, 0, 0, 3, 0, 2, 3, 0, 1, 3, 2, 1, 2, 0, 1, 3, 2, 2, 0, 1, 1, 3, 3, 0, 2, 3, 0, 3, 3, 1, 2, 3, 2, 1, 0, 2, 3, 2, 2, 2, 3, 0, 1, 1, 3, 1, 0, 2, 1, 3, 2, 2, 2, 3, 3, 1, 1, 1, 3, 2, 3, 1, 0, 2, 3, 0, 2, 3, 0, 1, 3, 3, 1, 1, 1, 1, 0, 1, 1, 2, 2, 0, 2, 1, 1, 0, 1, 0, 3, 1, 1, 1, 3, 3, 2, 1, 2, 3, 2, 2, 3, 1, 0, 3, 2, 0, 1, 0, 1, 3, 3, 3, 0, 3, 3, 2, 3, 1, 2, 2, 1, 1, 0, 0, 3, 0}));
    }

    static class Solution {
        public int minSideJumps(int[] obstacles) {
            // dpk[i]表示第i格跳至第k道时耗时最少结果
            int[] dp1 = new int[obstacles.length];
            int[] dp2 = new int[obstacles.length];
            int[] dp3 = new int[obstacles.length];
            Arrays.fill(dp1, Integer.MAX_VALUE / 2);
            Arrays.fill(dp2, Integer.MAX_VALUE / 2);
            Arrays.fill(dp3, Integer.MAX_VALUE / 2);
            dp1[0] = 1;
            dp2[0] = 0;
            dp3[0] = 1;
            for (int i = 1; i < obstacles.length; i++) {
                // 先更新直行结果
                if (obstacles[i] != 1) {
                    dp1[i] = dp1[i - 1];
                }
                if (obstacles[i] != 2) {
                    dp2[i] = dp2[i - 1];
                }
                if (obstacles[i] != 3) {
                    dp3[i] = dp3[i - 1];
                }
                // 再更新侧跳结果
                if (obstacles[i] != 1) {
                    dp1[i] = Math.min(dp1[i], dp2[i] + 1);
                    dp1[i] = Math.min(dp1[i], dp3[i] + 1);
                }
                if (obstacles[i] != 2) {
                    dp2[i] = Math.min(dp2[i], dp1[i] + 1);
                    dp2[i] = Math.min(dp2[i], dp3[i] + 1);
                }
                if (obstacles[i] != 3) {
                    dp3[i] = Math.min(dp3[i], dp1[i] + 1);
                    dp3[i] = Math.min(dp3[i], dp2[i] + 1);
                }
            }
            return Math.min(dp1[obstacles.length - 1], Math.min(dp2[obstacles.length - 1], dp3[obstacles.length - 1]));
        }
    }

    static class Solution_递归 {
        int minRes = Integer.MAX_VALUE;

        public int minSideJumps(int[] obstacles) {
            check(0, 2, 0, obstacles);
            return minRes;
        }

        public void check(int index, int curPos, int curRes, int[] obstacles) {
            if (index == obstacles.length - 1) {
                minRes = Math.min(minRes, curRes);
            }
            int curObstacle = obstacles[index];
            int nextObstacle = obstacles[index + 1];
            if (nextObstacle == 1 && curPos == 1) {
                if (curObstacle != 2) {
                    check(index + 1, 2, curRes + 1, obstacles);
                }
                if (curObstacle != 3) {
                    check(index + 1, 3, curRes + 1, obstacles);
                }
            } else if (nextObstacle == 2 && curPos == 2) {
                if (curObstacle != 1) {
                    check(index + 1, 1, curRes + 1, obstacles);
                }
                if (curObstacle != 3) {
                    check(index + 1, 3, curRes + 1, obstacles);
                }
            } else if (nextObstacle == 3 && curPos == 3) {
                if (curObstacle != 1) {
                    check(index + 1, 1, curRes + 1, obstacles);
                }
                if (curObstacle != 2) {
                    check(index + 1, 2, curRes + 1, obstacles);
                }
            } else {
                check(index + 1, curPos, curRes, obstacles);
            }
        }
    }

}
