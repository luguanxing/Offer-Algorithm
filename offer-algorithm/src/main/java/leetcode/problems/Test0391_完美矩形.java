package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test0391_完美矩形 {

    public static void main(String[] args) {
        System.out.println(new Solution().isRectangleCover(new int[][]{{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}}));
        System.out.println(new Solution().isRectangleCover(new int[][]{{1, 1, 2, 3}, {1, 3, 2, 4}, {3, 1, 4, 2}, {3, 2, 4, 4}}));
        System.out.println(new Solution().isRectangleCover(new int[][]{{1, 1, 3, 3}, {3, 1, 4, 2}, {1, 3, 2, 4}, {3, 2, 4, 4}}));
        System.out.println(new Solution().isRectangleCover(new int[][]{{1, 1, 3, 3}, {3, 1, 4, 2}, {1, 3, 2, 4}, {2, 2, 4, 4}}));
    }

    /**
     * 如果是完美矩形 那么一定满足两点：
     * （1）最左下 最左上 最右下 最右上 的四个点只出现一次 其他点成对出现
     * （2）四个点围城的矩形面积 = 小矩形的面积之和
     */
    static class Solution {
        public boolean isRectangleCover(int[][] rectangles) {
            int up = Integer.MIN_VALUE;
            int down = Integer.MAX_VALUE;
            int left = Integer.MAX_VALUE;
            int right = Integer.MIN_VALUE;
            int totalArea = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int[] rectangle : rectangles) {
                int x1 = rectangle[0];
                int y1 = rectangle[1];
                int x2 = rectangle[2];
                int y2 = rectangle[3];
                // 找到四条边
                up = Math.max(up, y2);
                down = Math.min(down, y1);
                left = Math.min(left, x1);
                right = Math.max(right, x2);
                // 总面积计算
                totalArea += (y2 - y1) * (x2 - x1);
                // 统计每个点出现次数
                String point1 = x1 + "," + y1;
                String point2 = x2 + "," + y2;
                String point3 = x1 + "," + y2;
                String point4 = x2 + "," + y1;
                map.put(point1, map.getOrDefault(point1, 0) + 1);
                map.put(point2, map.getOrDefault(point2, 0) + 1);
                map.put(point3, map.getOrDefault(point3, 0) + 1);
                map.put(point4, map.getOrDefault(point4, 0) + 1);
            }
            //
            String point1 = left + "," + up;
            String point2 = left + "," + down;
            String point3 = right + "," + up;
            String point4 = right + "," + down;
            // 判断四个角的点是否只出现一次, 其他点是否出现2或4次
            for (String point : map.keySet()) {
                int cnt = map.getOrDefault(point, 0);
                if (point.equals(point1) || point.equals(point2) || point.equals(point3) || point.equals(point4)) {
                    if (cnt != 1) {
                        return false;
                    }
                } else {
                    if (cnt != 2 && cnt != 4) {
                        return false;
                    }
                }
            }
            // 计算总面积是否相等
            int area = (up - down) * (right - left);
            return area == totalArea;
        }
    }

}
