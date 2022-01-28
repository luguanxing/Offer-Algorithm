package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test2013_检测正方形 {

    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{3, 10});
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{3, 2});
        detectSquares.count(new int[]{11, 10}); // 返回 1 。你可以选择：
        //   - 第一个，第二个，和第三个点
        detectSquares.count(new int[]{14, 8});  // 返回 0 。查询点无法与数据结构中的这些点构成正方形。
        detectSquares.add(new int[]{11, 2});    // 允许添加重复的点。
        detectSquares.count(new int[]{11, 10}); // 返回 2 。你可以选择：
        //   - 第一个，第二个，和第三个点
        //   - 第一个，第三个，和第四个点
    }

    static class DetectSquares {
        Map<String, Integer> pointCntMap = new HashMap<>();

        public DetectSquares() {

        }

        public void add(int[] point) {
            String key = point[0] + "," + point[1];
            pointCntMap.put(key, pointCntMap.getOrDefault(key, 0) + 1);
        }

        public int count(int[] point) {
            int x = point[0];
            int y = point[1];
            // 枚举所有能构成对角线的点
            int res = 0;
            for (String key : pointCntMap.keySet()) {
                int deltaX = Integer.parseInt(key.split(",")[0]);
                int deltaY = Integer.parseInt(key.split(",")[1]);
                if (deltaX != x && deltaY != y && Math.abs(x - deltaX) == Math.abs(y - deltaY)) {
                    // (dx,y)   (x,y)
                    // (dx,dy)  (x,dy)
                    res = pointCntMap.getOrDefault(deltaX + "," + y, 0) *
                            pointCntMap.getOrDefault(deltaX + "," + deltaY, 0) *
                            pointCntMap.getOrDefault(x + "," + deltaY, 0);
                }
            }
            return res;
        }
    }

}
