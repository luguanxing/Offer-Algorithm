package leetcode.contest.week326;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test6279_数组乘积中的不同质因数数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().distinctPrimeFactors(new int[]{2, 4, 3, 7, 10, 6}));
        System.out.println(new Solution().distinctPrimeFactors(new int[]{2, 4, 8, 16}));
    }

    static class Solution {
        public int distinctPrimeFactors(int[] nums) {
            Set<Integer> primes = new TreeSet<>();
            for (int i = 1; i <= 1005; i++) {
                if (isPrime(i)) {
                    primes.add(i);
                }
            }
            Set<Integer> factors = new HashSet<>();
            for (int num : nums) {
                for (int prime : primes) {
                    while (num % prime == 0) {
                        factors.add(prime);
                        num /= prime;
                    }
                }
            }
            return factors.size();
        }

        private boolean isPrime(int n) {
            if (n == 1) {
                return false;
            }
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
