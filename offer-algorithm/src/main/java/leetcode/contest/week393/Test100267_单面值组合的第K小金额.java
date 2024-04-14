package leetcode.contest.week393;

import java.util.*;

public class Test100267_单面值组合的第K小金额 {

    public static void main(String[] args) {
        // coins = [3,6,9], k = 3
        System.out.println(new Solution().findKthSmallest(new int[]{3, 6, 9}, 3));
        // coins = [5,2], k = 7
        System.out.println(new Solution().findKthSmallest(new int[]{5, 2}, 7));
    }

    static class Solution {
        public long findKthSmallest(int[] coins, int k) {
            TreeSet<Long> set = new TreeSet<>();
            PriorityQueue<long[]> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
            for (int coin : coins) {
                priorityQueue.add(new long[]{coin, coin});
            }

            while (set.size() < k) {
                long[] current = priorityQueue.poll();
                long value = current[0];
                long coin = current[1];
                set.add(value);
                priorityQueue.add(new long[]{coin + value, coin});
            }

            return set.last();
        }
    }

}
