package leetcode.contest.week331;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test6348_从数量最多的堆取走礼物 {

    public static void main(String[] args) {
        System.out.println(new Solution().pickGifts(
                new int[]{25, 64, 9, 4, 100}, 4
        ));
        System.out.println(new Solution().pickGifts(
                new int[]{1, 1, 1, 1}, 4
        ));
    }

    static class Solution {
        public long pickGifts(int[] gifts, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            for (int gift : gifts) {
                queue.add(gift);
            }
            for (int i = 1; i <= k; i++) {
                int num = queue.poll();
                int newNum = (int) Math.sqrt(num);
                queue.add(newNum);
            }
            long sum = 0;
            for (int gift : queue) {
                sum += gift;
            }
            return sum;
        }
    }

}
