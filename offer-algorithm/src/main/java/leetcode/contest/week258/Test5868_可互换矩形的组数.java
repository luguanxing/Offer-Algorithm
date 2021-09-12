package leetcode.contest.week258;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test5868_可互换矩形的组数 {

    public static void main(String[] args) {
        System.out.println(new Solution().interchangeableRectangles(
                new int[][]{{4, 8}, {3, 6}, {10, 20}, {15, 30}}
        ));
        System.out.println(new Solution().interchangeableRectangles(
                new int[][]{{4, 5}, {7, 8}}
        ));

    }

    static class Solution {
        public long interchangeableRectangles(int[][] rectangles) {
            List<Double> ratios = Arrays.stream(rectangles)
                    .map(rectangle -> rectangle[0] * 1.0 / rectangle[1])
                    .collect(Collectors.toList());
            Map<Double, Long> map = new HashMap<>();
            for (double ratio : ratios) {
                map.put(ratio, map.getOrDefault(ratio, 0l) + 1);
            }
            long res = 0;
            for (long cnt : map.values()) {
                res += cnt * (cnt - 1) / 2;
            }
            return res;
        }
    }

}
