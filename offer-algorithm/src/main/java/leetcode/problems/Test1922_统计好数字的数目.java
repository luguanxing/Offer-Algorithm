package leetcode.problems;

public class Test1922_统计好数字的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().countGoodNumbers(1));
        System.out.println(new Solution().countGoodNumbers(2));
        System.out.println(new Solution().countGoodNumbers(3));
        System.out.println(new Solution().countGoodNumbers(4));
        System.out.println(new Solution().countGoodNumbers(50));
    }

    static class Solution {
        public int countGoodNumbers(long n) {
            int MOD = (int)1e9 + 7;
            if (n % 2 == 0) {
                // 如果n为偶数, 20放入其中一起计算
                return (int) modPow(20, n / 2, MOD);
            } else {
                // 如果n为奇数，5单独抽出来
                return (int) ((5 * modPow(20, (n - 1) / 2, MOD)) % MOD);
            }
        }

        /**
         * 使用快速幂算法计算 (a^b) mod mod
         */
        private long modPow(long a, long b, int mod) {
            long result = 1;
            a %= mod;
            while (b > 0) {
                if ((b & 1) == 1) {  // b 为奇数时，将 a 乘到结果中
                    result = (result * a) % mod;
                }
                a = (a * a) % mod; // 每次将 a 平方
                b >>= 1;           // b 右移一位，相当于除以2
            }
            return result;
        }
    }

    static class Solution_暴力 {
        public int countGoodNumbers(long n) {
            if (n == 1) {
                return 5;
            }
            if (n == 1) {
                return 20;
            }
            // 暴力计算 dp[i] = dp[i-2] * dp[2]
            int MOD = (int)(1E9+7);
            long start = 0;
            long times = 0;
            if (n % 2 == 1) {
                start = 5;
                times = (n-1) / 2;
            } else {
                start = 20;
                times = (n-2) / 2;
            }
            long res = start;
            for (int i = 1; i <= times; i++) {
                res *= 20;
                res %= MOD;
            }
            return (int)res;
        }
    }

}
