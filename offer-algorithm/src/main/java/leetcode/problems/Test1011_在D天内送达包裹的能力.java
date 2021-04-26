package leetcode.problems;

import java.util.Arrays;

public class Test1011_在D天内送达包裹的能力 {

    public static void main(String[] args) {
        System.out.println(new Solution().shipWithinDays(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                5
        ));
        int[] test = new int[10000];
        Arrays.fill(test, 1);
        System.out.println(new Solution().shipWithinDays(
                test,
                1
        ));
    }

    static class Solution {
        public int shipWithinDays(int[] weights, int D) {
            int left = Arrays.stream(weights).max().orElse(0);
            int right = Arrays.stream(weights).sum();
            while (left < right) {
                int mid = (left + right) / 2;
                int costDays = useCapacityCostDays(weights, mid);
                if (costDays <= D) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        public int shipWithinDays_穷举(int[] weights, int D) {
            for (int capacity = 1; capacity <= 50000 * 500; capacity++) {
                int costDays = useCapacityCostDays(weights, capacity);
                if (costDays <= D) {
                    return capacity;
                }
            }
            return weights.length;
        }

        private int useCapacityCostDays(int[] weights, int capacity) {
            int res = 0;
            int current = 0;
            for (int weight : weights) {
                if (weight > capacity) {
                    // overweight
                    return weights.length + 1;
                }
                if (current + weight <= capacity) {
                    current += weight;
                } else {
                    current = weight;
                    res++;
                }
            }
            if (current != 0) {
                res++;
            }
            return res;
        }
    }

}
