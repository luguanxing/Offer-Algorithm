package leetcode.contest.week288;

import java.util.PriorityQueue;

public class Test6039_K次增加后的最大乘积 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumProduct(new int[]{0, 4}, 5));
        System.out.println(new Solution().maximumProduct(new int[]{6, 3, 3, 2}, 2));
    }

    static class Solution {
        public int maximumProduct(int[] nums, int k) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            for (int num : nums) {
                priorityQueue.add(num);
            }
            while (k > 0) {
                int smallest = priorityQueue.poll();
                priorityQueue.add(smallest + 1);
                k--;
            }
            long res = 1;
            for (int num : priorityQueue) {
                res *= num;
                res %= 1000000007;
            }
            return (int) res;
        }
    }

}
