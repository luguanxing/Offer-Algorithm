package leetcode.contest.week387;

public class Test100237_元素和小于等于k的子矩阵的数目 {

    public static void main(String[] args) {
        // grid = [[7,6,3],[6,6,1]], k = 18
        System.out.println(new Solution().countSubmatrices(new int[][]{{7, 6, 3}, {6, 6, 1}}, 18));
        // grid = [[7,2,9],[1,5,0],[2,6,6]], k = 20
        System.out.println(new Solution().countSubmatrices(new int[][]{{7, 2, 9}, {1, 5, 0}, {2, 6, 6}}, 20));
    }

    static class Solution {
        public int countSubmatrices(int[][] grid, int k) {
            int rows = grid.length;
            int cols = grid[0].length;
            int[][] prefixSum = new int[rows + 1][cols + 1];

            // 计算前缀和
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= cols; j++) {
                    prefixSum[i][j] = grid[i - 1][j - 1] + (prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1]);
                }
            }

            int count = 0;
            // 枚举所有以(0,0)为起点的子矩阵
            for (int y = 1; y <= rows; y++) {
                for (int x = 1; x <= cols; x++) {
                    // 检查所有可能的子矩阵
                    if (prefixSum[y][x] <= k) {
                        count++;
                    }
                }
            }

            return count;
        }
    }

}
