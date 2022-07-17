package leetcode.contest.week302;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Test6164_数位和相等数对的最大和 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumSum(new int[]{18, 43, 36, 13, 7}));
        System.out.println(new Solution().maximumSum(new int[]{10, 12, 19, 14}));
    }

    static class Solution {
        public int maximumSum(int[] nums) {
            Map<Integer, PriorityQueue<Integer>> sumMap = new HashMap<>();
            for (int num : nums) {
                int sum = getSum(num);
                PriorityQueue<Integer> queue = sumMap.getOrDefault(sum, new PriorityQueue<>(Comparator.reverseOrder()));
                queue.add(num);
                sumMap.put(sum, queue);
            }
            int max = -1;
            for (PriorityQueue<Integer> queue : sumMap.values()) {
                if (queue.size() < 2) {
                    continue;
                }
                int sum1 = queue.poll();
                int sum2 = queue.poll();
                max = Math.max(max, sum1 + sum2);
            }
            return max;
        }

        private int getSum(int num) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            return sum;
        }
    }

}
