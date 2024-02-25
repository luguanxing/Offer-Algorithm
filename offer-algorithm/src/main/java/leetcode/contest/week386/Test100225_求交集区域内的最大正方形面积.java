package leetcode.contest.week386;

public class Test100225_求交集区域内的最大正方形面积 {

    public static void main(String[] args) {
        // bottomLeft = [[1,1],[2,2],[3,1]], topRight = [[3,3],[4,4],[6,6]]
        System.out.println(new Solution().largestSquareArea(new int[][]{{1, 1}, {2, 2}, {3, 1}}, new int[][]{{3, 3}, {4, 4}, {6, 6}}));
        // bottomLeft = [[1,1],[2,2],[1,2]], topRight = [[3,3],[4,4],[3,4]]
        System.out.println(new Solution().largestSquareArea(new int[][]{{1, 1}, {2, 2}, {1, 2}}, new int[][]{{3, 3}, {4, 4}, {3, 4}}));
        // bottomLeft = [[1,1],[3,3],[3,1]], topRight = [[2,2],[4,4],[4,2]]
        System.out.println(new Solution().largestSquareArea(new int[][]{{1, 1}, {3, 3}, {3, 1}}, new int[][]{{2, 2}, {4, 4}, {4, 2}}));
    }

    static class Solution {
        public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
            long maxArea = 0;
            for (int i = 0; i < bottomLeft.length; i++) {
                for (int j = i + 1; j < bottomLeft.length; j++) {
                    // 计算交集的左下角
                    int intersectBottomLeftX = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                    int intersectBottomLeftY = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                    // 计算交集的右上角
                    int intersectTopRightX = Math.min(topRight[i][0], topRight[j][0]);
                    int intersectTopRightY = Math.min(topRight[i][1], topRight[j][1]);
                    // 检查是否存在交集
                    if (intersectTopRightX > intersectBottomLeftX && intersectTopRightY > intersectBottomLeftY) {
                        // 计算交集的宽度和高度
                        int width = intersectTopRightX - intersectBottomLeftX;
                        int height = intersectTopRightY - intersectBottomLeftY;
                        // 找到可以放入该区域的最大正方形的边长
                        long side = Math.min(width, height);
                        maxArea = Math.max(maxArea, side * side);
                    }
                }
            }
            return maxArea;
        }
    }

}
