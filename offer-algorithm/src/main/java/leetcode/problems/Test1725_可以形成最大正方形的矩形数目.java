package leetcode.problems;

import java.util.Arrays;
import java.util.TreeMap;

public class Test1725_可以形成最大正方形的矩形数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().countGoodRectangles(new int[][]{
                {5, 8}, {3, 9}, {5, 12}, {16, 5}
        }));
        System.out.println(new Solution().countGoodRectangles(new int[][]{
                {2, 3}, {3, 7}, {4, 3}, {3, 7}
        }));
    }

    static class Solution {
        public int countGoodRectangles(int[][] rectangles) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            Arrays.stream(rectangles)
                    .map((lens -> Math.min(lens[0], lens[1])))
                    .forEach((len) -> map.put(len, map.getOrDefault(len, 0) + 1));
            return map.lastEntry().getValue();
        }
    }

}
