package leetcode.problems;

public class Test0357_统计各位数字都不同的数字个数 {

    public static void main(String[] args) {
        System.out.println(new Solution().countNumbersWithUniqueDigits(0));
        System.out.println(new Solution().countNumbersWithUniqueDigits(1));
        System.out.println(new Solution().countNumbersWithUniqueDigits(2));
        System.out.println(new Solution().countNumbersWithUniqueDigits(3));
    }

    static class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0) {
                return 1;
            }
            // 使用排列计算
            // 用1位组成不同的数 -> A(10,1)=10
            // 用2位组成不同的数,去掉0开头 -> A(10,2)-A(9,1)=90-9=81
            // 用3位组成不同的数,去掉0开头 -> A(10,3)-A(9,2)=720-72=648
            int res = 0;
            for (int i = 1; i <= n; i++) {
                // res += A(10,N) - A(9,N-1)
                int a10n = 1;
                int a9n_1 = i > 1 ? 1 : 0;
                for (int j = 0; j < i; j++) {
                    a10n *= (10 - j);
                }
                for (int j = 0; j < i - 1; j++) {
                    a9n_1 *= (9 - j);
                }
                res += a10n - a9n_1;
            }
            return res;
        }
    }

}
