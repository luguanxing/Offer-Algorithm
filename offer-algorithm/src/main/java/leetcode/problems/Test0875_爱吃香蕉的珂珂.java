package leetcode.problems;

import java.util.Arrays;

public class Test0875_爱吃香蕉的珂珂 {

    public static void main(String[] args) {
        System.out.println(new Solution().minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(new Solution().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(new Solution().minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
        System.out.println(new Solution().minEatingSpeed(new int[]{312884470}, 968709470));
    }

    static class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            // 二分查找满足条件的最小左边界
            int left = 1;
            int right = Integer.MAX_VALUE / 2;
            while (left < right) {
                int mid = (left + right) / 2;
                if (canFinish(mid, piles, h)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean canFinish(int eat, int[] piles, int h) {
            int costTime = 0;
            for (int pile : piles) {
                if (pile % eat > 0) {
                    costTime++;
                }
                costTime += pile / eat;
            }
            return costTime <= h;
        }
    }

}
