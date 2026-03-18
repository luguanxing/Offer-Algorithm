package leetcode.problems;

public class Test3070_元素和小于等于k的子矩阵的数目 {

    public static void main(String[] args) {
        // grid = [[7,6,3],[6,6,1]], k = 18
        System.out.println(new Solution().countSubmatrices(new int[][]{
                {7, 6, 3},
                {6, 6, 1}
        }, 18));
        // grid = [[7,2,9],[1,5,0],[2,6,6]], k = 20
        System.out.println(new Solution().countSubmatrices(new int[][]{
                {7, 2, 9},
                {1, 5, 0},
                {2, 6, 6}
        }, 20));
    }

    static class Solution {
        public int countSubmatrices(int[][] grid, int k) {
            int height = grid.length;
            int width = grid[0].length;
            int[][] sum = new int[height + 1][width + 1];
            for (int y = 0; y < height; y++) {
                sum[y][0] = 0;
            }
            for (int x = 0; x < width; x++) {
                sum[0][x] = 0;
            }
            int cnt = 0;
            for (int y = 1; y <= height; y++) {
                for (int x = 1; x <= width; x++) {
                    sum[y][x] = sum[y - 1][x] + sum[y][x - 1] - sum[y - 1][x - 1] + grid[y - 1][x - 1];
                    if (sum[y][x] <= k) {
                        cnt++;
                    }
                }
            }
            return cnt;
        }
    }

}
