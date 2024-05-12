package leetcode.problems;

import java.util.*;

public class Test1553_吃掉N个橘子的最少天数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minDays(10));
        System.out.println(new Solution().minDays(6));
        System.out.println(new Solution().minDays(1));
        System.out.println(new Solution().minDays(56));
    }

    static class Solution {
        Map<Integer, Integer> memo = new HashMap<>();

        public int minDays(int n) {
            if (n <= 1) {
                return n;
            }
            if (memo.containsKey(n)) {
                return memo.get(n);
            }
            // 尝试吃n%步2到2的倍数，然后花一步吃一半，再递归试n/2
            int try2 = n % 2 + 1 + minDays(n / 2);
            // 尝试吃n%步3到3的倍数，然后花一步吃1/3，再递归试n/3
            int try3 = n % 3 + 1 + minDays(n / 3);
            int res = Math.min(try2, try3);
            memo.put(n, res);
            return res;
        }
    }

}
