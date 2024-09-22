package leetcode.contest.week416;

public class Test100363_移山所需的最少秒数 {

    public static void main(String[] args) {
        // mountainHeight = 4, workerTimes = [2,1,1]
        System.out.println(new Solution().minNumberOfSeconds(4, new int[]{2, 1, 1}));
        // mountainHeight = 10, workerTimes = [1,3,4]
        System.out.println(new Solution().minNumberOfSeconds(10, new int[]{3,2,2,4}));
        // mountainHeight = 5, workerTimes = [1]
        System.out.println(new Solution().minNumberOfSeconds(5, new int[]{1}));
    }

    static  class Solution {
        public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
            long left = 0, right = Long.MAX_VALUE;
            while (left < right) {
                long mid = left + (right - left) / 2;
                // 二分尝试最出最小的t
                if (canFinish(mid, mountainHeight, workerTimes)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean canFinish(long t, int mountainHeight, int[] workerTimes) {
            long sum = 0;
            for (int workerTime : workerTimes) {
                // 计算每个工人t内的工作量
                long l = 0, r = mountainHeight;
                while (l < r) {
                    long mid = (l + r + 1) / 2;
                    long totalTime = workerTime * mid * (mid + 1) / 2;
                    if (totalTime <= t) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                sum += l;
                if (sum >= mountainHeight) {
                    return true;
                }
            }
            return sum >= mountainHeight;
        }
    }

}
