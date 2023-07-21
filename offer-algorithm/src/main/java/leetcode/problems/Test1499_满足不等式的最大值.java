package leetcode.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test1499_满足不等式的最大值 {

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxValueOfEquation(
                new int[][]{{1, 3}, {2, 0}, {5, 10}, {6, -10}}, 1
        ));
        System.out.println(new Solution().findMaxValueOfEquation(
                new int[][]{{0, 0}, {3, 0}, {9, 2}}, 3
        ));
        System.out.println(new Solution().findMaxValueOfEquation(
                new int[][]{{-19, 9}, {-15, -19}, {-5, -8}}, 10
        ));
    }

    static class Solution {
        public int findMaxValueOfEquation(int[][] points, int k) {
            // y1+y2+|x2-x1| = (y1-x1) + (x2+y2)
            // 遍历(x2,y2)，寻找满足约束k条件堆内的最大(y1-x1)
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
            int max = Integer.MIN_VALUE;
            for (int[] point : points) {
                int x = point[0];
                int y = point[1];
                while (!pq.isEmpty() && x - pq.peek()[1] > k) {
                    pq.poll();
                }
                if (!pq.isEmpty()) {
                    max = Math.max(max, x + y + pq.peek()[0]);
                }
                pq.offer(new int[]{y - x, x});
            }
            return max;
        }
    }

}
