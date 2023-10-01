package leetcode.contest.week365;

import java.util.*;

public class Test100086_有序三元组中的最大值II {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumTripletValue(new int[]{12, 6, 1, 2, 7}));
        System.out.println(new Solution().maximumTripletValue(new int[]{1, 10, 3, 4, 19}));
        System.out.println(new Solution().maximumTripletValue(new int[]{1, 2, 3}));
        System.out.println(new Solution().maximumTripletValue(new int[]{2, 3, 1}));
        System.out.println(new Solution().maximumTripletValue(new int[]{8, 6, 3, 13, 2, 12, 19, 5, 19, 6, 10, 11, 9}));
    }

    static class Solution {
        public long maximumTripletValue(int[] nums) {
            int len = nums.length;
            int[] maxToLeft = new int[len];
            // 左边最大统计
            maxToLeft[0] = nums[0];
            maxToLeft[1] = Math.max(nums[0], nums[1]);
            // 左边差最大统计
            int[] maxDiffToLeft = new int[len];
            maxDiffToLeft[0] = 0;
            maxDiffToLeft[1] = maxToLeft[0] - nums[1];
            for (int i = 2; i < len; i++) {
                maxToLeft[i] = Math.max(maxToLeft[i - 1], nums[i]);
                maxDiffToLeft[i] = Math.max(maxDiffToLeft[i - 1], maxToLeft[i - 1] - nums[i]);
            }
            long ans = 0;
            for (int k = 2; k < len; k++) {
                ans = Math.max(ans, (long) maxDiffToLeft[k - 1] * nums[k]);
            }
            return ans;
        }
    }

}
