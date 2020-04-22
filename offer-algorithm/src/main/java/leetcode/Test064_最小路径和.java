package leetcode;

public class Test064_最小路径和 {

    public static void main(String[] args) {
        int[][] grip = new int[][]
                {
                        {1, 2},
                        {5, 6},
                        {1, 1}
                };
        System.out.println(new Solution().minPathSum(grip));
    }

    static class Solution {
        public int minPathSum(int[][] grid) {
            if (grid == null) {
                return 0;
            }
            int height = grid.length;
            int width = grid[0].length;
            int[][] min = new int[height][width];
            min[0][0] = grid[0][0];
            for (int x = 1; x < width; x++) {
                min[0][x] = grid[0][x] + min[0][x - 1];
            }
            for (int y = 1; y < height; y++) {
                min[y][0] = grid[y][0] + min[y - 1][0];
            }
            for (int y = 1; y < height; y++) {
                for (int x = 1; x < width; x++) {
                    int up = min[y - 1][x];
                    int left = min[y][x - 1];
                    min[y][x] = Math.min(up, left) + grid[y][x];
                }
            }
            return min[height - 1][width - 1];
        }
    }

}
