package leetcode.contest.week430;

public class Test100507_统计恰好有K个相等相邻元素的数组数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().countGoodArrays(3, 2, 1));
        System.out.println(new Solution().countGoodArrays(4, 2, 2));
        System.out.println(new Solution().countGoodArrays(5, 2, 0));
    }

    static class Solution {
        int MOD = (int) (1E9 + 7);
        int MAX = (int) (1E5 + 1);
        long[] factorial = new long[MAX];
        long[] invFactorial = new long[MAX];

        public int countGoodArrays(int n, int m, int k) {
            // 初始化阶乘和逆阶乘
            factorial[0] = 1;
            for (int i = 1; i < MAX; i++) {
                factorial[i] = factorial[i - 1] * i % MOD;
            }
            invFactorial[MAX - 1] = pow(factorial[MAX - 1], MOD - 2);
            for (int i = MAX - 2; i >= 0; i--) {
                invFactorial[i] = invFactorial[i + 1] * (i + 1) % MOD;
            }
            // 计算组合数，有C(n-1, k) 种组合
            long comb = comb(n - 1, k);
            // 快速幂，相同位置有m种选择，不同位置有(m-1)种
            long power = pow(m - 1, n - 1 - k);
            // res = m * C(n-1, k) * (m-1)^(n-1-k)
            long res = m;
            res *= comb;
            res %= MOD;
            res *= power;
            res %= MOD;
            return (int) res;
        }

        private long comb(int n, int k) {
            if (k < 0 || k > n) {
                return 0;
            }
            return factorial[n] * invFactorial[k] % MOD * invFactorial[n - k] % MOD;
        }

        private long pow(long a, long b) {
            long res = 1;
            a %= MOD;
            while (b > 0) {
                if ((b & 1) == 1) {
                    res = res * a % MOD;
                }
                a = a * a % MOD;
                b >>= 1;
            }
            return res;
        }
    }

}
