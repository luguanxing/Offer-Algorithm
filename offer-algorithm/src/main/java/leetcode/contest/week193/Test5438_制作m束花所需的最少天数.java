package leetcode.contest.week193;

import java.util.Arrays;

public class Test5438_制作m束花所需的最少天数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
        System.out.println(new Solution().minDays(new int[]{1, 10, 3, 10, 2}, 3, 2));
        System.out.println(new Solution().minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3));
        System.out.println(new Solution().minDays(new int[]{1000000000, 1000000000}, 1, 1));
        System.out.println(new Solution().minDays(new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6}, 4, 2));
        System.out.println(new Solution().minDays(new int[]{5, 37, 55, 92, 22, 52, 31, 62, 99, 64, 92, 53, 34, 84, 93, 50, 28}, 8, 2));
    }

    static class Solution {
        public int minDays(int[] bloomDay, int m, int k) {
            if (bloomDay.length < m * k) {
                return -1;
            }
            // 二分法试出最少天数
            int max = Arrays.stream(bloomDay).max().orElse(0);
            int min = 0;
            while (min < max) {
                int mid = (max + min) / 2;
                int count = getGroupCount(bloomDay, mid, k);
                if (count < m) {
                    min = mid + 1;
                } else {
                    max = mid;
                }
            }
            return min;
        }

        private int getGroupCount(int[] bloomDay, int waitDays, int k) {
            int result = 0;
            int count = 0;
            // 试出连续几组等待k天
            for (int i = 0; i < bloomDay.length; i++) {
                if (bloomDay[i] <= waitDays) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == k) {
                    result++;
                    count = 0;
                }
            }
            return result;
        }
    }

}
