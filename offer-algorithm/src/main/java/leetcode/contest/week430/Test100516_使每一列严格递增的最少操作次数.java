package leetcode.contest.week430;

public class Test100516_使每一列严格递增的最少操作次数 {

    public static void main(String[] args) {
        // grid = [[3,2],[1,3],[3,4],[0,1]]
        System.out.println(new Solution().minimumOperations(new int[][]{
                {3, 2},
                {1, 3},
                {3, 4},
                {0, 1},
        }));
        // grid = [[3,2,1],[2,1,0],[1,2,3]]
        System.out.println(new Solution().minimumOperations(new int[][]{
                {3, 2, 1},
                {2, 1, 0},
                {1, 2, 3},
        }));
    }

    static class Solution {
        public int minimumOperations(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            int cnt = 0;
            for (int x = 0; x < width; x++) {
                int current = grid[0][x];
                for (int y = 1; y < height; y++) {
                    if (grid[y][x] <= current) {
                        int diff = current - grid[y][x] + 1;
                        cnt += diff;
                        grid[y][x] += diff;
                    }
                    current = grid[y][x];
                }
            }
            return cnt;
        }
    }

}
