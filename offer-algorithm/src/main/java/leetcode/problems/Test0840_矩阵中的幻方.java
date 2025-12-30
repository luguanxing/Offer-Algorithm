package leetcode.problems;

public class Test0840_矩阵中的幻方 {

    public static void main(String[] args) {
        // grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]
        System.out.println(new Solution().numMagicSquaresInside(new int[][]{
                {4, 3, 8, 4},
                {9, 5, 1, 9},
                {2, 7, 6, 2}
        }));
        // grid = [[8]]
        System.out.println(new Solution().numMagicSquaresInside(new int[][]{
                {8}
        }));
    }

    static class Solution {
        public int numMagicSquaresInside(int[][] grid) {
            int cnt = 0;
            for (int i = 0; i <= grid.length - 3; i++) {
                for (int j = 0; j <= grid[0].length - 3; j++) {
                    if (isMagicSquare(grid, i, j)) {
                        cnt++;
                    }
                }
            }
            return cnt;
        }

        private boolean isMagicSquare(int[][] grid, int col, int row) {
            int sum = grid[col][row] + grid[col][row + 1] + grid[col][row + 2];
            // 判断行
            for (int i = col; i < col + 3; i++) {
                if (grid[i][row] + grid[i][row + 1] + grid[i][row + 2] != sum) {
                    return false;
                }
            }
            // 判断列
            for (int j = row; j < row + 3; j++) {
                if (grid[col][j] + grid[col + 1][j] + grid[col + 2][j] != sum) {
                    return false;
                }
            }
            // 判断对角线
            if (grid[col][row] + grid[col + 1][row + 1] + grid[col + 2][row + 2] != sum) {
                return false;
            }
            if (grid[col][row + 2] + grid[col + 1][row + 1] + grid[col + 2][row] != sum) {
                return false;
            }
            // 判断数字是否在1-9之间且不重复
            boolean[] seen = new boolean[10];
            for (int i = col; i < col + 3; i++) {
                for (int j = row; j < row + 3; j++) {
                    int num = grid[i][j];
                    if (num < 1 || num > 9 || seen[num]) {
                        return false;
                    }
                    seen[num] = true;
                }
            }
            return true;
        }
    }

}
