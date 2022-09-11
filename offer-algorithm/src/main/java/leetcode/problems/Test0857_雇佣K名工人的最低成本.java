package leetcode.problems;

import java.util.*;

public class Test0857_雇佣K名工人的最低成本 {

    public static void main(String[] args) {
        System.out.println(new Solution().mincostToHireWorkers(
                new int[]{10, 20, 5},
                new int[]{70, 50, 30},
                2
        ));
        System.out.println(new Solution().mincostToHireWorkers(
                new int[]{3, 1, 10, 10, 1},
                new int[]{4, 8, 2, 2, 7},
                3
        ));
    }

    static class Solution {
        public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
            int len = quality.length;
            // 保存工人性价比和质量
            double[][] rqs = new double[len][];
            for (int i = 0; i < len; i++) {
                double[] qw = new double[2];
                qw[0] = wage[i] * 1.0 / quality[i];
                qw[1] = quality[i] * 1.0;
                rqs[i] = qw;
            }
            // 性价比低的放前面
            Arrays.sort(rqs, Comparator.comparingDouble(wq -> wq[0]));
            // 选出k个人，工时多的优先淘汰，剩下的用逐低到高的性价比算总价格
            double minSum = Integer.MAX_VALUE;
            double currentQuantitySum = 0;
            PriorityQueue<Double> queue = new PriorityQueue<>(Comparator.reverseOrder());
            for (double[] rq : rqs) {
                double ratio = rq[0];
                double quantity = rq[1];
                queue.add(quantity);
                currentQuantitySum += quantity;
                if (queue.size() > k) {
                    currentQuantitySum -= queue.poll();
                }
                if (queue.size() == k) {
                    minSum = Math.min(minSum, currentQuantitySum * ratio);
                }
            }
            return minSum;
        }
    }

}
