package leetcode.contest.week260;

import java.util.Arrays;

public class Test5882_网格游戏 {

    public static void main(String[] args) {
        System.out.println(new Solution().gridGame(new int[][]{
                {2, 5, 4},
                {1, 5, 1}
        }));
        System.out.println(new Solution().gridGame(new int[][]{
                {3, 3, 1},
                {8, 5, 2}
        }));
        System.out.println(new Solution().gridGame(new int[][]{
                {1, 3, 1, 15},
                {1, 3, 3, 1}
        }));
        System.out.println(new Solution().gridGame(new int[][]{
                {20, 3, 20, 17, 2, 12, 15, 17, 4, 15},
                {20, 10, 13, 14, 15, 5, 2, 3, 14, 3}
        }));
    }

    static class Solution {
        public long gridGame(int[][] grid) {
            // 计算前缀和
            int len = grid[0].length;
            long[] sum1 = new long[len];
            long[] sum2 = new long[len];
            sum1[0] = grid[0][0];
            sum2[0] = grid[1][0];
            for (int i = 1; i < len; i++) {
                sum1[i] += sum1[i - 1] + grid[0][i];
                sum2[i] += sum2[i - 1] + grid[1][i];
            }
            // 枚举第一个机器人的所有拐点后，数组变为[0,0,0,0,X,X,X,X][Y,Y,Y,0,0,0,0,0]
            // 第二个机器人拐点只能是第一个或者最后一个
            long res = Long.MAX_VALUE;
            for (int bot1Index = 0; bot1Index < len; bot1Index++) {
                long bot2up = sum1[len-1] - sum1[bot1Index];
                long bot2down = bot1Index == 0 ? 0 : sum2[bot1Index - 1];
                res = Math.min(res, Math.max(bot2up, bot2down));
            }
            return res;
        }
    }

    static class Solution_暴力 {
        public long gridGame(int[][] grid) {
            int len = grid[0].length;
            int res = Integer.MAX_VALUE;
            for (int bot1Index = 0; bot1Index < len; bot1Index++) {
                int[][] copyGrid = new int[2][len];
                copyGrid[0] = Arrays.copyOfRange(grid[0], 0, len);
                copyGrid[1] = Arrays.copyOfRange(grid[1], 0, len);
                for (int i = 0; i <= bot1Index; i++) {
                    copyGrid[0][i] = 0;
                }
                for (int i = bot1Index; i < len; i++) {
                    copyGrid[1][i] = 0;
                }
                int bot2Index = findMaxIndex(copyGrid);
                int sum = 0;
                for (int i = 0; i <= bot2Index; i++) {
                    sum += copyGrid[0][i];
                }
                for (int i = bot2Index; i < len; i++) {
                    sum += copyGrid[1][i];
                }
                res = Math.min(res, sum);
            }
            return res;
        }

        private int findMaxIndex(int[][] grid) {
            // 计算前缀和
            int len = grid[0].length;
            int[] sum1 = new int[len];
            int[] sum2 = new int[len];
            sum1[0] = grid[0][0];
            sum2[0] = grid[1][0];
            for (int i = 1; i < len; i++) {
                sum1[i] += sum1[i - 1] + grid[0][i];
                sum2[i] += sum2[i - 1] + grid[1][i];
            }
            // 找出和最大的切换列
            int index = 0;
            int res = sum1[0] + sum2[len - 1];
            for (int i = 1; i < len; i++) {
                int cur = sum1[i] + sum2[len - 1] - sum2[i - 1];
                if (cur > res) {
                    index = i;
                    res = cur;
                }
            }
            return index;
        }
    }

}
