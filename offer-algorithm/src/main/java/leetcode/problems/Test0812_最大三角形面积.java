package leetcode.problems;

public class Test0812_最大三角形面积 {

    public static void main(String[] args) {
        System.out.println(new Solution().largestTriangleArea(new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}}));
        System.out.println(new Solution().largestTriangleArea(new int[][]{{-35, 19}, {40, 19}, {27, -20}, {35, -3}, {44, 20}, {22, -21}, {35, 33}, {-19, 42}, {11, 47}, {11, 37}}));
    }

    static class Solution {
        public double largestTriangleArea(int[][] points) {
            int len = points.length;
            double max = 0;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    for (int k = j + 1; k < len; k++) {
                        // 海伦公式，使用三条边长计算面积
                        max = Math.max(max, getArea(points[i], points[j], points[k]));
                        if (Double.isNaN(max)) {
                            System.out.println("fuck");
                        }
                    }
                }
            }
            return max;
        }

        private double getArea(int[] point1, int[] point2, int[] point3) {
            double a = Math.sqrt((point1[0] - point2[0]) * (point1[0] - point2[0]) + (point1[1] - point2[1]) * (point1[1] - point2[1]));
            double b = Math.sqrt((point2[0] - point3[0]) * (point2[0] - point3[0]) + (point2[1] - point3[1]) * (point2[1] - point3[1]));
            double c = Math.sqrt((point1[0] - point3[0]) * (point1[0] - point3[0]) + (point1[1] - point3[1]) * (point1[1] - point3[1]));
            double p = 0.5 * (a + b + c);
            Double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            return area.isNaN() ? 0 : area;
        }
    }

}
