package leetcode.contest.week280;

import java.util.Arrays;

public class Test6006_拿出最少数目的魔法豆 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumRemoval(new int[]{4, 1, 6, 5}));
        System.out.println(new Solution().minimumRemoval(new int[]{2, 10, 3, 2}));
    }

    static class Solution {
        public long minimumRemoval(int[] beans) {
            int len = beans.length;
            long sum = 0;
            for (int bean : beans) {
                // 不能用stream求和，会超范围
                sum += bean;
            }
            // 假设每个非空袋子中剩下x，那么对于当前数小于x的要清空，当前数大于x的要清理至x，即当前为x需要移除的步数
            // 同时排序后可以算出每次移除需要的步数=总数-剩下数=总数-x*剩下袋子数
            Arrays.sort(beans);
            long minStep = Long.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                long step = sum - (len - i) * (long)beans[i];
                minStep = Math.min(minStep, step);
            }
            return minStep;
        }
    }

}
