package leetcode.problems;

public class Test2594_修车的最少时间 {

    public static void main(String[] args) {
        System.out.println(new Solution().repairCars(
                new int[]{4, 2, 3, 1}, 10
        ));
        System.out.println(new Solution().repairCars(
                new int[]{5, 1, 8}, 6
        ));
        System.out.println(new Solution().repairCars(
                new int[]{100}, 1000000
        ));
    }

    static class Solution {
        public long repairCars(int[] ranks, int cars) {
            // 二分试出最小的时间
            long right = Long.MAX_VALUE / 2;
            long left = 1L;
            while (left < right) {
                long mid = left + (right - left) / 2;
                if (isTimeLimitOk(ranks, cars, mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean isTimeLimitOk(int[] ranks, int cars, long timeLimit) {
            long finishedCars = 0;
            for (int rank : ranks) {
                finishedCars += (long) Math.sqrt(timeLimit / rank);
            }
            return finishedCars >= cars;
        }
    }

}
