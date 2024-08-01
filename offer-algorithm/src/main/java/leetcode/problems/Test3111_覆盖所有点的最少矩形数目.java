package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

public class Test3111_覆盖所有点的最少矩形数目 {

    public static void main(String[] args) {
        // points = [[2,1],[1,0],[1,4],[1,8],[3,5],[4,6]], w = 1
        System.out.println(new Solution().minRectanglesToCoverPoints(new int[][]{{2, 1}, {1, 0}, {1, 4}, {1, 8}, {3, 5}, {4, 6}}, 1));
        // points = [[0,0],[1,1],[2,2],[3,3],[4,4],[5,5],[6,6]], w = 2
        System.out.println(new Solution().minRectanglesToCoverPoints(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}}, 2));
        // points = [[2,3],[1,2]], w = 0
        System.out.println(new Solution().minRectanglesToCoverPoints(new int[][]{{2, 3}, {1, 2}}, 0));
    }

    static class Solution {
        public int minRectanglesToCoverPoints(int[][] points, int w) {
            // 先按点的x从小到大排序
            Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
            // 按贪心策略从左到右画矩形
            int res = 1;
            int left = points[0][0];
            for (int[] p : points) {
                int x = p[0];
                if (x <= left + w) {
                    continue;
                } else {
                    res++;
                    left = x;
                }
            }
            return res;
        }
    }

}
