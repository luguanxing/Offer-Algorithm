package leetcode.contest.week248;

import java.util.Arrays;

public class Test5801_消灭怪物的最大数量 {

    public static void main(String[] args) {
        System.out.println(new Solution().eliminateMaximum(
                new int[]{1, 3, 4},
                new int[]{1, 1, 1}
        ));
        System.out.println(new Solution().eliminateMaximum(
                new int[]{1, 1, 2, 3},
                new int[]{1, 1, 1, 1}
        ));
        System.out.println(new Solution().eliminateMaximum(
                new int[]{3, 2, 4},
                new int[]{5, 3, 2}
        ));
        System.out.println(new Solution().eliminateMaximum(
                new int[]{4, 3, 2},
                new int[]{2, 1, 1}
        ));
    }

    static class Solution {
        public int eliminateMaximum(int[] dist, int[] speed) {
            // 怪物耗时排序
            int n = dist.length;
            double[] costTime = new double[n];
            for (int i = 0; i < n; i++) {
                costTime[i] = dist[i] * 1.0 / speed[i];
            }
            Arrays.sort(costTime);
            // 看看是否都间隔为1以上
            int res = 0;
            for (int i = 0; i < n; ) {
                if (res < costTime[i]) {
                    res++;
                    i++;
                } else {
                    break;
                }
            }
            return res;
        }
    }

}
