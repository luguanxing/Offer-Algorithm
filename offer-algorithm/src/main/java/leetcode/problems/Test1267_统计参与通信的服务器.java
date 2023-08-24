package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test1267_统计参与通信的服务器 {

    public static void main(String[] args) {
        System.out.println(new Solution().countServers(new int[][]{
                {1, 0},
                {0, 1}
        }));
        System.out.println(new Solution().countServers(new int[][]{
                {1, 0},
                {1, 1}
        }));
        System.out.println(new Solution().countServers(new int[][]{
                {1, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        }));
    }

    static class Solution {
        public int countServers(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            Map<Integer, Integer> rows = new HashMap<>();
            Map<Integer, Integer> cols = new HashMap<>();
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (grid[y][x] == 1) {
                        rows.put(y, rows.getOrDefault(y, 0) + 1);
                        cols.put(x, cols.getOrDefault(x, 0) + 1);
                    }
                }
            }
            int res = 0;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (grid[y][x] == 1 && (rows.get(y) > 1 || cols.get(x) > 1)) {
                        res++;
                    }
                }
            }
            return res;
        }
    }

}
