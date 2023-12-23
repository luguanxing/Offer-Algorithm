package leetcode.problems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Test1962_移除石子使总数最小 {

    public static void main(String[] args) {
        System.out.println(new Solution().minStoneSum(new int[]{5, 4, 9}, 2));
        System.out.println(new Solution().minStoneSum(new int[]{4, 3, 6, 7},3));
    }

    static class Solution {
        public int minStoneSum(int[] piles, int k) {
            int sum = Arrays.stream(piles).sum();
            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for (int pile : piles) {
                queue.add(pile);
            }
            int totalTake = 0;
            for (int i = 1; i <= k; i++) {
                int current = queue.poll();
                int take = current / 2;
                int left = current - take;
                totalTake += take;
                queue.add(left);
            }
            return sum - totalTake;
        }
    }

}
