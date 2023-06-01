package leetcode.problems;

import java.util.Arrays;

public class Test2517_礼盒的最大甜蜜度 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumTastiness(
                new int[]{13, 5, 1, 8, 21, 2}, 3
        ));
        System.out.println(new Solution().maximumTastiness(
                new int[]{1, 3, 1}, 2
        ));
        System.out.println(new Solution().maximumTastiness(
                new int[]{7, 7, 7, 7}, 2
        ));
    }

    static class Solution {
        public int maximumTastiness(int[] price, int k) {
            // 二分不断试出满足个数大于k的甜蜜度
            Arrays.sort(price);
            int left = 0;
            int right = Integer.MAX_VALUE;
            while (left < right) {
                int t = left + (right - left) / 2;
                int cnt = getMaxCnt(price, t);
                if (k <= cnt) {
                    left = t + 1;
                } else {
                    right = t;
                }
            }
            return left - 1;
        }

        private int getMaxCnt(int[] price, int t) {
            int cnt = 1;
            int current = price[0];
            for (int i = 1; i < price.length; i++) {
                if (current <= price[i] - t) {
                    cnt++;
                    current = price[i];
                }
            }
            return cnt;
        }
    }

}
