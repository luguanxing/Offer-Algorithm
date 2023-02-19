package leetcode.contest.week333;

public class Test6365_将整数减少到零需要的最少操作数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(39));
        System.out.println(new Solution().minOperations(54));
    }

    static class Solution {
        public int minOperations(int n) {
            int step = 0;
            while (n != 0) {
                int pow1 = 1;
                for (int i = 1; i <= 20; i++) {
                    pow1 *= 2;
                    if (pow1 > n) {
                        break;
                    }
                }
                int pow2 = pow1 / 2;
                n = Math.min(pow1 - n, n - pow2);
                step++;
            }
            return step;
        }
    }

}
