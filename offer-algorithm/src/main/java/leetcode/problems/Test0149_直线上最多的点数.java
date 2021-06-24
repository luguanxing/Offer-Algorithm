package leetcode.problems;

import java.math.BigDecimal;

public class Test0149_直线上最多的点数 {

    public static void main(String[] args) {
//        System.out.println(new Solution().maxPoints(new int[][]{
//        }));
//        System.out.println(new Solution().maxPoints(new int[][]{
//                {1, 1}
//        }));
//        System.out.println(new Solution().maxPoints(new int[][]{
//                {1, 1}, {2, 2}
//        }));
//        System.out.println(new Solution().maxPoints(new int[][]{
//                {1, 1}, {2, 2}, {3, 3}
//        }));
//        System.out.println(new Solution().maxPoints(new int[][]{
//                {1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}
//        }));
//        System.out.println(new Solution().maxPoints(new int[][]{
//                {2, 3}, {3, 3}, {-5, 3}
//        }));
//        System.out.println(new Solution().maxPoints(new int[][]{
//                {4, 5}, {4, -1}, {4, 0}
//        }));
//        System.out.println(new Solution().maxPoints(new int[][]{
//                {94911152, 94911151}, {0, 0}, {94911151, 94911150},
//        }));
        System.out.println(new Solution().maxPoints(new int[][]{
                {-6, -1}, {3, 1}, {12, 3},
        }));
    }

    static class Solution {
        public int maxPoints(int[][] points) {
            if (points.length == 0) {
                return 0;
            }
            int max = 1;
            for (int i = 0; i < points.length; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    Double k = (y1 - y2) * 1.0 / (x1 - x2);
                    Double b = y1 - k * x1;
                    int current = 2;
                    for (int u = 0; u < points.length; u++) {
                        if (u == i || u == j) {
                            continue;
                        }
                        int x = points[u][0];
                        int y = points[u][1];
                        if (k.isInfinite()) {
                            if (x == x1) {
                                current++;
                            }
                        } else {
                            BigDecimal res1 = new BigDecimal(String.valueOf(k))
                                    .multiply(new BigDecimal(String.valueOf(x)))
                                    .add(new BigDecimal(String.valueOf(b)));
                            BigDecimal res2 = new BigDecimal(String.valueOf(y * 1.0));
                            if (res1.subtract(res2).abs().compareTo(new BigDecimal("0.000000001")) < 0) {
                                current++;
                            }
                        }
                    }
                    max = Math.max(max, current);
                }
            }
            return max;
        }
    }

}
