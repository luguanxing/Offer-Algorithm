package leetcode.contest.week191;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test5425_切割后面积最大的蛋糕 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(5, 4, new int[]{1, 2, 4}, new int[]{1, 3}));
        System.out.println(new Solution().maxArea(5, 4, new int[]{3, 1}, new int[]{1}));
        System.out.println(new Solution().maxArea(5, 4, new int[]{3}, new int[]{3}));
        System.out.println(new Solution().maxArea(1000000000, 1000000000, new int[]{591015057, 176484069, 195962145}, new int[]{792989830, 499549413, 794617178}));
    }

    static class Solution {
        public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
            // 求出所有边界
            List<Integer> horizontal = Arrays
                    .stream(horizontalCuts)
                    .boxed()
                    .sorted()
                    .collect(Collectors.toList());
            List<Integer> vertical = Arrays
                    .stream(verticalCuts)
                    .boxed()
                    .sorted()
                    .collect(Collectors.toList());
            horizontal.add(0, 0);
            horizontal.add(horizontal.size(), h);
            vertical.add(0, 0);
            vertical.add(vertical.size(), w);
            // 求出两条线间最大值
            int hMax = horizontal.get(1) - horizontal.get(0);
            for (int i = 2; i < horizontal.size(); i++) {
                hMax = Math.max(hMax, horizontal.get(i) - horizontal.get(i - 1));
            }
            int wMax = vertical.get(1) - vertical.get(0);
            for (int i = 2; i < vertical.size(); i++) {
                wMax = Math.max(wMax, vertical.get(i) - vertical.get(i - 1));
            }
            return BigInteger.valueOf(hMax).multiply(BigInteger.valueOf(wMax)).mod(BigInteger.valueOf(1000000007)).intValue();
        }
    }

}
