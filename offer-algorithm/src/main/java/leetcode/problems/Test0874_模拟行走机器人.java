package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class Test0874_模拟行走机器人 {

    public static void main(String[] args) {
        System.out.println(new Solution().robotSim(
                new int[]{4, -1, 3},
                new int[][]{}
        ));
        System.out.println(new Solution().robotSim(
                new int[]{4, -1, 4, -2, 4},
                new int[][]{{2, 4}}
        ));
        System.out.println(new Solution().robotSim(
                new int[]{6, -1, -1, 6},
                new int[][]{}
        ));
    }

    static class Solution {
        public int robotSim(int[] commands, int[][] obstacles) {
            Set<String> obstaclesMap = new HashSet<>();
            for (int[] obstacle : obstacles) {
                obstaclesMap.add(obstacle[0] + "," + obstacle[1]);
            }
            // 0-3对应上右下左
            int direction = 0;
            int y = 0;
            int x = 0;
            int max = 0;
            for (int command : commands) {
                if (command < 0) {
                    if (command == -1) {
                        // 右转
                        direction++;
                    } else if (command == -2) {
                        // 左转
                        direction--;
                    }
                    direction += 4;
                    direction %= 4;
                } else {
                    int dx = 0;
                    int dy = 0;
                    if (direction == 0) {
                        dy = 1;
                    } else if (direction == 1) {
                        dx = 1;
                    } else if (direction == 2) {
                        dy = -1;
                    } else if (direction == 3) {
                        dx = -1;
                    }
                    for (int step = 1; step <= command; step++) {
                        int nextX = x + dx;
                        int nextY = y + dy;
                        if (obstaclesMap.contains(nextX + "," + nextY)) {
                            break;
                        }
                        x = nextX;
                        y = nextY;
                    }
                }
                max = Math.max(max, x * x + y * y);
            }
            return max;
        }
    }
}
