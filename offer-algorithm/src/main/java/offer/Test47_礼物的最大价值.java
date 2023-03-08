package offer;

public class Test47_礼物的最大价值 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxValue(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
    }

    static class Solution {
        public int maxValue(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int up = y == 0 ? 0 : grid[y - 1][x];
                    int left = x == 0 ? 0 : grid[y][x - 1];
                    grid[y][x] += Math.max(up, left);
                }
            }
            return grid[height - 1][width - 1];
        }
    }

}
