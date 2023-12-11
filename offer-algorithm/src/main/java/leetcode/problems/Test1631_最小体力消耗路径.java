package leetcode.problems;

import java.util.*;

public class Test1631_最小体力消耗路径 {

    public static void main(String[] args) {
        // heights = [[1,2,2],[3,8,2],[5,3,5]]
        System.out.println(new Solution().minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}));
        // heights = [[1,2,3],[3,8,4],[5,3,5]]
        System.out.println(new Solution().minimumEffortPath(new int[][]{{1, 2, 3}, {3, 8, 4}, {5, 3, 5}}));
        // [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
        System.out.println(new Solution().minimumEffortPath(new int[][]{{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}}));
        // [[4,3,4,10,5,5,9,2],[10,8,2,10,9,7,5,6],[5,8,10,10,10,7,4,2],[5,1,3,1,1,3,1,9],[6,4,10,6,10,9,4,6]]
        System.out.println(new Solution().minimumEffortPath(new int[][]{{4,3,4,10,5,5,9,2},{10,8,2,10,9,7,5,6},{5,8,10,10,10,7,4,2},{5,1,3,1,1,3,1,9},{6,4,10,6,10,9,4,6}}));
    }

    static class Solution {
        public int minimumEffortPath(int[][] heights) {
            int maxHeight = Integer.MIN_VALUE;
            int minHeight = Integer.MAX_VALUE;
            for (int[] height : heights) {
                maxHeight = Math.max(maxHeight, Arrays.stream(height).max().getAsInt());
                minHeight = Math.min(minHeight, Arrays.stream(height).min().getAsInt());
            }
            int left = 0;
            int right = maxHeight - minHeight;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (canReach(heights, mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean canReach(int[][] heights, int limit) {
            // 使用BFS判断高度差不超过limit能否到达右下角
            int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int height = heights.length;
            int width = heights[0].length;
            boolean[][] visited = new boolean[height][width];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int currentY = current[0];
                int currentX = current[1];
                if (currentY == height - 1 && currentX == width - 1) {
                    return true;
                }
                for (int[] direction : directions) {
                    int nextY = currentY + direction[0];
                    int nextX = currentX + direction[1];
                    if (nextY < 0 || nextY >= height || nextX < 0 || nextX >= width) {
                        continue;
                    }
                    if (visited[nextY][nextX]) {
                        continue;
                    }
                    if (Math.abs(heights[nextY][nextX] - heights[currentY][currentX]) > limit) {
                        continue;
                    }
                    queue.add(new int[]{nextY, nextX});
                    visited[nextY][nextX] = true;
                }
            }
            return false;
        }
    }

}
