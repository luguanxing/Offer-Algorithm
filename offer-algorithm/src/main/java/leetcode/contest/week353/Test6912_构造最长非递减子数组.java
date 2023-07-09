package leetcode.contest.week353;

public class Test6912_构造最长非递减子数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxNonDecreasingLength(
                new int[]{2, 3, 1},
                new int[]{1, 2, 1}
        ));
        System.out.println(new Solution().maxNonDecreasingLength(
                new int[]{1, 3, 2, 1},
                new int[]{2, 2, 3, 4}
        ));
        System.out.println(new Solution().maxNonDecreasingLength(
                new int[]{1, 1},
                new int[]{2, 2}
        ));
        System.out.println(new Solution().maxNonDecreasingLength(
                new int[]{1, 8},
                new int[]{10, 1}
        ));
        System.out.println(new Solution().maxNonDecreasingLength(
                new int[]{11, 7, 7, 9},
                new int[]{19, 19, 1, 7}
        ));
    }

    static class Solution {
        public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
            int n = nums1.length;
            // dp11表示在i位置选择nums1[i]，在i-1位置也选择了nums1[i-1]
            int dp11 = 1, dp21 = 1;
            int res = 1;
            for (int i = 1; i < n; ++i) {
                int t11 = nums1[i] >= nums1[i - 1] ? dp11 + 1 : 1;
                int t12 = nums1[i] >= nums2[i - 1] ? dp21 + 1 : 1;
                int t21 = nums2[i] >= nums1[i - 1] ? dp11 + 1 : 1;
                int t22 = nums2[i] >= nums2[i - 1] ? dp21 + 1 : 1;
                dp11 = Math.max(t11, t12);
                dp21 = Math.max(t21, t22);
                res = Math.max(Math.max(dp11, dp21), res);
            }
            return res;
        }
    }

}
