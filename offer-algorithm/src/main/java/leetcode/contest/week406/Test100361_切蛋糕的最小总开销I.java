package leetcode.contest.week406;

import java.util.*;

public class Test100361_切蛋糕的最小总开销I {

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
        public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
            // 使用优先队列来存储所有切割操作，并根据切割成本从大到小排序
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
            for (int i = 0; i < horizontalCut.length; i++) {
                pq.offer(new int[]{horizontalCut[i], 0});
            }
            for (int j = 0; j < verticalCut.length; j++) {
                pq.offer(new int[]{verticalCut[j], 1});
            }
            // 初始化水平和垂直方向上的蛋糕块数目
            int hCount = 1, vCount = 1;
            int totalCost = 0;
            // 按成本从大到小顺序进行切割操作
            while (!pq.isEmpty()) {
                int[] cut = pq.poll();
                int cost = cut[0];
                int type = cut[1];
                if (type == 0) {
                    // 水平切割，更新水平块数目
                    totalCost += cost * vCount;
                    hCount++;
                } else {
                    // 垂直切割，更新垂直块数目
                    totalCost += cost * hCount;
                    vCount++;
                }
            }
            return totalCost;
        }
    }

}
