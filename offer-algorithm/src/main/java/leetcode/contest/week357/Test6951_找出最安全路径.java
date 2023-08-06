package leetcode.contest.week357;

import java.util.*;

public class Test6951_找出最安全路径 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumSafenessFactor(Arrays.asList(
                Arrays.asList(0, 1, 1),
                Arrays.asList(0, 1, 1),
                Arrays.asList(0, 0, 0)
        )));
        System.out.println(new Solution().maximumSafenessFactor(Arrays.asList(
                Arrays.asList(1, 0, 0),
                Arrays.asList(0, 0, 0),
                Arrays.asList(0, 0, 1)
        )));
        System.out.println(new Solution().maximumSafenessFactor(Arrays.asList(
                Arrays.asList(0, 0, 1),
                Arrays.asList(0, 0, 0),
                Arrays.asList(0, 0, 0)
        )));
        System.out.println(new Solution().maximumSafenessFactor(Arrays.asList(
                Arrays.asList(0, 0, 0, 1),
                Arrays.asList(0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0),
                Arrays.asList(1, 0, 0, 0)
        )));
        System.out.println(new Solution().maximumSafenessFactor(Arrays.asList(
                Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1),
                Arrays.asList(0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0),
                Arrays.asList(0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0),
                Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0),
                Arrays.asList(0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0),
                Arrays.asList(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0),
                Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0),
                Arrays.asList(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
                Arrays.asList(0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                Arrays.asList(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0)
        )));
    }

    static class Solution {
        private final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public int maximumSafenessFactor(List<List<Integer>> grid) {
            int n = grid.size();
            int globalMaxSafety = 0;

            List<int[]> thieves = getThieves(grid);

            Queue<State> queue = new LinkedList<>();
            queue.add(new State(0, 0, Integer.MAX_VALUE, 0));

            int[][] maxSafetyAt = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(maxSafetyAt[i], Integer.MIN_VALUE);
            }

            int[][] thievesDistance = new int[n][n];
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    int minSafety = Integer.MAX_VALUE;
                    for (int[] thief : thieves) {
                        minSafety = Math.min(minSafety, Math.abs(y - thief[0]) + Math.abs(x - thief[1]));
                    }
                    thievesDistance[y][x] = minSafety;
                }
            }

            while (!queue.isEmpty()) {
                State curr = queue.poll();
                int x = curr.x, y = curr.y;

                if (curr.steps > 3 * n) {
                    continue;
                }

                int currSafety = thievesDistance[y][x];
                curr.safety = Math.min(curr.safety, currSafety);

                // 剪枝
                if (curr.safety <= maxSafetyAt[x][y] || curr.safety <= globalMaxSafety) {
                    continue;
                }
                maxSafetyAt[x][y] = curr.safety;

                if (x == n - 1 && y == n - 1) {
                    globalMaxSafety = Math.max(globalMaxSafety, curr.safety);
                    continue;
                }

                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
                        if (grid.get(newY).get(newX) == 0) {
                            queue.add(new State(newX, newY, curr.safety, curr.steps + 1));
                        }
                    }
                }
            }

            return globalMaxSafety;
        }

        private List<int[]> getThieves(List<List<Integer>> grid) {
            List<int[]> thieves = new ArrayList<>();
            for (int i = 0; i < grid.size(); i++) {
                for (int j = 0; j < grid.get(0).size(); j++) {
                    if (grid.get(i).get(j) == 1) {
                        thieves.add(new int[]{i, j});
                    }
                }
            }
            return thieves;
        }

        class State {
            int x, y;
            int safety;
            int steps;

            State(int x, int y, int safety, int steps) {
                this.x = x;
                this.y = y;
                this.safety = safety;
                this.steps = steps;
            }
        }
    }


}
