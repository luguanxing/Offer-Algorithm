package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test0973_最接近原点的K个点 {

    public static void main(String[] args) {
        for (int[] nums : new Solution().kClosest(
                new int[][]{{1, 3}, {-2, 2}}, 1
        )) {
            System.out.println(Arrays.toString(nums));
        }
        System.out.println();
        for (int[] nums : new Solution().kClosest(
                new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2
        )) {
            System.out.println(Arrays.toString(nums));
        }
    }

    static class Solution {
        public int[][] kClosest(int[][] points, int K) {
            List<Point> pointList = Arrays
                    .stream(points)
                    .map(Point::new)
                    .collect(Collectors.toList());
            pointList.sort(Comparator.comparingDouble(o -> o.distance));
            int[][] res = new int[K][2];
            for (int i = 0; i < K; i++) {
                res[i][0] = pointList.get(i).point[0];
                res[i][1] = pointList.get(i).point[1];
            }
            return res;
        }


        static class Point {
            int[] point;
            double distance;

            public Point(int[] point) {
                this.point = point;
                this.distance = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
            }
        }
    }

}
