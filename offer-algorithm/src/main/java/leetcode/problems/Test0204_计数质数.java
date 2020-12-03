package leetcode.problems;

public class Test0204_计数质数 {

    public static void main(String[] args) {
        System.out.println(new Solution().countPrimes(10));
        System.out.println(new Solution().countPrimes(0));
        System.out.println(new Solution().countPrimes(1));
        System.out.println(new Solution().countPrimes(2));
    }

    static class Solution {
        public int countPrimes(int n) {
            int res = 0;
            for (int i = 2; i < n; i++) {
                if (isPrime(i)) {
                    res++;
                }
            }
            return res;
        }

        private boolean isPrime(int n) {
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
