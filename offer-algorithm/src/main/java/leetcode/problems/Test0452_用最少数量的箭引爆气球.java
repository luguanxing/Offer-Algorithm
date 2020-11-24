package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

public class Test0452_用最少数量的箭引爆气球 {

    public static void main(String[] args) {
        System.out.println(new Solution().findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        System.out.println(new Solution().findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
        System.out.println(new Solution().findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
        System.out.println(new Solution().findMinArrowShots(new int[][]{{1, 2}}));
    }

    static class Solution {
        public int findMinArrowShots(int[][] points) {
            if (points.length == 0) {
                return 0;
            }
            // 根据右边距离进行排序
            Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
            int res = 1;
            int canShot = points[0][1];
            // 找到最右边不能触发时切换下一个
            for (int i = 1; i < points.length; i++) {
                if (canShot < points[i][0]) {
                    res++;
                    canShot = points[i][1];
                }
            }
            return res;
        }
    }

}
