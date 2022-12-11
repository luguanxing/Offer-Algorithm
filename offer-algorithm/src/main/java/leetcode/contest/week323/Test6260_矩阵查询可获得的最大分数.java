package leetcode.contest.week323;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test6260_矩阵查询可获得的最大分数 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().maxPoints(
                new int[][]{{1, 2, 3}, {2, 5, 7}, {3, 5, 1}},
                new int[]{5, 6, 2}
        )));
        System.out.println(Arrays.toString(new Solution().maxPoints(
                new int[][]{{5, 2, 1}, {1, 1, 2}},
                new int[]{3}
        )));
    }

    static class Solution {
        int[][] grid;
        int h;
        int w;

        public int[] maxPoints(int[][] grid, int[] queries) {
            this.grid = grid;
            this.h = grid.length;
            this.w = grid[0].length;
            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                res[i] = query(queries[i]);
            }
            return res;
        }

        int cnt;
        Set<String> visited;

        private int query(int k) {
            cnt = 0;
            visited = new HashSet<>();
            // 找出grid里所有小于k且能到达的方块数
            dfs(0, 0, k);
            return cnt;
        }

        private void dfs(int y, int x, int k) {
            if (y < 0 || x < 0 || y >= h || x >= w) {
                return;
            }
            if (visited.contains(y + "," + x)) {
                return;
            }
            if (grid[y][x] >= k) {
                return;
            }
            cnt++;
            visited.add(y + "," + x);
            dfs(y + 1, x, k);
            dfs(y - 1, x, k);
            dfs(y, x + 1, k);
            dfs(y, x - 1, k);
        }
    }

}
