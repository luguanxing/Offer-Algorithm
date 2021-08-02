package leetcode.problems;

import java.util.*;

public class Test0743_网络延迟时间 {

    public static void main(String[] args) {
        System.out.println(new Solution().networkDelayTime(
                new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2
        ));
        System.out.println(new Solution().networkDelayTime(
                new int[][]{{1, 2, 1}}, 2, 1
        ));
        System.out.println(new Solution().networkDelayTime(
                new int[][]{{1, 2, 1}}, 2, 2
        ));
        System.out.println(new Solution().networkDelayTime(
                new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 2}}, 3, 1
        ));
        System.out.println(new Solution().networkDelayTime(
                new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 4}}, 3, 1
        ));
    }

    static class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            int[][] timeMap = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    timeMap[i][j] = Integer.MAX_VALUE / 2;
                }
            }
            for (int[] time : times) {
                int from = time[0];
                int to = time[1];
                int cost = time[2];
                timeMap[from][to] = cost;
                timeMap[from][from] = 0;
            }
            // prim算法，算出所有点到所有点最短
            for (int x = 1; x <= n; x++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        if (timeMap[i][j] > timeMap[i][x] + timeMap[x][j]) {
                            timeMap[i][j] = timeMap[i][x] + timeMap[x][j];
                        }
                    }
                }
            }
            // 判断k到是否能到剩余点和到最长耗时
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (timeMap[k][i] != Integer.MAX_VALUE / 2) {
                    count++;
                }
            }
            if (count == n) {
                return Arrays.stream(timeMap[k]).max().orElse(0);
            } else {
                return -1;
            }
        }
    }

}
