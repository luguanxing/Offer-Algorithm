package leetcode.contest.year2023.spring;

import java.util.*;

public class Test3_最强祝福力场 {

    public static void main(String[] args) {
        System.out.println(new Solution().fieldOfGreatestBlessing(new int[][]{{0, 0, 1}, {1, 0, 1}}));
        System.out.println(new Solution().fieldOfGreatestBlessing(new int[][]{{4, 4, 6}, {7, 5, 3}, {1, 6, 2}, {5, 6, 3}}));
        System.out.println(new Solution().fieldOfGreatestBlessing(new int[][]{{0, 0, 1}, {1, 0, 1}}));
        System.out.println(new Solution().fieldOfGreatestBlessing(new int[][]{{0, 0, 2}, {4, 0, 2}, {3, 0, 1}}));
        System.out.println(new Solution().fieldOfGreatestBlessing(new int[][]{{565, 34, 242}, {299, 628, 870}, {724, 673, 221}, {128, 267, 917}, {561, 488, 696}, {341, 71, 604}, {835, 92, 846}, {945, 696, 973}, {554, 776, 430}, {209, 134, 594}, {987, 898, 282}, {819, 154, 462}, {618, 946, 505}, {561, 40, 677}, {602, 863, 657}, {295, 83, 718}, {456, 920, 939}, {94, 717, 813}, {611, 946, 366}, {818, 850, 85}, {395, 554, 333}, {325, 700, 628}, {590, 401, 119}, {248, 858, 499}, {298, 723, 602}, {189, 538, 646}, {194, 283, 344}, {842, 535, 866}, {192, 832, 195}}));
    }

    static class Solution {
        public int fieldOfGreatestBlessing(int[][] forceField) {
            int max = 0;
            List<double[]> intersectionPoints = new ArrayList<>();
            for (int[] field1 : forceField) {
                double x1 = field1[0];
                double y1 = field1[1];
                double hf1 = field1[2] / 2.0;
                for (int[] field2 : forceField) {
                    double x2 = field2[0];
                    double y2 = field2[1];
                    double hf2 = field2[2] / 2.0;
                    double left = Math.max(x1 - hf1, x2 - hf2);
                    double right = Math.min(x1 + hf1, x2 + hf2);
                    double top = Math.min(y1 + hf1, y2 + hf2);
                    double bottom = Math.max(y1 - hf1, y2 - hf2);
                    if (left <= right && bottom <= top) {
                        intersectionPoints.add(new double[]{left, bottom});
                        intersectionPoints.add(new double[]{left, top});
                        intersectionPoints.add(new double[]{right, bottom});
                        intersectionPoints.add(new double[]{right, top});
                    }
                }
            }
            for (double[] point : intersectionPoints) {
                int current = 0;
                for (int[] field : forceField) {
                    double x = field[0];
                    double y = field[1];
                    double half = field[2] / 2.0;
                    if (x - half <= point[0] && point[0] <= x + half && y - half <= point[1] && point[1] <= y + half) {
                        current++;
                    }
                }
                max = Math.max(max, current);
            }
            return max;
        }
    }

}
