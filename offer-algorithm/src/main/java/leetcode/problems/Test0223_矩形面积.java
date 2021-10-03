package leetcode.problems;

public class Test0223_矩形面积 {

    public static void main(String[] args) {
        System.out.println(new Solution().computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        System.out.println(new Solution().computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
        System.out.println(new Solution().computeArea(-2286, -1386, -2285, -1385, -2284, -1384, -2273, -1375));
    }

    static class Solution {
        public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
            // 计算重叠面积
            int leftX = Math.max(ax1, bx1);
            int rightX = Math.min(ax2, bx2);
            int downY = Math.max(ay1, by1);
            int upY = Math.min(ay2, by2);
            int duplicateArea = 0;
            if (leftX < rightX && downY < upY) {
                duplicateArea = (rightX - leftX) * (upY - downY);
            }
            // 结果=叠加面积-重叠面积
            return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) - duplicateArea;
        }
    }

}
