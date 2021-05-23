package leetcode.contest.week242;

import java.util.Arrays;

public class Test5764_准时到达的列车最小时速 {

    public static void main(String[] args) {
        System.out.println(new Solution().minSpeedOnTime(
                new int[]{1, 3, 2}, 6
        ));
        System.out.println(new Solution().minSpeedOnTime(
                new int[]{1, 3, 2}, 2.7
        ));
        System.out.println(new Solution().minSpeedOnTime(
                new int[]{1, 3, 2}, 1.9
        ));
        System.out.println(new Solution().minSpeedOnTime(
                new int[]{1, 1, 100000}, 2.01
        ));
    }

    static class Solution {
        public int minSpeedOnTime(int[] dist, double hour) {
            if (dist.length > Math.ceil(hour)) {
                return -1;
            }
            int right = Arrays.stream(dist).max().orElse(0) * 100;
            int left = 1;
            while (left < right) {
                int mid = (right + left) / 2;
                boolean isOk = checkSpeed(dist, hour, mid);
                if (isOk) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean checkSpeed(int[] dist, double hour, int speed) {
            double total = 0;
            for (int i = 0; i < dist.length - 1; i++) {
                total += Math.ceil(dist[i] * 1.0 / speed);
            }
            total += dist[dist.length - 1] * 1.0 / speed;
            return total <= hour;
        }
    }

}
