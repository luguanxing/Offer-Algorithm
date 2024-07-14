package leetcode.contest.week406;

import java.util.PriorityQueue;

public class Test100367_切蛋糕的最小总开销II {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumCost(
                3, 2,
                new int[]{1, 3},
                new int[]{5}
        ));
        System.out.println(new Solution().minimumCost(
                2, 2,
                new int[]{7},
                new int[]{4}
        ));
    }

    static class Solution {
        public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
            // 使用优先队列来存储所有切割操作，并根据切割成本从大到小排序
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
            for (int i = 0; i < horizontalCut.length; i++) {
                pq.offer(new int[]{horizontalCut[i], 0});
            }
            for (int j = 0; j < verticalCut.length; j++) {
                pq.offer(new int[]{verticalCut[j], 1});
            }
            // 贪心算法，按成本从大到小顺序进行切割操作
            long hCount = 1, vCount = 1;
            long totalCost = 0;
            while (!pq.isEmpty()) {
                int[] cut = pq.poll();
                long cost = cut[0];
                long type = cut[1];
                if (type == 0) {
                    // 水平切割，要乘上已切的垂直块数目，更新水平块数目
                    totalCost += cost * vCount;
                    hCount++;
                } else {
                    // 垂直切割，要乘上已切的水平块数目，更新垂直块数目
                    totalCost += cost * hCount;
                    vCount++;
                }
            }
            return totalCost;
        }
    }

}
