package leetcode.contest.week338;

import java.util.TreeSet;

public class Test6355_质数减法运算 {

    public static void main(String[] args) {
        System.out.println(new Solution().primeSubOperation(new int[]{4, 9, 6, 10}));
        System.out.println(new Solution().primeSubOperation(new int[]{6, 8, 11, 12}));
        System.out.println(new Solution().primeSubOperation(new int[]{5, 8, 3}));
        System.out.println(new Solution().primeSubOperation(new int[]{2, 2}));
    }

    static class Solution {
        TreeSet<Integer> primes = new TreeSet<>();

        public boolean primeSubOperation(int[] nums) {
            generatePrimes();
            nums[0] -= getLatestPrime(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                int maxP = 0;
                for (int p : primes) {
                    if (nums[i] - p > nums[i - 1]) {
                        maxP = p;
                    }
                }
                if (nums[i] - maxP <= nums[i - 1]) {
                    return false;
                }
                nums[i] -= maxP;
            }
            return true;
        }

        private int getLatestPrime(int num) {
            return primes.lower(num) == null ? 0 : primes.lower(num);
        }

        private void generatePrimes() {
            for (int i = 1; i <= 1000; i++) {
                if (isPrime(i)) {
                    primes.add(i);
                }
            }
        }

        private static boolean isPrime(int num) {
            if (num < 2) {
                return false;
            }
            int sqrt = 1 + (int) Math.sqrt(num);
            for (int i = 2; i < sqrt; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
