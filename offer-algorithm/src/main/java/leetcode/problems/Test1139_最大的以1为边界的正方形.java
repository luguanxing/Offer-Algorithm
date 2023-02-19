package leetcode.problems;

public class Test1139_最大的以1为边界的正方形 {

    public static void main(String[] args) {
        System.out.println(new Solution().largest1BorderedSquare(new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        }));
        System.out.println(new Solution().largest1BorderedSquare(new int[][]{{1, 1, 0, 0}}));
        System.out.println(new Solution().largest1BorderedSquare(new int[][]{
                {1, 1},
                {1, 0}
        }));
        System.out.println(new Solution().largest1BorderedSquare(new int[][]{
                {0, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 0, 1, 1, 1},
                {0, 1, 1, 1, 1, 0, 1, 1}
        }));
    }

    static class Solution {
        public int largest1BorderedSquare(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            int max = 0;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    for (int len = 0; y + len < height && x + len < width; len++) {
                        boolean isLenOk = true;
                        for (int i = 0; i <= len; i++) {
                            if (grid[y + i][x] * grid[y][x + i] * grid[y + len][x + i] * grid[y + i][x + len] != 1) {
                                isLenOk = false;
                                break;
                            }
                        }
                        if (isLenOk) {
                            max = Math.max(max, len + 1);
                        }
                    }
                }
            }
            return max * max;
        }
    }

}
