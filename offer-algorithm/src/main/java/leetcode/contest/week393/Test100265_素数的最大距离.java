package leetcode.contest.week393;

import java.util.*;

public class Test100265_素数的最大距离 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumPrimeDifference(new int[]{4, 2, 9, 5, 3}));
        System.out.println(new Solution().maximumPrimeDifference(new int[]{4, 8, 2, 8}));
        System.out.println(new Solution().maximumPrimeDifference(new int[]{2, 2}));
    }

    static class Solution {
        public int maximumPrimeDifference(int[] nums) {
            List<Integer> primeIndices = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (isPrime(nums[i])) {
                    primeIndices.add(i);
                }
            }
            if (primeIndices.size() < 2) {
                return 0;
            }
            int maxIndex = primeIndices.get(primeIndices.size() - 1);
            int minIndex = primeIndices.get(0);
            return maxIndex - minIndex;
        }

        private boolean isPrime(int num) {
            if (num < 2) {
                return false;
            }
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }


}
