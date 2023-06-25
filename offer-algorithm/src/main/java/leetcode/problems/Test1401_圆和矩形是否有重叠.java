package leetcode.problems;

public class Test1401_圆和矩形是否有重叠 {

    public static void main(String[] args) {
        System.out.println(new Solution().checkOverlap(1, 0, 0, 1, -1, 3, 1));
        System.out.println(new Solution().checkOverlap(1, 1, 1, 1, -3, 2, -1));
        System.out.println(new Solution().checkOverlap(1, 0, 0, -1, 0, 0, 1));
        System.out.println(new Solution().checkOverlap(1, 1, 1, -3, -3, 3, 3));
        System.out.println(new Solution().checkOverlap(2, 2, 1, 4, 1, 5, 5));
    }

    static class Solution {
        public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
            // 判断到矩形区域的最小距离
            int xDisSq = 0;
            int yDisSq = 0;
            // 若圆心在矩形横坐标内
            if (xCenter < x1 || xCenter > x2) {
                xDisSq = Math.min((xCenter - x1) * (xCenter - x1), (xCenter - x2) * (xCenter - x2));
            }
            // 若圆心在矩形纵坐标内
            if (yCenter < y1 || yCenter > y2) {
                yDisSq = Math.min((yCenter - y1) * (yCenter - y1), (yCenter - y2) * (yCenter - y2));
            }
            return xDisSq + yDisSq <= radius * radius;
        }
    }

}
