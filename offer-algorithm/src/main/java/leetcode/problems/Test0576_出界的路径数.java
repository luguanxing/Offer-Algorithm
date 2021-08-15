package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0576_出界的路径数 {

    public static void main(String[] args) {
        System.out.println(new Solution().findPaths(2, 2, 2, 0, 0));
        System.out.println(new Solution().findPaths(1, 3, 3, 0, 1));
    }

    static class Solution {
        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            // dp[i][y][x]表示已走i步时到(y,x)的方法数
            int res = 0;
            int[][][] dp = new int[maxMove + 1][m][n];
            dp[0][startRow][startColumn] = 1;
            for (int i = 0; i < maxMove; i++) {
                for (int y = 0; y < m; y++) {
                    for (int x = 0; x < n; x++) {
                        List<int[]> neighbors = getNeighbors(y, x);
                        for (int[] neighbor : neighbors) {
                            int nextY = neighbor[0];
                            int nextX = neighbor[1];
                            if (0 <= nextY && nextY < m && 0 <= nextX && nextX < n) {
                                dp[i + 1][y][x] = (dp[i + 1][y][x] + dp[i][neighbor[0]][neighbor[1]]) % 1000000007;
                            } else {
                                res = (res + dp[i][y][x]) % 1000000007;
                            }
                        }
                    }
                }
            }
            return res;
        }

        private List<int[]> getNeighbors(int y, int x) {
            List<int[]> list = new ArrayList<>();
            list.add(new int[]{y + 1, x});
            list.add(new int[]{y - 1, x});
            list.add(new int[]{y, x - 1});
            list.add(new int[]{y, x + 1});
            return list;
        }
    }

}
