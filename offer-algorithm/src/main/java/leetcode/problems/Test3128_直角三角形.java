package leetcode.problems;

public class Test3128_直角三角形 {

    public static void main(String[] args) {
        // grid = [[0,1,0],[0,1,1],[0,1,0]]
        System.out.println(new Solution().numberOfRightTriangles(new int[][]{{0, 1, 0}, {0, 1, 1}, {0, 1, 0}}));
        // grid = [[1,0,0,0],[0,1,0,1],[1,0,0,0]]
        System.out.println(new Solution().numberOfRightTriangles(new int[][]{{1, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}}));
        // grid = [[1,0,1],[1,0,0],[1,0,0]]
        System.out.println(new Solution().numberOfRightTriangles(new int[][]{{1, 0, 1}, {1, 0, 0}, {1, 0, 0}}));
    }

    static class Solution {
        public long numberOfRightTriangles(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            // 计算行和列的1个数
            int[] rowCnt = new int[height];
            int[] columnCnt = new int[width];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (grid[y][x] == 1) {
                        rowCnt[y]++;
                    }
                }
            }
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    if (grid[y][x] == 1) {
                        columnCnt[x]++;
                    }
                }
            }
            // 枚举每一个点为中心，其它行和列的组合情况
            long ans = 0;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (grid[y][x] == 1) {
                        ans += (long) (rowCnt[y] - 1) * (columnCnt[x] - 1);
                    }
                }
            }
            return ans;
        }
    }

}
