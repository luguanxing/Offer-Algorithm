package leetcode.contest.week352;

import java.util.*;

public class Test6916_和等于目标值的质数对 {

    public static void main(String[] args) {
        System.out.println(new Solution().findPrimePairs(10));
        System.out.println(new Solution().findPrimePairs(2));
        System.out.println(new Solution().findPrimePairs(34));
    }

    static class Solution {
        public List<List<Integer>> findPrimePairs(int n) {
            Set<Integer> primes = generatePrimes(n);
            List<List<Integer>> pairs = new ArrayList<>();
            for (int prime : primes) {
                if (primes.contains(n - prime) && prime <= n - prime) {
                    pairs.add(Arrays.asList(prime, n - prime));
                }
            }
            return pairs;
        }

        private Set<Integer> generatePrimes(int max) {
            boolean[] isPrime = new boolean[max + 1];
            Arrays.fill(isPrime, 2, max + 1, true);
            for (int i = 2; i <= max; i++) {
                if (isPrime[i]) {
                    for (int j = i * 2; j <= max; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
            Set<Integer> primes = new TreeSet<>();
            for (int i = 2; i <= max; i++) {
                if (isPrime[i]) {
                    primes.add(i);
                }
            }
            return primes;
        }
    }

}
