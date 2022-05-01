package leetcode.contest.week289;

import java.util.Arrays;

public class Test6072_转角路径的乘积中最多能有几个尾随零 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxTrailingZeros(new int[][]{{23, 17, 15, 3, 20}, {8, 1, 20, 27, 11}, {9, 4, 6, 2, 21}, {40, 9, 1, 10, 6}, {22, 7, 4, 5, 3}}));
        System.out.println(new Solution().maxTrailingZeros(new int[][]{{4, 3, 2}, {7, 6, 1}, {8, 8, 8}}));
        System.out.println(new Solution().maxTrailingZeros(new int[][]{{1, 5, 2, 4, 25}}));
    }

    static class Solution {
        public int maxTrailingZeros(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            Point[][] upPoints = new Point[height][width];
            Point[][] leftPoints = new Point[height][width];
            for (int x = 0; x < width; x++) {
                int num = grid[0][x];
                int cnt5 = 0;
                int cnt2 = 0;
                while (num % 5 == 0) {
                    num /= 5;
                    cnt5++;
                }
                while (num % 2 == 0) {
                    num /= 2;
                    cnt2++;
                }
                upPoints[0][x] = new Point(cnt2, cnt5);
            }
            for (int y = 1; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int num = grid[y][x];
                    int cnt5 = 0;
                    int cnt2 = 0;
                    while (num % 5 == 0) {
                        num /= 5;
                        cnt5++;
                    }
                    while (num % 2 == 0) {
                        num /= 2;
                        cnt2++;
                    }
                    upPoints[y][x] = new Point(cnt2 + upPoints[y - 1][x].cnt2, cnt5 + upPoints[y - 1][x].cnt5);
                }
            }
            for (int y = 0; y < height; y++) {
                int num = grid[y][0];
                int cnt5 = 0;
                int cnt2 = 0;
                while (num % 5 == 0) {
                    num /= 5;
                    cnt5++;
                }
                while (num % 2 == 0) {
                    num /= 2;
                    cnt2++;
                }
                leftPoints[y][0] = new Point(cnt2, cnt5);
            }
            for (int x = 1; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    int num = grid[y][x];
                    int cnt5 = 0;
                    int cnt2 = 0;
                    while (num % 5 == 0) {
                        num /= 5;
                        cnt5++;
                    }
                    while (num % 2 == 0) {
                        num /= 2;
                        cnt2++;
                    }
                    leftPoints[y][x] = new Point(cnt2 + leftPoints[y][x - 1].cnt2, cnt5 + leftPoints[y][x - 1].cnt5);
                }
            }
            int res = 0;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int num = grid[y][x];
                    int cnt5 = 0;
                    int cnt2 = 0;
                    while (num % 5 == 0) {
                        num /= 5;
                        cnt5++;
                    }
                    while (num % 2 == 0) {
                        num /= 2;
                        cnt2++;
                    }
                    // 在(y,x)处可能转折，有上下，左右，上右，上左，下右，下左六个选择，找出最多的0
                    int upDown = Math.min(upPoints[height - 1][x].cnt2, upPoints[height - 1][x].cnt5);
                    int leftRight = Math.min(leftPoints[y][width - 1].cnt2, leftPoints[y][width - 1].cnt5);
                    int upRight = Math.min(
                            upPoints[y][x].cnt2 + (leftPoints[y][width - 1].cnt2 - (x == 0 ? 0 : leftPoints[y][x - 1].cnt2)) - cnt2,
                            upPoints[y][x].cnt5 + (leftPoints[y][width - 1].cnt5 - (x == 0 ? 0 : leftPoints[y][x - 1].cnt5)) - cnt5
                    );
                    int upLeft = Math.min(
                            upPoints[y][x].cnt2 + leftPoints[y][x].cnt2 - cnt2,
                            upPoints[y][x].cnt5 + leftPoints[y][x].cnt5 - cnt5
                    );
                    int downRight = Math.min(
                            (upPoints[height - 1][x].cnt2 - (y == 0 ? 0 : upPoints[y - 1][x].cnt2)) + (leftPoints[y][width - 1].cnt2 - (x == 0 ? 0 : leftPoints[y][x - 1].cnt2)) - cnt2,
                            (upPoints[height - 1][x].cnt5 - (y == 0 ? 0 : upPoints[y - 1][x].cnt5)) + (leftPoints[y][width - 1].cnt5 - (x == 0 ? 0 : leftPoints[y][x - 1].cnt5)) - cnt5
                    );
                    int downLeft = Math.min(
                            (upPoints[height - 1][x].cnt2 - (y == 0 ? 0 : upPoints[y - 1][x].cnt2)) + leftPoints[y][x].cnt2 - cnt2,
                            (upPoints[height - 1][x].cnt5 - (y == 0 ? 0 : upPoints[y - 1][x].cnt5)) + leftPoints[y][x].cnt5 - cnt5
                    );
                    res = Math.max(res, Arrays.stream(new int[]{upDown, leftRight, upRight, upLeft, downRight, downLeft}).max().orElse(0));
                }
            }
            return res;
        }

        class Point {
            int cnt2;
            int cnt5;

            public Point(int cnt2, int cnt5) {
                this.cnt2 = cnt2;
                this.cnt5 = cnt5;
            }
        }
    }

}
