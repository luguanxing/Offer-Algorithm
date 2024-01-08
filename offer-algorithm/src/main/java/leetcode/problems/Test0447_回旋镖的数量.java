package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test0447_回旋镖的数量 {

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfBoomerangs(
                new int[][]{{0, 0}, {1, 0}, {2, 0}}
        ));
        System.out.println(new Solution().numberOfBoomerangs(
                new int[][]{{1, 1}, {2, 2}, {3, 3}}
        ));
        System.out.println(new Solution().numberOfBoomerangs(
                new int[][]{{1, 1}}
        ));
    }

    static class Solution {
        public int numberOfBoomerangs(int[][] points) {
            int res = 0;
            for (int[] point : points) {
                // 统计到该点不同距离的数量
                Map<Integer, Integer> map = new HashMap<>();
                for (int[] point1 : points) {
                    int dis = (point[0] - point1[0]) * (point[0] - point1[0]) + (point[1] - point1[1]) * (point[1] - point1[1]);
                    map.put(dis, map.getOrDefault(dis, 0) + 1);
                }
                // 计算回旋镖数量
                for (int cnt : map.values()) {
                    res += cnt * (cnt - 1);
                }
            }
            return res;
        }
    }

    static class Solution_old {
        public int numberOfBoomerangs(int[][] points) {
            // 空间换时间，把到每个点距离的点数量存储下来
            Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
            for (int i = 0; i < points.length; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    int[] point1 = points[i];
                    int[] point2 = points[j];
                    int dis = (point1[0] - point2[0]) * (point1[0] - point2[0]) + (point1[1] - point2[1]) * (point1[1] - point2[1]);
                    Map<Integer, Integer> disMap;
                    disMap = map.getOrDefault(i, new HashMap<>());
                    disMap.put(dis, disMap.getOrDefault(dis, 0) + 1);
                    map.put(i, disMap);
                    disMap = map.getOrDefault(j, new HashMap<>());
                    disMap.put(dis, disMap.getOrDefault(dis, 0) + 1);
                    map.put(j, disMap);
                }
            }
            int res = 0;
            for (Map<Integer, Integer> disMap : map.values()) {
                for (int cnt : disMap.values()) {
                    res += cnt * (cnt - 1);
                }
            }
            return res;
        }
    }

    static class Solution_TLE2 {
        public int numberOfBoomerangs(int[][] points) {
            int res = 0;
            for (int i = 0; i < points.length; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    for (int k = j + 1; k < points.length; k++) {
                        if (isBoomerangs(points[i], points[j], points[k]) ||
                                isBoomerangs(points[j], points[i], points[k]) ||
                                isBoomerangs(points[k], points[j], points[i]) ||
                                isBoomerangs(points[i], points[k], points[j])) {
                            res++;
                        }
                    }
                }
            }
            return res * 2;
        }

        public boolean isBoomerangs(int[] point1, int[] point2, int[] point3) {
            int x1 = point1[0];
            int y1 = point1[1];
            int x2 = point2[0];
            int y2 = point2[1];
            int x3 = point3[0];
            int y3 = point3[1];
            return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) == (x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3);
        }
    }

    static class Solution_TLE1 {
        public int numberOfBoomerangs(int[][] points) {
            int res = 0;
            for (int i = 0; i < points.length; i++) {
                for (int j = 0; j < points.length; j++) {
                    if (j == i) {
                        continue;
                    }
                    for (int k = 0; k < points.length; k++) {
                        if (k == i || k == j) {
                            continue;
                        }
                        if (isBoomerangs(points[i], points[j], points[k])) {
                            res++;
                        }
                    }
                }
            }
            return res;
        }

        public boolean isBoomerangs(int[] point1, int[] point2, int[] point3) {
            int x1 = point1[0];
            int y1 = point1[1];
            int x2 = point2[0];
            int y2 = point2[1];
            int x3 = point3[0];
            int y3 = point3[1];
            return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) == (x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3);
        }
    }

}
