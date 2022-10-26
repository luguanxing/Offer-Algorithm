package leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test0862_和至少为K的最短子数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().shortestSubarray(
                new int[]{1}, 1
        ));
        System.out.println(new Solution().shortestSubarray(
                new int[]{1, 2}, 4
        ));
        System.out.println(new Solution().shortestSubarray(
                // 0, 2, 1, 3
                new int[]{2, -1, 2}, 3
        ));
        System.out.println(new Solution().shortestSubarray(
                // 0, 2, 1, 3, 5
                new int[]{2, -1, 2, 2}, 3
        ));
    }

    static class Solution {
        public int shortestSubarray(int[] nums, int k) {
            int len = nums.length;
            long sum = 0;
            long res = Integer.MAX_VALUE;

            Deque<long[]> deque = new ArrayDeque<>();
            deque.add(new long[]{0, -1});
            for (int i = 0; i < len; i++) {
                sum += nums[i];
                // 若sum-deque.head[0]>=k，那么后面即再成立，也不可能比i-deque.head[1]更小，所以deque前面可以排除
                while (!deque.isEmpty() && sum - deque.peekFirst()[0] >= k) {
                    res = Math.min(res, i - deque.pollFirst()[1]);
                }
                // 若deque.last[0]>sum，那么后面到序号到i肯定比后面序号到 deque.last[1]更小，所以deque后面可以排除
                while (!deque.isEmpty() && deque.peekLast()[0] > sum) {
                    deque.pollLast();
                }
                deque.add(new long[]{sum, i});
            }

            return res == Integer.MAX_VALUE ? -1 : (int) res;
        }
    }

    static class Solution_暴力 {
        public int shortestSubarray(int[] nums, int k) {
            int len = nums.length;
            int currentSum = 0;
            int res = Integer.MAX_VALUE;
            int[] sum = new int[len + 1];
            for (int i = 0; i < len; i++) {
                currentSum += nums[i];
                sum[i + 1] = currentSum;
                for (int j = i; j >= 0; j--) {
                    if (currentSum - sum[j] >= k) {
                        res = Math.min(res, i - j + 1);
                        break;
                    }
                }
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }

}
