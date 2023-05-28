package leetcode.problems;

import java.util.*;

public class Test1439_有序矩阵中的第k个最小数组和 {

    public static void main(String[] args) {
        System.out.println(new Solution().kthSmallest(
                new int[][]{
                        {1, 3, 11},
                        {2, 4, 6}
                },
                5
        ));
        System.out.println(new Solution().kthSmallest(
                new int[][]{
                        {1, 3, 11},
                        {2, 4, 6}
                },
                9
        ));
        System.out.println(new Solution().kthSmallest(
                new int[][]{
                        {1, 10, 10},
                        {1, 4, 5},
                        {2, 3, 6}
                },
                7
        ));
        System.out.println(new Solution().kthSmallest(
                new int[][]{
                        {1, 1, 10},
                        {2, 2, 9}
                },
                7
        ));
    }

    static class Solution {
        public int kthSmallest(int[][] mat, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            pq.add(0);
            for (int[] row : mat) {
                List<Integer> currents = new ArrayList<>(pq);
                pq.clear();
                for (int current : currents) {
                    for (int num : row) {
                        pq.add(current + num);
                    }
                }
                while (pq.size() > k) {
                    pq.poll();
                }
            }
            return pq.peek();
        }
    }

}
