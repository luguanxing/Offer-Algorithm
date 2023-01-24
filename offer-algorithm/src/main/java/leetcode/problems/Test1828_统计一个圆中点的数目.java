package leetcode.problems;

import java.util.Arrays;

public class Test1828_统计一个圆中点的数目 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().countPoints(
                new int[][]{{1, 3}, {3, 3}, {5, 3}, {2, 2}},
                new int[][]{{2, 3, 1}, {4, 3, 1}, {1, 1, 2}}
        )));
        System.out.println(Arrays.toString(new Solution().countPoints(
                new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}},
                new int[][]{{1, 2, 2}, {2, 2, 2}, {4, 3, 2}, {4, 3, 3}}
        )));
    }

    static class Solution {
        public int[] countPoints(int[][] points, int[][] queries) {
            int len = queries.length;
            int[] res = new int[len];
            for (int i = 0; i < len; i++) {
                int[] query = queries[i];
                int x = query[0];
                int y = query[1];
                int r = query[2];
                for (int[] point : points) {
                    int px = point[0];
                    int py = point[1];
                    if ((px - x) * (px - x) + (py - y) * (py - y) <= r * r) {
                        res[i]++;
                    }
                }
            }
            return res;
        }
    }

}
