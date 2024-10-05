package leetcode.problems;

public class Test2187_完成旅途的最少时间 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumTime(new int[]{1, 2, 3}, 5));
        System.out.println(new Solution().minimumTime(new int[]{2}, 1));
        System.out.println(new Solution().minimumTime(new int[]{39,82,69,37,78,14,93,36,66,61,13,58,57,12,70,14,67,75,91,1,34,68,73,50,13,40,81,21,79,12,35,18,71,43,5,50,37,16,15,6,61,7,87,43,27,62,95,45,82,100,15,74,33,95,38,88,91,47,22,82,51,19,10,24,87,38,5,91,10,36,56,86,48,92,10,26,63,2,50,88,9,83,20,42,59,55,8,15,48,25}, 4187));
    }

    static class Solution {
        public long minimumTime(int[] time, int totalTrips) {
            long l = 0;
            long r = Long.MAX_VALUE;
            while (l < r) {
                long mid = l + (r - l) / 2;
                if (isOk(time, totalTrips, mid)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }

        private boolean isOk(int[] time, int totalTrips, long availableTime) {
            long finishedTrips = 0;
            for (int t : time) {
                finishedTrips += availableTime / t;
                if (finishedTrips >= totalTrips) {
                    return true;
                }
            }
            return finishedTrips >= totalTrips;
        }
    }

}
