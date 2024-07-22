package leetcode.problems;

import java.util.*;

public class Test2101_引爆最多的炸弹 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumDetonation(new int[][]{
                {2, 1, 3},
                {6, 1, 4}
        }));
        System.out.println(new Solution().maximumDetonation(new int[][]{
                {1, 1, 5},
                {10, 10, 5}
        }));
        System.out.println(new Solution().maximumDetonation(new int[][]{
                {1, 2, 3},
                {2, 3, 1},
                {3, 4, 2},
                {4, 5, 3},
                {5, 6, 5}
        }));
        System.out.println(new Solution().maximumDetonation(new int[][]{
                {1, 1, 100000},
                {100000, 100000, 1},
        }));
    }

    static class Solution {
        public int maximumDetonation(int[][] bombs) {
            // DFS引爆
            int max = 0;
            // 枚举所有引爆点，每次引爆后清除记录重试
            Set<int[]> visited = new HashSet<>();
            for (int[] bomb : bombs) {
                max = Math.max(max, dfs(bomb, bombs, visited));
                visited.clear();
            }
            return max;
        }

        private int dfs(int[] currentBomb, int[][] bombs, Set<int[]> visited) {
            visited.add(currentBomb);
            int res = 1;
            for (int[] nextBomb : bombs) {
                if (isReachable(currentBomb, nextBomb) && !visited.contains(nextBomb)) {
                    res += dfs(nextBomb, bombs, visited);
                }
            }
            return res;
        }

        private boolean isReachable(int[] currentBomb, int[] nextBomb) {
            long dis2 = (long) (currentBomb[0] - nextBomb[0]) * (currentBomb[0] - nextBomb[0])
                    + (long) (currentBomb[1] - nextBomb[1]) * (currentBomb[1] - nextBomb[1]);
            long r2 = (long) currentBomb[2] * currentBomb[2];
            return dis2 <= r2;
        }
    }


}
