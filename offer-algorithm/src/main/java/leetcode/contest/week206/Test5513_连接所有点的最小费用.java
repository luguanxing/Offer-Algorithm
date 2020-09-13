package leetcode.contest.week206;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test5513_连接所有点的最小费用 {

    public static void main(String[] args) {
        System.out.println(new Solution().minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));
        System.out.println(new Solution().minCostConnectPoints(new int[][]{{3, 12}, {-2, 5}, {-4, 1}}));
        System.out.println(new Solution().minCostConnectPoints(new int[][]{{0, 0}, {1, 1}, {1, 0}, {-1, 1}}));
        System.out.println(new Solution().minCostConnectPoints(new int[][]{{-1000000, -1000000}, {1000000, 1000000}}));
        System.out.println(new Solution().minCostConnectPoints(new int[][]{{0, 0}}));
        System.out.println(new Solution().minCostConnectPoints(new int[][]{{2, -3}, {-17, -8}, {13, 8}, {-17, -15}}));
    }

    static class Solution {
        static class Point {
            int y;
            int x;

            public Point(int y, int x) {
                this.y = y;
                this.x = x;
            }
        }

        public int minCostConnectPoints(int[][] points) {
            // 初始化所有点列表
            List<Point> pointList = new ArrayList<>();
            for (int[] point : points) {
                int x = point[0];
                int y = point[1];
                pointList.add(new Point(x, y));
            }
            // 计算每个点之间的最短距离
            int[][] dis = new int[pointList.size()][pointList.size()];
            for (int i = 0; i < pointList.size(); i++) {
                for (int j = 0; j < pointList.size(); j++) {
                    if (i == j) {
                        continue;
                    }
                    Point point1 = pointList.get(i);
                    Point point2 = pointList.get(j);
                    dis[i][j] = Math.abs(point1.x - point2.x) + Math.abs(point1.y - point2.y);
                    dis[j][i] = Math.abs(point1.x - point2.x) + Math.abs(point1.y - point2.y);
                }
            }
            // 使用prim算法计算最小生成树
            Set<Integer> visited = new HashSet<>();
            int res = 0;
            visited.add(0);
            while (visited.size() != pointList.size()) {
                int minDis = Integer.MAX_VALUE;
                int minIndex = 0;
                for (int index : visited) {
                    for (int i = 0 ; i < pointList.size(); i++) {
                        if (visited.contains(i)) {
                            continue;
                        }
                        int currentDis = dis[index][i];
                        if (currentDis < minDis) {
                            minDis = currentDis;
                            minIndex = i;
                        }
                    }
                }
                visited.add(minIndex);
                res += minDis;
            }
            return res;
        }
    }

}
