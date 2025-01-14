package leetcode.problems;

import java.util.PriorityQueue;

public class Test3066_超过阈值的最少操作数II {

    public static void main(String[] args) {
        // nums = [2,11,10,1,3], k = 10
        System.out.println(new Solution().minOperations(new int[]{2, 11, 10, 1, 3}, 10));
        // nums = [1,1,2,4,9], k = 20
        System.out.println(new Solution().minOperations(new int[]{1, 1, 2, 4, 9}, 20));
        System.out.println(new Solution().minOperations(new int[]{999999999, 999999999, 999999999}, 1000000000));
    }

    static class Solution {
        public int minOperations(int[] nums, int k) {
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < nums.length; i++) {
                pq.add((long) nums[i]);
            }
            int cnt = 0;
            while (pq.peek() < k) {
                long x = pq.poll();
                long y = pq.poll();
                pq.add(Math.min(x, y) * 2 + Math.max(x, y));
                cnt++;
            }
            return cnt;
        }
    }

}
