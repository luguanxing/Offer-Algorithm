package leetcode.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test1046_最后一块石头的重量 {

    public static void main(String[] args) {
        System.out.println(new Solution().lastStoneWeight(
                new int[]{2, 7, 4, 1, 8, 1}
        ));
        System.out.println(new Solution().lastStoneWeight(
                new int[]{2, 2}
        ));
    }

    static class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            for (int stone : stones) {
                queue.add(stone);
            }
            while (queue.size() > 1) {
                int x = queue.poll();
                int y = queue.poll();
                if (x != y) {
                    int left = Math.abs(x - y);
                    queue.add(left);
                }
            }
            return queue.isEmpty() ? 0 : queue.poll();
        }
    }

}
