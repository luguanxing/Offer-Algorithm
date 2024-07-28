package leetcode.contest.week408;

import java.util.*;

public class Q2_统计不是特殊数字的数字数量 {

    public static void main(String[] args) {
        System.out.println(new Solution().nonSpecialCount(5, 7));
        System.out.println(new Solution().nonSpecialCount(4, 16));
    }

    static class Solution {
        public int nonSpecialCount(int l, int r) {
            TreeSet<Integer> squares = new TreeSet<>();
            int start = (int) Math.ceil(Math.sqrt(l));
            int end = (int) Math.floor(Math.sqrt(r));
            for (int i = start; i <= end; i++) {
                // 只有质数的平方才是特殊数字
                if (isPrime(i)) {
                    squares.add(i * i);
                }
            }
            return r - l + 1 - squares.size();
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
