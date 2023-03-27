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
            // 生成1-1000的质数
            generatePrimes();
            // 使用贪心，每个都尝试减去最大的质数，但同时要比前面的大
            Integer firstPrime = primes.lower(nums[0]);
            nums[0] -= firstPrime == null ? 0 : firstPrime;
            for (int i = 1; i < nums.length; i++) {
                int maxP = 0;
                if (primes.lower(nums[i] - nums[i - 1]) != null) {
                    maxP = primes.lower(nums[i] - nums[i - 1]);
                }
                if (nums[i] - maxP <= nums[i - 1]) {
                    return false;
                }
                nums[i] -= maxP;
            }
            return true;
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
