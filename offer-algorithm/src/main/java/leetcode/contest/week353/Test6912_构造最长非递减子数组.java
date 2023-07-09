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
            // dp11：在nums3的i位置选择nums1[i]，并且在i-1位置也选择了nums1[i-1]时的最大非递减子数组长度
            // dp12：在nums3的i位置选择nums1[i]，但在i-1位置选择了nums2[i-1]时的最大非递减子数组长度
            // dp21：在nums3的i位置选择nums2[i]，并且在i-1位置也选择了nums1[i-1]时的最大非递减子数组长度
            // dp22：在nums3的i位置选择nums2[i]，但在i-1位置选择了nums2[i-1]时的最大非递减子数组长度
            int dp11 = 1, dp21 = 1;
            int ans = 1;
            for (int i = 1; i < n; ++i) {
                // 如果nums1[i]大于或等于nums1[i-1]，那么dp11可以增加1（即tmp11=dp11+1），否则nums1[i]单独成为一个新的非递减子数组，所以tmp11=1
                // 如果nums1[i]大于或等于nums2[i-1]，那么dp12可以增加1（即tmp12=dp21+1），否则nums1[i]单独成为一个新的非递减子数组，所以tmp12=1
                // 如果nums2[i]大于或等于nums1[i-1]，那么dp21可以增加1（即tmp21=dp11+1），否则nums2[i]单独成为一个新的非递减子数组，所以tmp21=1
                // 如果nums2[i]大于或等于nums2[i-1]，那么dp22可以增加1（即tmp22=dp21+1），否则nums2[i]单独成为一个新的非递减子数组，所以tmp22=1
                int t11 = nums1[i] >= nums1[i - 1] ? dp11 + 1 : 1;
                int t12 = nums1[i] >= nums2[i - 1] ? dp21 + 1 : 1;
                int t21 = nums2[i] >= nums1[i - 1] ? dp11 + 1 : 1;
                int t22 = nums2[i] >= nums2[i - 1] ? dp21 + 1 : 1;
                dp11 = Math.max(t11, t12);
                dp21 = Math.max(t21, t22);
                ans = Math.max(Math.max(dp11, dp21), ans);
            }
            return ans;
        }
    }
}

