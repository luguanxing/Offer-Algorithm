package leetcode.problems;

import java.util.Arrays;

public class Test1482_制作m束花所需的最少天数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minDays(
                new int[]{1, 10, 3, 10, 2},
                3, 1
        ));
        System.out.println(new Solution().minDays(
                new int[]{1, 10, 3, 10, 2},
                3, 2
        ));
        System.out.println(new Solution().minDays(
                new int[]{7, 7, 7, 7, 12, 7, 7},
                2, 3
        ));
        System.out.println(new Solution().minDays(
                new int[]{1000000000, 1000000000},
                1, 1
        ));
        System.out.println(new Solution().minDays(
                new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6},
                4, 2
        ));
    }

    static class Solution {
        public int minDays(int[] bloomDay, int m, int k) {
            if (m * k > bloomDay.length) {
                return -1;
            }
            // 二分试出最少天数
            int max = Arrays.stream(bloomDay).max().orElse(0);
            int min = Arrays.stream(bloomDay).min().orElse(0);
            while (min < max) {
                int mid = (int) ((long) (max + min) / 2);
                if (testOk(bloomDay, mid, m, k)) {
                    max = mid;
                } else {
                    min = mid + 1;
                }
            }
            return min;
        }

        private boolean testOk(int[] bloomDay, int mid, int m, int k) {
            int res = 0;
            int cnt = 0;
            for (int day : bloomDay) {
                if (day <= mid) {
                    cnt++;
                    if (cnt == k) {
                        cnt = 0;
                        res++;
                    }
                } else {
                    cnt = 0;
                }
            }
            return res >= m;
        }
    }

}
