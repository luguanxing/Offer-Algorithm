package leetcode.contest.week323;

import java.util.*;

public class Test6260_矩阵查询可获得的最大分数 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution_暴力().maxPoints(
                new int[][]{{1, 2, 3}, {2, 5, 7}, {3, 5, 1}},
                new int[]{5, 6, 2}
        )));
        System.out.println(Arrays.toString(new Solution_暴力().maxPoints(
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
            // 把queries排序，这样结果也只会递增，同时存储对应结果
            int k = queries.length;
            int[] sQueries = queries.clone();
            Arrays.sort(sQueries);
            Map<Integer, Integer> kvMap = new HashMap<>();
            for (int i = 0; i < k; i++) {
                int key = sQueries[i];
                int value = query(sQueries[i]);
                kvMap.put(key, value);
            }
            // 按原顺序还原对应结果
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = kvMap.get(queries[i]);
            }
            return res;
        }

        int cnt = 0;
        Set<String> visited = new HashSet<>();
        Set<String> candidates = new HashSet<>();

        private int query(int k) {
            // 找出grid里所有小于k且能到达的方块数
            dfs(0, 0, k);
            // 如果有之前位置因为k不够大导致无法探索的，从这些位置继续探索
            for (String candidate : new HashSet<>(candidates)) {
                int y = Integer.parseInt(candidate.split(",")[0]);
                int x = Integer.parseInt(candidate.split(",")[1]);
                dfs(y, x, k);
            }
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
                candidates.add(y + "," + x);
                return;
            }
            cnt++;
            visited.add(y + "," + x);
            candidates.remove(y + "," + x);
            dfs(y + 1, x, k);
            dfs(y - 1, x, k);
            dfs(y, x + 1, k);
            dfs(y, x - 1, k);
        }
    }

    static class Solution_暴力 {
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
