package leetcode.contest.week299;

import java.util.Arrays;

public class Test5229_拼接数组的最大分数 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumsSplicedArray(
                new int[]{60, 60, 60},
                new int[]{10, 90, 10}
        ));
        System.out.println(new Solution().maximumsSplicedArray(
                new int[]{20, 40, 20, 70, 30},
                new int[]{50, 20, 50, 40, 20}
        ));
        System.out.println(new Solution().maximumsSplicedArray(
                new int[]{7, 11, 13},
                new int[]{1, 1, 1}
        ));
    }

    static class Solution {
        public int maximumsSplicedArray(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int sum1 = Arrays.stream(nums1).sum();
            int sum2 = Arrays.stream(nums2).sum();
            // diff[i]表示把对方nums[i]换过来的能变大多少
            int[] diff1 = new int[n];
            int[] diff2 = new int[n];
            for (int i = 0; i < n; i++) {
                diff1[i] = nums2[i] - nums1[i];
                diff2[i] = nums1[i] - nums2[i];
            }
            // 求出各自替换的能变大的最大范围，再加上原本自身和
            int max1 = 0;
            int currentMax1 = 0;
            for (int i = 0; i < n; i++) {
                currentMax1 += diff1[i];
                if (currentMax1 < 0) {
                    currentMax1 = 0;
                }
                max1 = Math.max(max1, currentMax1);
            }
            int max2 = 0;
            int currentMax2 = 0;
            for (int i = 0; i < n; i++) {
                currentMax2 += diff2[i];
                if (currentMax2 < 0) {
                    currentMax2 = 0;
                }
                max2 = Math.max(max2, currentMax2);
            }
            return Math.max(sum1 + max1, sum2 + max2);
        }
    }

}
