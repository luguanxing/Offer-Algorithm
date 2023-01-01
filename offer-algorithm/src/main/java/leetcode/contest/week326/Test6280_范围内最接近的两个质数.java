package leetcode.contest.week326;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test6280_范围内最接近的两个质数 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().closestPrimes(10, 19)));
        System.out.println(Arrays.toString(new Solution().closestPrimes(4, 6)));
        System.out.println(Arrays.toString(new Solution().closestPrimes(7889, 875097)));
    }

    static class Solution {
        public int[] closestPrimes(int left, int right) {
            List<Integer> primes = new ArrayList<>();
            for (int i = left; i <= right; i++) {
                if (isPrime(i)) {
                    primes.add(i);
                }
            }
            int[] res = new int[]{-1, -1};
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < primes.size() - 1; i++) {
                if (primes.get(i + 1) - primes.get(i) < min) {
                    min = primes.get(i + 1) - primes.get(i);
                    res[0] = primes.get(i);
                    res[1] = primes.get(i + 1);
                }
            }
            return res;
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
