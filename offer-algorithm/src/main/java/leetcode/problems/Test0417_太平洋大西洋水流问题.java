package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0417_太平洋大西洋水流问题 {

    public static void main(String[] args) {
        System.out.println(new Solution().pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}}));
        System.out.println(new Solution().pacificAtlantic(new int[][]{{2, 1}, {1, 2}}));
    }

    static class Solution {
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            int length = heights.length;
            int width = heights[0].length;
            // 标记能到太平洋的点
            boolean[][] canReachPacfic = new boolean[length][width];
            for (int x = 0; x < width; x++) {
                mark(0, x, canReachPacfic, heights);
            }
            for (int y = 0; y < length; y++) {
                mark(y, 0, canReachPacfic, heights);
            }
            // 标记能到大西洋的点
            boolean[][] canReachAtlantic = new boolean[length][width];
            for (int x = 0; x < width; x++) {
                mark(length - 1, x, canReachAtlantic, heights);
            }
            for (int y = 0; y < length; y++) {
                mark(y, width - 1, canReachAtlantic, heights);
            }
            // 返回结果
            List<List<Integer>> res = new ArrayList<>();
            for (int y = 0; y < length; y++) {
                for (int x = 0; x < width; x++) {
                    if (canReachPacfic[y][x] && canReachAtlantic[y][x]) {
                        List<Integer> point = new ArrayList<>();
                        point.add(y);
                        point.add(x);
                        res.add(point);
                    }
                }
            }
            return res;
        }

        private void mark(int y, int x, boolean[][] canReach, int[][] heights) {
            int length = canReach.length;
            int width = canReach[0].length;
            canReach[y][x] = true;
            int[][] moves = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] move : moves) {
                int nextY = y + move[0];
                int nextX = x + move[1];
                if (nextY < 0 || nextY >= length || nextX < 0 || nextX >= width) {
                    continue;
                }
                if (heights[y][x] > heights[nextY][nextX]) {
                    continue;
                }
                if (canReach[nextY][nextX]) {
                    continue;
                }
                mark(nextY, nextX, canReach, heights);
            }
        }
    }

}
