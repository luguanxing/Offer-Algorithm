package leetcode.contest.week414;

import java.util.Arrays;

public class Test100353_范围内整数的最大得分 {

    public static void main(String[] args) {
        // start = [6,0,3], d = 2
        System.out.println(new Solution().maxPossibleScore(new int[]{6, 0, 3}, 2));
        // start = [2,6,13,13], d = 5
        System.out.println(new Solution().maxPossibleScore(new int[]{2, 6, 13, 13}, 5));
        System.out.println(new Solution().maxPossibleScore(new int[]{0, 3, 4}, 2));
        System.out.println(new Solution().maxPossibleScore(new int[]{1000000000, 1000000000}, 1000000000));
    }

    static class Solution {
        public int maxPossibleScore(int[] start, int d) {
            Arrays.sort(start);
            // 找到区间的最小左边界和最大右边界
            int minStart = start[0];
            int maxEnd = start[start.length - 1] + d;
            // 二分查找得分 k 的最大可能值
            int left = 1, right = maxEnd;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (canSelect(start, d, mid)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return right;
        }

        private boolean canSelect(int[] start, int d, int k) {
            long lastSelected = start[0];
            for (int i = 1; i < start.length; i++) {
                long minPossible = lastSelected + k;
                if (minPossible > start[i] + d) {
                    return false;
                }
                lastSelected = Math.max(start[i], minPossible);
            }
            return true;
        }
    }

}
