package leetcode.contest.week224;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Test5653_可以形成最大正方形的矩形数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().countGoodRectangles(
                new int[][]{
                        {5, 8}, {3, 9}, {5, 12}, {16, 5}
                }
        ));
        System.out.println(new Solution().countGoodRectangles(
                new int[][]{
                        {2, 3}, {3, 7}, {4, 3}, {3, 7}
                }
        ));
    }

    static class Solution {
        public int countGoodRectangles(int[][] rectangles) {
            Map<Integer, Integer> map = new TreeMap<>();
            for (int[] rectangle : rectangles) {
                int side = Math.min(rectangle[0], rectangle[1]);
                map.put(side, map.getOrDefault(side, 0) + 1);
            }
            List<Integer> keys = map.keySet().stream().collect(Collectors.toList());
            return map.get(keys.get(keys.size() - 1));
        }
    }

}
