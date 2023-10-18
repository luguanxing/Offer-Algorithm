package leetcode.problems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test2530_执行K次操作后的最大分数 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxKelements(new int[]{10, 10, 10, 10, 10}, 5));
        System.out.println(new Solution().maxKelements(new int[]{1, 10, 3, 3, 3}, 3));
    }

    static class Solution {
        public long maxKelements(int[] nums, int k) {
            Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            for (int num : nums) {
                queue.add(num);
            }
            long sum = 0;
            for (int i = 1; i <= k; i++) {
                int num = queue.poll();
                sum += num;
                queue.add((int) Math.ceil(num/3.0));
            }
            return sum;
        }
    }

}
