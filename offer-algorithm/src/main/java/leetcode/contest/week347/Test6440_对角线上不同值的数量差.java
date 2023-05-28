package leetcode.contest.week347;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test6440_对角线上不同值的数量差 {

    public static void main(String[] args) {
        int[][] ans1 = new Solution().differenceOfDistinctValues(
                new int[][]{
                        {1, 2, 3},
                        {3, 1, 5},
                        {3, 2, 1},
                }
        );
        for (int[] r1 : ans1) {
            System.out.println(Arrays.toString(r1));
        }
    }

    static class Solution {
        public int[][] differenceOfDistinctValues(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            int[][] ans = new int[height][width];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    Set<Integer> leftTop = getLeftTop(grid, y - 1, x - 1);
                    Set<Integer> rightBotton = getRightBotton(grid, y + 1, x + 1);
                    ans[y][x] = Math.abs(leftTop.size() - rightBotton.size());
                }
            }
            return ans;
        }

        private Set<Integer> getLeftTop(int[][] grid, int y, int x) {
            Set<Integer> set = new HashSet<>();
            while (y >= 0 && x >= 0) {
                set.add(grid[y][x]);
                y--;
                x--;
            }
            return set;
        }

        private Set<Integer> getRightBotton(int[][] grid, int y, int x) {
            Set<Integer> set = new HashSet<>();
            while (y < grid.length && x < grid[0].length) {
                set.add(grid[y][x]);
                y++;
                x++;
            }
            return set;
        }
    }

}
