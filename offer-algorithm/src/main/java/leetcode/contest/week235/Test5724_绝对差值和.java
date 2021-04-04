package leetcode.contest.week235;

import java.math.BigInteger;
import java.util.Arrays;

public class Test5724_绝对差值和 {

    public static void main(String[] args) {
        System.out.println(new Solution().minAbsoluteSumDiff(
                new int[]{1, 7, 5},
                new int[]{2, 3, 5}
        ));
        System.out.println(new Solution().minAbsoluteSumDiff(
                new int[]{2, 4, 6, 8, 10},
                new int[]{2, 4, 6, 8, 10}
        ));
        System.out.println(new Solution().minAbsoluteSumDiff(
                new int[]{1, 10, 4, 4, 2, 7},
                new int[]{9, 3, 5, 1, 7, 4}
        ));
    }

    static class Solution {
        public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
            // init state
            int len = nums1.length;
            int[] diff = new int[len];
            for (int i = 0; i < len; i++) {
                diff[i] = Math.abs(nums1[i] - nums2[i]);
            }
            // find Max diff
            int maxDiff = diff[0];
            int maxDiffIndex = 0;
            for (int i = 1; i < len; i++) {
                if (diff[i] > maxDiff) {
                    maxDiff = diff[i];
                    maxDiffIndex = i;
                }
            }
            // find replacement
            int minDiff = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                minDiff = Math.min(minDiff, Math.abs(nums1[i] - nums2[maxDiffIndex]));
            }
            BigInteger res = new BigInteger("0");
            for (int dif : diff) {
                res = res.add(new BigInteger(dif + ""));
            }
            res = res.subtract(new BigInteger(maxDiff + "")).add(new BigInteger(minDiff + ""));
            return res.mod(new BigInteger("1000000007")).intValue();
        }
    }

}
