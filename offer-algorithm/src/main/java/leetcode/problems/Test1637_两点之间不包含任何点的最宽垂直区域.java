package leetcode.problems;

import java.util.*;

public class Test1637_两点之间不包含任何点的最宽垂直区域 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxWidthOfVerticalArea(new int[][]{{8, 7}, {9, 9}, {7, 4}, {9, 7}}));
        System.out.println(new Solution().maxWidthOfVerticalArea(new int[][]{{3, 1}, {9, 0}, {1, 0}, {1, 4}, {5, 3}, {8, 8}}));
    }

    static class Solution {
        public int maxWidthOfVerticalArea(int[][] points) {
            Set<Integer> set = new TreeSet<>();
            for (int[] point : points) {
                set.add(point[0]);
            }
            List<Integer> list = new ArrayList<>(set);
            int max = 0;
            for (int i = 1; i < list.size(); i++) {
                max = Math.max(max, list.get(i) - list.get(i - 1));
            }
            return max;
        }
    }

}
