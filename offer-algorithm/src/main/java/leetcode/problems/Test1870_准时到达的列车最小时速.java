package leetcode.problems;

public class Test1870_准时到达的列车最小时速 {

    public static void main(String[] args) {
        System.out.println(new Solution().minSpeedOnTime(new int[]{1, 3, 2}, 6));
        System.out.println(new Solution().minSpeedOnTime(new int[]{1, 3, 2}, 2.7));
        System.out.println(new Solution().minSpeedOnTime(new int[]{1, 3, 2}, 1.9));
    }

    static class Solution {
        public int minSpeedOnTime(int[] dist, double hour) {
            int l = 0;
            int r = Integer.MAX_VALUE;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (isOk(dist, hour, mid)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return r==Integer.MAX_VALUE ? - 1 : l;
        }

        private boolean isOk(int[] dist, double hour, int speed) {
            double costTime = 0;
            for (int i = 0; i < dist.length; i++) {
                int d = dist[i];
                if (i != dist.length - 1) {
                    costTime += Math.ceil((1.0 * d) / speed);
                } else {
                costTime += (1.0 * d) / speed;
                }
            }
            return costTime <= hour;
        }
    }

}
