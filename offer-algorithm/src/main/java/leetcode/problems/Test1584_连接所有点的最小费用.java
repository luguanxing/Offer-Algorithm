package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test1584_连接所有点的最小费用 {

    public static void main(String[] args) {
        System.out.println(new Solution().minCostConnectPoints(
                new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}
        ));
        System.out.println(new Solution().minCostConnectPoints(
                new int[][]{{3, 12}, {-2, 5}, {-4, 1}}
        ));
        System.out.println(new Solution().minCostConnectPoints(
                new int[][]{{0, 0}, {1, 1}, {1, 0}, {-1, 1}}
        ));
        System.out.println(new Solution().minCostConnectPoints(
                new int[][]{{-1000000, -1000000}, {1000000, 1000000}}
        ));
        System.out.println(new Solution().minCostConnectPoints(
                new int[][]{{0, 0}}
        ));
    }

    static class Solution {
        public int minCostConnectPoints(int[][] points) {
            // 使用prim算法计算最小生成树
            List<Point> connected = new ArrayList<>();
            List<Point> left = Arrays.stream(points)
                    .map(point -> new Point(point[0], point[1]))
                    .collect(Collectors.toList());
            int res = 0;
            Point point = left.get(0);
            connected.add(point);
            left = left.subList(1, left.size());
            while (!left.isEmpty()) {
                int nextDistance = Integer.MAX_VALUE;
                Point nextPoint = null;
                for (Point p1 : left) {
                    for (Point p2 : connected) {
                        int distance = getDistance(p1, p2);
                        if (distance < nextDistance) {
                            nextDistance = distance;
                            nextPoint = p1;
                        }
                    }
                }
                left.remove(nextPoint);
                connected.add(nextPoint);
                res += nextDistance;
            }
            return res;
        }

        private int getDistance(Point p1, Point p2) {
            return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
        }

        private class Point {
            int x;
            int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public String toString() {
                return "[" + x + "," + y + "]";
            }
        }
    }

}
