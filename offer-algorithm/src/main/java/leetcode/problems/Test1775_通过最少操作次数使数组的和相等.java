package leetcode.problems;

import java.util.Arrays;

public class Test1775_通过最少操作次数使数组的和相等 {

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(
                new int[]{1, 2, 3, 4, 5, 6},
                new int[]{1, 1, 2, 2, 2, 2}
        ));
        System.out.println(new Solution().minOperations(
                new int[]{1, 1, 1, 1, 1, 1, 1},
                new int[]{6}
        ));
        System.out.println(new Solution().minOperations(
                new int[]{6, 6},
                new int[]{1}
        ));
        System.out.println(new Solution().minOperations(
                new int[]{5, 6, 4, 3, 1, 2},
                new int[]{6, 3, 3, 1, 4, 5, 3, 4, 1, 3, 4}
        ));
    }

    static class Solution {
        public int minOperations(int[] nums1, int[] nums2) {
            if (6 * nums1.length < nums2.length || nums1.length > 6 * nums2.length) {
                return -1;
            }
            int sum1 = Arrays.stream(nums1).sum();
            int sum2 = Arrays.stream(nums2).sum();
            // 使sum1<=sum2，如不满足则交换
            if (sum1 > sum2) {
                int[] nums = nums1.clone();
                nums1 = nums2;
                nums2 = nums;
            }
            // 计算diff和可用于抵消的数组allocate
            int diff = Arrays.stream(nums2).sum() - Arrays.stream(nums1).sum();
            int[] allocate = new int[6];
            for (int num : nums1) {
                // 从num最多变成6，可用于抵消6 - num
                allocate[6 - num]++;
            }
            for (int num : nums2) {
                // 从num最少变成1，可用于抵消num - 1
                allocate[num - 1]++;
            }
            // 从大到小使用allocate抵消diff
            int res = 0;
            for (int i = 5; i >= 1; i--) {
                if (i * allocate[i] >= diff) {
                    res += (diff + i - 1) / i;
                    return res;
                }
                diff -= i * allocate[i];
                res += allocate[i];
            }
            return res;
        }
    }

}
