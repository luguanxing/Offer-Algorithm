package leetcode.contest.week364;

import java.util.*;

public class Test100049_美丽塔I {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumSumOfHeights(Arrays.asList(5, 3, 4, 1, 1)));
        System.out.println(new Solution().maximumSumOfHeights(Arrays.asList(6, 5, 3, 9, 2, 7)));
        System.out.println(new Solution().maximumSumOfHeights(Arrays.asList(3, 2, 5, 5, 2, 3)));
    }

    static class Solution {
        public long maximumSumOfHeights(List<Integer> maxHeights) {
            int n = maxHeights.size();
            long max = 0;
            // 枚举顶点
            for (int i = 0; i < n; i++) {
                long sum = maxHeights.get(i);
                // 从顶点向左遍历
                int peak = maxHeights.get(i);
                for (int j = i - 1; j >= 0; j--) {
                    peak = Math.min(peak, maxHeights.get(j));
                    sum += peak;
                }
                // 从顶点向右遍历
                peak = maxHeights.get(i);
                for (int j = i + 1; j < n; j++) {
                    peak = Math.min(peak, maxHeights.get(j));  // 更新当前高度为前一个高度或当前最大高度的较小值
                    sum += peak;
                }
                max = Math.max(max, sum);  // 更新最大值
            }
            return max;
        }
    }


}
