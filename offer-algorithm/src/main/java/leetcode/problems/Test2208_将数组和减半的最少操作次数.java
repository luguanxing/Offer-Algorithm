package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test2208_将数组和减半的最少操作次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().halveArray(new int[]{5, 19, 8, 1}));
        System.out.println(new Solution().halveArray(new int[]{3, 8, 20}));
        System.out.println(new Solution().halveArray(new int[]{1}));
    }

    static class Solution {
        public int halveArray(int[] nums) {
            PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
            double sum = 0;
            for (int num : nums) {
                pq.add(num * 1.0);
                sum += num;
            }
            int cnt = 0;
            double currentSum = sum;
            while (currentSum > sum / 2) {
                double num = pq.poll();
                currentSum -= num / 2;
                pq.add(num / 2);
                cnt++;
            }
            return cnt;
        }
    }

}
