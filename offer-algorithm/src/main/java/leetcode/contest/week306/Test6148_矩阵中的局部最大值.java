package leetcode.contest.week306;

public class Test6148_矩阵中的局部最大值 {

    public static void main(String[] args) {

    }

    static class Solution {
        public int[][] largestLocal(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            int[][] mat = new int[height][width];
            for (int y = 1; y < height - 1; y++) {
                for (int x = 1; x < width - 1; x++) {
                    int max = 0;
                    for (int i = y - 1; i <= y + 1; i++) {
                        for (int j = x - 1; j <= x + 1; j++) {
                            max = Math.max(max, grid[i][j]);
                        }
                    }
                    mat[y][x] = max;
                }
            }

            int[][] res = new int[height - 2][width - 2];
            for (int y = 0; y < res.length; y++) {
                for (int x = 0; x < res[0].length; x++) {
                    res[y][x] = mat[y + 1][x + 1];
                }
            }
            return res;
        }
    }

}
