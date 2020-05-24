package leetcode.contest.week190;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test5419_两个子序列的最大点积 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxDotProduct(new int[]{2, 1, -2, 5}, new int[]{3, 0, -6}));
        System.out.println(new Solution().maxDotProduct(new int[]{3, -2}, new int[]{2, -6, 7}));
        System.out.println(new Solution().maxDotProduct(new int[]{-1, -1}, new int[]{1, 1}));
        System.out.println(new Solution().maxDotProduct(new int[]{-5, -1, -2}, new int[]{3, 3, 5, 5}));
        System.out.println(new Solution().maxDotProduct(new int[]{2, -4, -7, -9, -4}, new int[]{-9, -1, 1, -2, -2, -4, 5, 10, 9, 4}));
        System.out.println(new Solution().maxDotProduct(new int[]{13, -7, 12, -15, -7, 8, 3, -7, -5, 13, -15, -8, 5, 7, -1, 3, -11, -12, 2, -12}, new int[]{-1, 13, -4, -2, -13, 2, -4, 6, -9, 13, -8, -3, -9}));
    }

    static class Solution {
        public int maxDotProduct(int[] nums1, int[] nums2) {
            // dp[i][j]表示nums1[1..i]与nums[1..j]最大的点积
            int[][] dp = new int[505][505];
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    dp[i][j] = Integer.MIN_VALUE;
                }
            }
            // 三种情况：不包含nums1[i]、不包含nums2[j]、包含nums1[i]和nums2[j]（如果之前最大值状态为负数则重新开始积累）
            for (int i = 1; i <= nums1.length; i++) {
                for (int j = 1; j <= nums2.length; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = Math.max(dp[i][j], Math.max(0, dp[i - 1][j - 1]) + nums1[i - 1] * nums2[j - 1]);
                }
            }
            return dp[nums1.length][nums2.length];
        }
    }

    static class Solution_TLE {
        private Integer max = Integer.MIN_VALUE;
        private Boolean maxByNoOne = true;

        public int maxDotProduct(int[] nums1, int[] nums2) {
            // 递归枚举所有情况
            max = Integer.MIN_VALUE;
            maxByNoOne = true;
            List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
            List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
            check(list1, list2, 0, true);
            if (maxByNoOne) {
                max = list1.get(0) * list2.get(0);
                for (int i = 0; i < nums1.length; i++) {
                    for (int j = 0; j < nums2.length; j++) {
                        max = Math.max(max, nums1[i] * nums2[j]);
                    }
                }
            }
            return max;
        }

        private void check(List<Integer> list1, List<Integer> list2, int currentSum, boolean noOne) {
            if (list1.isEmpty() || list2.isEmpty()) {
                if (currentSum > max) {
                    max = currentSum;
                    maxByNoOne = noOne;
                }
                return;
            }
            // 可能要list[0]，也可能不要
            int list1First = list1.get(0);
            for (int i = 0; i < list2.size(); i++) {
                int point = list1First * list2.get(i);
                check(list1.subList(1, list1.size()), list2.subList(i + 1, list2.size()), currentSum + point, false);
            }
            check(list1.subList(1, list1.size()), list2, currentSum, true && noOne);
        }
    }

}
