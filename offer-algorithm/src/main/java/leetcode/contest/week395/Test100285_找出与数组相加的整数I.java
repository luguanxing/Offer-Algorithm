package leetcode.contest.week395;

import java.util.Arrays;

public class Test100285_找出与数组相加的整数I {

    public static void main(String[] args) {
        // nums1 = [2,6,4], nums2 = [9,7,5]
        System.out.println(new Solution().addedInteger(new int[]{2, 6, 4}, new int[]{9, 7, 5}));
        // nums1 = [10], nums2 = [5]
        System.out.println(new Solution().addedInteger(new int[]{10}, new int[]{5}));
        // nums1 = [1,1,1,1], nums2 = [1,1,1,1]
        System.out.println(new Solution().addedInteger(new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 1}));
    }

    static class Solution {
        public int addedInteger(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            return nums2[0] - nums1[0];
        }
    }

}
