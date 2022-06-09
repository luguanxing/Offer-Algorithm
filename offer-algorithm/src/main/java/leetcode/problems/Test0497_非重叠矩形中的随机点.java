package leetcode.problems;

import java.util.Random;
import java.util.TreeMap;

public class Test0497_非重叠矩形中的随机点 {

    public static void main(String[] args) {
        Solution solution = new Solution(new int[][]{{-2, -2, 1, 1}, {2, 2, 4, 6}});
        solution.pick(); // 返回 [1, -2]
        solution.pick(); // 返回 [1, -1]
        solution.pick(); // 返回 [-1, -2]
        solution.pick(); // 返回 [-2, -2]
        solution.pick(); // 返回 [0, 0]
    }

    static class Solution {
        TreeMap<Integer, int[]> areaMap = new TreeMap<>();
        int totalArea = 0;

        public Solution(int[][] rects) {
            for (int[] rect : rects) {
                int x1 = rect[0];
                int y1 = rect[1];
                int x2 = rect[2];
                int y2 = rect[3];
                int area = (x2 - x1 + 1) * (y2 - y1 + 1);
                areaMap.put(area, rect);
                totalArea += area;
            }
        }

        public int[] pick() {
            int randomArea = new Random().nextInt(totalArea);
            for (int area : areaMap.keySet()) {
                randomArea -= area;
                if (randomArea < 0) {
                    int[] rect = areaMap.get(area);
                    int x1 = rect[0];
                    int y1 = rect[1];
                    int x2 = rect[2];
                    int y2 = rect[3];
                    int x = x1 + new Random().nextInt(x2 - x1 + 1);
                    int y = y1 + new Random().nextInt(y2 - y1 + 1);
                    return new int[]{x, y};
                }
            }
            return null;
        }
    }

}
