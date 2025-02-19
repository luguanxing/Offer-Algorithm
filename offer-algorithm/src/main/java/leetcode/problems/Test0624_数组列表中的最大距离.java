package leetcode.problems;

import java.util.*;

public class Test0624_数组列表中的最大距离 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxDistance(Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(1, 2, 3)
        )));
        System.out.println(new Solution().maxDistance(Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(1)
        )));
    }

    static class Solution {
        public int maxDistance(List<List<Integer>> arrays) {
            int min = Integer.MAX_VALUE / 2;
            int max = Integer.MIN_VALUE / 2;
            int maxDiff = 0;
            for (List<Integer> array : arrays) {
                int currentMin = array.get(0);
                int currentMax = array.get(array.size() - 1);
                // 数要来自不同的数组，所以要拿之前结果和当前分别计算
                maxDiff = Math.max(maxDiff, Math.max(max - currentMin, currentMax - min));
                min = Math.min(min, currentMin);
                max = Math.max(max, currentMax);
            }
            return maxDiff;
        }
    }

}
