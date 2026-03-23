package leetcode.problems;

public class Test1594_矩阵的最大非负积 {

    public static void main(String[] args) {
        // grid = [[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]]
        System.out.println(new Solution().maxProductPath(new int[][]{
                {-1, -2, -3},
                {-2, -3, -3},
                {-3, -3, -2}
        }));
        // grid = [[1,-2,1],[1,-2,1],[3,-4,1]]
        System.out.println(new Solution().maxProductPath(new int[][]{
                {1, -2, 1},
                {1, -2, 1},
                {3, -4, 1}
        }));
        // grid = [[1,3],[0,-4]]
        System.out.println(new Solution().maxProductPath(new int[][]{
                {1, 3},
                {0, -4}
        }));
    }

    static class Solution {
        public int maxProductPath(int[][] grid) {
            int MOD = 1000000007;
            int height = grid.length;
            int width = grid[0].length;
            long[][] dp_max = new long[height][width];
            long[][] dp_min = new long[height][width];
            dp_max[0][0] = grid[0][0];
            dp_min[0][0] = grid[0][0];
            for (int i = 1; i < height; i++) {
                dp_max[i][0] = dp_max[i - 1][0] * grid[i][0];
                dp_min[i][0] = dp_min[i - 1][0] * grid[i][0];
            }
            for (int j = 1; j < width; j++) {
                dp_max[0][j] = dp_max[0][j - 1] * grid[0][j];
                dp_min[0][j] = dp_min[0][j - 1] * grid[0][j];
            }
            for (int y = 1; y < height; y++) {
                for (int x = 1; x < width; x++) {
                    long fromTopMax = dp_max[y - 1][x] * grid[y][x];
                    long fromLeftMax = dp_max[y][x - 1] * grid[y][x];
                    long fromTopMin = dp_min[y - 1][x] * grid[y][x];
                    long fromLeftMin = dp_min[y][x - 1] * grid[y][x];
                    dp_max[y][x] = Math.max(Math.max(fromTopMax, fromLeftMax), Math.max(fromTopMin, fromLeftMin));
                    dp_min[y][x] = Math.min(Math.min(fromTopMax, fromLeftMax), Math.min(fromTopMin, fromLeftMin));
                }
            }
            return dp_max[height - 1][width - 1] < 0 ? -1 : (int) (dp_max[height - 1][width - 1] % MOD);
        }
    }

}
