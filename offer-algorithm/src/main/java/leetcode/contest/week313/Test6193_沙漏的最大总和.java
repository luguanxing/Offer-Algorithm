package leetcode.contest.week313;

public class Test6193_沙漏的最大总和 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxSum(new int[][]{
                {6, 2, 1, 3}, {4, 2, 1, 5}, {9, 2, 8, 7}, {4, 1, 2, 9}
        }));
        System.out.println(new Solution().maxSum(new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        }));
    }

    static class Solution {
        public int maxSum(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            int max = 0;
            for (int y = 1; y < height - 1; y++) {
                for (int x = 1; x < width - 1; x++) {
                    int sum = 0;
                    sum += grid[y - 1][x - 1] + grid[y - 1][x] + grid[y - 1][x + 1];
                    sum += grid[y][x];
                    sum += grid[y + 1][x - 1] + grid[y + 1][x] + grid[y + 1][x + 1];
                    max = Math.max(max, sum);
                }
            }
            return max;
        }
    }

}
