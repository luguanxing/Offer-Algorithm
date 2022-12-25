package leetcode.contest.week325;

import java.util.Arrays;

public class Test6271_礼盒的最大甜蜜度 {

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
        System.out.println(new Solution().maximumTastiness(
                new int[]{34, 116, 83, 15, 150, 56, 69, 42, 26}, 6
        ));
        System.out.println(new Solution().maximumTastiness(
                new int[]{144, 69, 103, 148, 184, 50, 129, 154, 2}, 4
        ));
    }

    static class Solution {
        public int maximumTastiness(int[] price, int k) {
            int len = price.length;
            Arrays.sort(price);
            int[] diff = new int[len];
            for (int i = 1; i < len; i++) {
                diff[i] = price[i] - price[i - 1];
            }
            // 使用二分试出能分成超过k组的最大甜蜜度X
            int max = Integer.MAX_VALUE;
            int min = 0;
            while (min < max) {
                int mid = (max + min) / 2;
                int count = getGroupCnt(diff, mid);
                if (count < k) {
                    max = mid;
                } else {
                    min = mid + 1;
                }
            }
            return max - 1;
        }

        private int getGroupCnt(int[] diff, int mid) {
            int cnt = 1;
            int sum = 0;
            for (int d : diff) {
                sum += d;
                if (sum >= mid) {
                    cnt++;
                    sum = 0;
                }
            }
            return cnt;
        }
    }

}
