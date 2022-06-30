package leetcode.problems;

public class Test0175_质数排列 {

    public static void main(String[] args) {
        System.out.println(new Solution().numPrimeArrangements(5));
        System.out.println(new Solution().numPrimeArrangements(100));
    }

    static class Solution {
        public int numPrimeArrangements(int n) {
            int primeCount = getPrimeCount(n);
            int otherCount = n - primeCount;
            int MOD = 1000000007;
            long res = 1;
            for (int i = 1; i <= primeCount; i++) {
                res *= i;
                res %= MOD;
            }
            for (int i = 1; i <= otherCount; i++) {
                res *= i;
                res %= MOD;
            }
            return (int) res;
        }

        private int getPrimeCount(int n) {
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (isPrime(i)) {
                    cnt++;
                }
            }
            return cnt;
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
