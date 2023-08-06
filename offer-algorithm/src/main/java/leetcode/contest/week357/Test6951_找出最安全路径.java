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
        public int maximumSafenessFactor(List<List<Integer>> grid) {
            int n = grid.size();
            int[][] theivesDistance = getTheivesDistance(grid);
            // 使用二分试出能到终点的最大距离（满足条件的最大，二分右边界）
            int left = 0, right = n * 2;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (isOk(theivesDistance, mid)) {
                    // 能走到，把条件变严苛（增加控制的最短距离）
                    left = mid + 1;
                } else {
                    // 不能走到，把条件变宽松（减小控制的最短距离）
                    right = mid;
                }
            }
            return left - 1;
        }

        private int[][] getTheivesDistance(List<List<Integer>> grid) {
            // 从小偷bfs算出每个点最近的小偷距离
            int n = grid.size();
            int[][] ans = new int[n][n];
            for (int[] row : ans) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            for (int y = 0; y < grid.size(); y++) {
                for (int x = 0; x < grid.get(y).size(); x++) {
                    if (grid.get(y).get(x) == 1) {
                        Queue<int[]> queue = new ArrayDeque<>();
                        queue.add(new int[]{y, x, 0});
                        while (!queue.isEmpty()) {
                            int[] stat = queue.poll();
                            int py = stat[0];
                            int px = stat[1];
                            int distance = stat[2];
                            if (distance >= ans[py][px]) {
                                continue;
                            }
                            ans[py][px] = distance;
                            if (py - 1 >= 0) {
                                queue.add(new int[]{py - 1, px, distance + 1});
                            }
                            if (px - 1 >= 0) {
                                queue.add(new int[]{py, px - 1, distance + 1});
                            }
                            if (py + 1 < n) {
                                queue.add(new int[]{py + 1, px, distance + 1});
                            }
                            if (px + 1 < n) {
                                queue.add(new int[]{py, px + 1, distance + 1});
                            }
                        }
                    }
                }
            }
            return ans;
        }


        private boolean isOk(int[][] theivesDistance, int leastKeptDistance) {
            int n = theivesDistance.length;
            // 判断能否在每步不超过eachLeastKeptDistance的情况下走到终点
            boolean[][] visited = new boolean[n][n];
            visited[0][0] = true;
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{0, 0, theivesDistance[0][0]});
            while (!queue.isEmpty()) {
                int[] stat = queue.poll();
                int py = stat[0];
                int px = stat[1];
                int distance = stat[2];
                if (theivesDistance[py][px] < leastKeptDistance) {
                    continue;
                }
                if (py == n - 1 && px == n - 1) {
                    if (distance >= leastKeptDistance) {
                        return true;
                    }
                }
                if (py - 1 >= 0 && !visited[py - 1][px]) {
                    visited[py - 1][px] = true;
                    queue.add(new int[]{py - 1, px, Math.min(distance, theivesDistance[py - 1][px])});
                }
                if (px - 1 >= 0 && !visited[py][px - 1]) {
                    visited[py][px - 1] = true;
                    queue.add(new int[]{py, px - 1, Math.min(distance, theivesDistance[py][px - 1])});
                }
                if (py + 1 < n && !visited[py + 1][px]) {
                    visited[py + 1][px] = true;
                    queue.add(new int[]{py + 1, px, Math.min(distance, theivesDistance[py + 1][px])});
                }
                if (px + 1 < n && !visited[py][px + 1]) {
                    visited[py][px + 1] = true;
                    queue.add(new int[]{py, px + 1, Math.min(distance, theivesDistance[py][px + 1])});
                }
            }
            return false;
        }
    }


}
