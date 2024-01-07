package leetcode.contest.week379;

public class Test100170_对角线最长的矩形的面积 {

    public static void main(String[] args) {
        // dimensions = [[9,3],[8,6]]
        System.out.println(new Solution().areaOfMaxDiagonal(new int[][]{{9, 3}, {8, 6}}));
        // dimensions = [[3,4],[4,3]]
        System.out.println(new Solution().areaOfMaxDiagonal(new int[][]{{3, 4}, {4, 3}}));
        // [[6,5],[8,6],[2,10],[8,1],[9,2],[3,5],[3,5]]
        System.out.println(new Solution().areaOfMaxDiagonal(new int[][]{{6, 5}, {8, 6}, {2, 10}, {8, 1}, {9, 2}, {3, 5}, {3, 5}}));
    }

    static class Solution {
        public int areaOfMaxDiagonal(int[][] dimensions) {
            int maxD = 0;
            int maxArea = 0;
            for (int[] dimension : dimensions) {
                int d = dimension[0] * dimension[0] + dimension[1] * dimension[1];
                int area = dimension[0] * dimension[1];
                if (d > maxD) {
                    maxD = d;
                    maxArea = area;
                } else if (d == maxD && area > maxArea) {
                    // 如果对角线长度相同，但面积更大
                    maxArea = area;
                }
            }
            return maxArea;
        }
    }


}
