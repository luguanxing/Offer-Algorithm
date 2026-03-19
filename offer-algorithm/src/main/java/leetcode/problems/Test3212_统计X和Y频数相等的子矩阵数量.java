package leetcode.problems;

public class Test3212_统计X和Y频数相等的子矩阵数量 {

    public static void main(String[] args) {
        // grid = [["X","Y","."],["Y",".","."]]
        System.out.println(new Solution().numberOfSubmatrices(new char[][]{
                {'X', 'Y', '.'},
                {'Y', '.', '.'}
        }));
        // grid = [["X","X"],["X","Y"]]
        System.out.println(new Solution().numberOfSubmatrices(new char[][]{
                {'X', 'X'},
                {'X', 'Y'}
        }));
        //  grid = [[".","."],[".","."]]
        System.out.println(new Solution().numberOfSubmatrices(new char[][]{
                {'.', '.'},
                {'.', '.'}
        }));
    }

    static class Solution {
        public int numberOfSubmatrices(char[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            int res = 0;
            // 前缀和，xCount[y][x]表示以(0,0)为左上角，以(y,x)为右下角的矩阵中X的数量，yCount同理
            int[][] xCount = new int[height][width];
            int[][] yCount = new int[height][width];
            xCount[0][0] = grid[0][0] == 'X' ? 1 : 0;
            yCount[0][0] = grid[0][0] == 'Y' ? 1 : 0;
            for (int y = 1; y < height; y++) {
                xCount[y][0] = xCount[y - 1][0] + (grid[y][0] == 'X' ? 1 : 0);
                yCount[y][0] = yCount[y - 1][0] + (grid[y][0] == 'Y' ? 1 : 0);
                if (xCount[y][0] == yCount[y][0] && xCount[y][0] != 0) {
                    res++;
                }
            }
            for (int x = 1; x < width; x++) {
                xCount[0][x] = xCount[0][x - 1] + (grid[0][x] == 'X' ? 1 : 0);
                yCount[0][x] = yCount[0][x - 1] + (grid[0][x] == 'Y' ? 1 : 0);
                if (xCount[0][x] == yCount[0][x] && xCount[0][x] != 0) {
                    res++;
                }
            }
            for (int y = 1; y < height; y++) {
                for (int x = 1; x < width; x++) {
                    xCount[y][x] = xCount[y - 1][x] + xCount[y][x - 1] - xCount[y - 1][x - 1] + (grid[y][x] == 'X' ? 1 : 0);
                    yCount[y][x] = yCount[y - 1][x] + yCount[y][x - 1] - yCount[y - 1][x - 1] + (grid[y][x] == 'Y' ? 1 : 0);
                    if (xCount[y][x] == yCount[y][x] && xCount[y][x] != 0) {
                        res++;
                    }
                }
            }
            return res;
        }
    }

}
