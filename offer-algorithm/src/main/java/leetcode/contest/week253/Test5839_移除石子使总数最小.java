package leetcode.contest.week253;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test5839_移除石子使总数最小 {

    public static void main(String[] args) {
        System.out.println(new Solution().minStoneSum(
                new int[]{5, 4, 9}, 2
        ));
        System.out.println(new Solution().minStoneSum(
                new int[]{4, 3, 6, 7}, 3
        ));
    }

    static class Solution {
        public int minStoneSum(int[] piles, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            for (int pile : piles) {
                queue.add(pile);
            }
            for (int i = 1; i <= k; i++) {
                int pile = queue.poll();
                int remove = (int) Math.floor(pile*1.0 / 2);
                pile = pile - remove;
                queue.add(pile);
            }
            return queue.stream().reduce(Integer::sum).get();
        }
    }

}
