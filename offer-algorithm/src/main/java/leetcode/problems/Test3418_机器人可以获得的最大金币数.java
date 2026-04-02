package leetcode.problems;

public class Test3418_机器人可以获得的最大金币数 {

    public static void main(String[] args) {
        // coins = [[0,1,-1],[1,-2,3],[2,-3,4]]
        System.out.println(new Solution().maximumAmount(new int[][]{
                {0, 1, -1},
                {1, -2, 3},
                {2, -3, 4}
        }));
        // coins = [[10,10,10],[10,10,10]]
        System.out.println(new Solution().maximumAmount(new int[][]{
                {10, 10, 10},
                {10, 10, 10}
        }));
        // coins = [[-7,12,12,13],[-6,19,19,-6],[9,-2,-10,16],[-4,14,-10,-9]]
        System.out.println(new Solution().maximumAmount(new int[][]{
                {-7, 12, 12, 13},
                {-6, 19, 19, -6},
                {9, -2, -10, 16},
                {-4, 14, -10, -9}
        }));
    }

    static class Solution {
        public int maximumAmount(int[][] coins) {
            int height = coins.length;
            int width = coins[0].length;
            // dp[c][y][x]：从(0,0)出发，走到(y,x)位置剩余c次机会时，机器人可以获得的最大金币数
            int[][][] dp = new int[3][height][width];
            int NEG = Integer.MIN_VALUE / 4;
            for (int c = 0; c < 3; c++) {
                for (int y = 0; y < height; y++) {
                    for (int x = 0; x < width; x++) {
                        dp[c][y][x] = NEG;
                    }
                }
            }
            if (coins[0][0] >= 0) {
                dp[2][0][0] = coins[0][0];
            } else {
                dp[2][0][0] = coins[0][0]; // 不使用机会
                dp[1][0][0] = 0;           // 使用一次机会感化
            }
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (y == 0 && x == 0) {
                        continue;
                    }
                    int coin = coins[y][x];
                    int fromUp2 = y > 0 ? dp[2][y - 1][x] : NEG;
                    int fromLeft2 = x > 0 ? dp[2][y][x - 1] : NEG;
                    int fromUp1 = y > 0 ? dp[1][y - 1][x] : NEG;
                    int fromLeft1 = x > 0 ? dp[1][y][x - 1] : NEG;
                    int fromUp0 = y > 0 ? dp[0][y - 1][x] : NEG;
                    int fromLeft0 = x > 0 ? dp[0][y][x - 1] : NEG;
                    if (coin >= 0) {
                        // 遇到金币：直接加上金币数，机会不变
                        dp[2][y][x] = Math.max(fromUp2, fromLeft2) + coin;
                        dp[1][y][x] = Math.max(fromUp1, fromLeft1) + coin;
                        dp[0][y][x] = Math.max(fromUp0, fromLeft0) + coin;
                    } else {
                        // 遇到强盗：有机会则扣除机会不加coin；无机会则扣除coin
                        // 有2次机会的要么不用机会，要么用掉1次机会剩1次机会
                        // 有1次机会的要么不用机会，要么用掉1次机会剩0次机会
                        // 没有机会只能扣除coin
                        dp[2][y][x] = Math.max(fromUp2, fromLeft2) + coin;
                        dp[1][y][x] = Math.max(
                                Math.max(fromUp2, fromLeft2),
                                Math.max(fromUp1, fromLeft1) + coin
                        );
                        dp[0][y][x] = Math.max(
                                Math.max(fromUp1, fromLeft1),
                                Math.max(fromUp0, fromLeft0) + coin
                        );
                    }
                }
            }
            return Math.max(dp[0][height - 1][width - 1], Math.max(dp[1][height - 1][width - 1], dp[2][height - 1][width - 1]));
        }
    }

}
