package leetcode.contest.week324;

import java.util.Set;
import java.util.TreeSet;

public class Test6266_使用质因数之和替换后可以取到的最小值 {

    public static void main(String[] args) {
        System.out.println(new Solution().smallestValue(15));
        System.out.println(new Solution().smallestValue(3));
        System.out.println(new Solution().smallestValue(99951));
    }

    static class Solution {
        Set<Integer> primes = new TreeSet<>();

        public int smallestValue(int n) {
            generatePrimes();
            int min = n;
            while (min == n) {
                n = findNext(n);
                if (n < min) {
                    min = n;
                } else {
                    break;
                }
            }
            return min;
        }

        private void generatePrimes() {
            for (int i = 1; i <= 100005; i++) {
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

        private int findNext(int n) {
            int sum = 0;
            for (int prime : primes) {
                while (n % prime == 0) {
                    sum += prime;
                    n /= prime;
                }
            }
            return sum;
        }
    }

}
