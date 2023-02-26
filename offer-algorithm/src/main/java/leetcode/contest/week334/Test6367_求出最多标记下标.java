package leetcode.contest.week334;

import java.util.Arrays;

public class Test6367_求出最多标记下标 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxNumOfMarkedIndices(new int[]{3, 5, 2, 4}));
        System.out.println(new Solution().maxNumOfMarkedIndices(new int[]{9, 2, 5, 4}));
        System.out.println(new Solution().maxNumOfMarkedIndices(new int[]{7, 6, 8}));
    }

    static class Solution {
        public int maxNumOfMarkedIndices(int[] nums) {
            // 不断使用二分尝试出最大的k对
            Arrays.sort(nums);
            int left = 0, right = (nums.length / 2) + 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (isOk(nums, mid)) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return 2 * (left - 1);

        }

        // 判断k对是否合适的标准是：排序后前K对和后k对是否满足两倍关系
        private boolean isOk(int[] nums, int k) {
            for (int i = 0; i < k; i++) {
                if (nums[i] * 2 > nums[nums.length - k + i]) {
                    return false;
                }
            }
            return true;
        }
    }

}
