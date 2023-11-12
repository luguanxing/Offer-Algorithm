package leetcode.contest.week371;

import java.util.*;

public class Test100117_最大化数组末位元素的最少操作次数 {

    public static void main(String[] args) {
        // nums1 = [1,2,7]，nums2 = [4,5,3]
        System.out.println(new Solution().minOperations(
                new int[]{1, 2, 7},
                new int[]{4, 5, 3}
        ));
        // nums1 = [2,3,4,5,9]，nums2 = [8,8,4,4,4]
        System.out.println(new Solution().minOperations(
                new int[]{2, 3, 4, 5, 9},
                new int[]{8, 8, 4, 4, 4}
        ));
        // nums1 = [1,5,4]，nums2 = [2,5,3]
        System.out.println(new Solution().minOperations(
                new int[]{1, 5, 4},
                new int[]{2, 5, 3}
        ));
        System.out.println(new Solution().minOperations(
                new int[]{1},
                new int[]{1}
        ));
        // [1,4,16]
        //[16,16,16]
        System.out.println(new Solution().minOperations(
                new int[]{1, 4, 16},
                new int[]{16, 16, 16}
        ));
        // [10,18,12,12]
        //[19,6,5,12]
        System.out.println(new Solution().minOperations(
                new int[]{10, 18, 12, 12},
                new int[]{19, 6, 5, 12}
        ));
    }

    static class Solution {
        public int minOperations(int[] nums1, int[] nums2) {
            int len = nums1.length;
            int last1 = nums1[len - 1];
            int last2 = nums2[len - 1];
            // 二分法试出最少天数
            int ans1 = tryLast(nums1, nums2, last1, last2);
            int ans2 = tryLast(nums1, nums2, last2, last1);
            if (ans1 == -1 && ans2 == -1) {
                return -1;
            } else if (ans1 == -1) {
                return ans2;
            } else if (ans2 == -1) {
                return ans1;
            }
            return Math.min(ans1, ans2 + 1);
        }

        private int tryLast(int[] nums1, int[] nums2, int last1, int last2) {
            int len = nums1.length;
            nums1 = Arrays.copyOfRange(nums1, 0, len - 1);
            nums2 = Arrays.copyOfRange(nums2, 0, len - 1);
            int max = len - 1;
            int min = 0;
            while (min < max) {
                int mid = (max + min) / 2;
                boolean isOk = tryNtimes(nums1, nums2, mid, last1, last2);
                if (isOk) {
                    max = mid;
                } else {
                    min = mid + 1;
                }
            }
            boolean isOk = nums1.length == 0 || tryNtimes(nums1, nums2, min, last1, last2);
            if (isOk) {
                return min;
            }
            return -1;
        }

        private boolean tryNtimes(int[] nums1, int[] nums2, int n, int last1, int last2) {
            int need = 0;
            for (int i = 0; i < nums1.length; i++) {
                if (nums1[i] <= last1 && nums2[i] <= last2) {
                    continue;
                }
                if (nums1[i] > last1 && nums1[i] <= last2 && nums2[i] <= last1) {
                    need++;
                } else if (nums2[i] > last2 && nums2[i] <= last1 && nums1[i] <= last2) {
                    need++;
                } else {
                    return false;
                }
            }
            return need <= n;
        }
    }


}
