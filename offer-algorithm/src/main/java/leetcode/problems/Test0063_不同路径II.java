package leetcode.problems;

public class Test0063_不同路径II {

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePathsWithObstacles(
                new int[][]{{1}}
        ));
        System.out.println(new Solution().uniquePathsWithObstacles(
                new int[][]{{1, 0}}
        ));
        System.out.println(new Solution().uniquePathsWithObstacles(
                new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0},
                }
        ));
    }

    static class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int height = obstacleGrid.length;
            int width = obstacleGrid[0].length;
            int[][] state = new int[height][width];
            boolean upBlock = false;
            for (int y = 0; y < height; y++) {
                if (obstacleGrid[y][0] == 1 || upBlock) {
                    state[y][0] = 0;
                    upBlock = true;
                } else {
                    state[y][0] = 1;
                }
            }
            boolean leftBlock = false;
            for (int x = 0; x < width; x++) {
                if (obstacleGrid[0][x] == 1 || leftBlock) {
                    state[0][x] = 0;
                    leftBlock = true;
                } else {
                    state[0][x] = 1;
                }
            }
            for (int y = 1; y < height; y++) {
                for (int x = 1; x < width; x++) {
                    if (obstacleGrid[y][x] == 1) {
                        state[y][x] = 0;
                    } else {
                        state[y][x] = state[y - 1][x] + state[y][x - 1];
                    }
                }
            }
            return state[height - 1][width - 1];
        }
    }

}
