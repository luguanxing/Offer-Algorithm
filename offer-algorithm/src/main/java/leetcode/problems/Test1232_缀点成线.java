package leetcode.problems;

import java.util.Arrays;

public class Test1232_缀点成线 {

    public static void main(String[] args) {
        System.out.println(new Solution().checkStraightLine(
                new int[][] {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}}
        ));
        System.out.println(new Solution().checkStraightLine(
                new int[][] {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}}
        ));
    }

    static class Solution {
        public boolean checkStraightLine(int[][] coordinates) {
            // 检查所有点是否X都相同，即k无穷大
            boolean allInY = true;
            int xLine = coordinates[0][0];
            for (int[] points : coordinates) {
                if (points[0] != xLine) {
                    allInY = false;
                }
            }
            if (allInY) {
                return true;
            }
            // 计算斜率k
            int y1 = coordinates[0][1];
            int x1 = coordinates[0][0];
            int y2 = coordinates[1][1];
            int x2 = coordinates[1][0];
            if (x1 == x2) {
                // 两个点组成的线k无穷大，但又不是所有点都在线上(否则上面allInY返回了true)
                return false;
            }
            double k = (y1 - y2) * 1.0 / (x1 - x2);
            boolean allOk = true;
            for (int i = 2; i < coordinates.length; i++) {
                int x = coordinates[i][0];
                int y = coordinates[i][1];
                if ((x - x1) * k + y1 != y) {
                    allOk = false;
                }
            }
            return allOk;
        }
    }

}
