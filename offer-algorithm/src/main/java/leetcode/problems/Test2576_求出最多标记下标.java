package leetcode.problems;

import java.util.Arrays;

public class Test2576_求出最多标记下标 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxNumOfMarkedIndices(new int[]{3, 5, 2, 4}));
        System.out.println(new Solution().maxNumOfMarkedIndices(new int[]{9, 2, 5, 4}));
        System.out.println(new Solution().maxNumOfMarkedIndices(new int[]{7, 6, 8}));
        System.out.println(new Solution().maxNumOfMarkedIndices(new int[]{1, 78, 27, 48, 14, 86, 79, 68, 77, 20, 57, 21, 18, 67, 5, 51, 70, 85, 47, 56, 22, 79, 41, 8, 39, 81, 59, 74, 14, 45, 49, 15, 10, 28, 16, 77, 22, 65, 8, 36, 79, 94, 44, 80, 72, 8, 96, 78, 39, 92, 69, 55, 9, 44, 26, 76, 40, 77, 16, 69, 40, 64, 12, 48, 66, 7, 59, 10}));
        System.out.println(new Solution().maxNumOfMarkedIndices(new int[]{42, 83, 48, 10, 24, 55, 9, 100, 10, 17, 17, 99, 51, 32, 16, 98, 99, 31, 28, 68, 71, 14, 64, 29, 15, 40}));
        System.out.println(new Solution().maxNumOfMarkedIndices(new int[]{57, 40, 57, 51, 90, 51, 68, 100, 24, 39, 11, 85, 2, 22, 67, 29, 74, 82, 10, 96, 14, 35, 25, 76, 26, 54, 29, 44, 63, 49, 73, 50, 95, 89, 43, 62, 24, 88, 88, 36, 6, 16, 14, 2, 42, 42, 60, 25, 4, 58, 23, 22, 27, 26, 3, 79, 64, 20, 92}));
        System.out.println(new Solution().maxNumOfMarkedIndices(new int[]{66, 53, 92, 87, 23, 29, 53, 83, 63, 63, 25, 25, 72, 47, 34, 24, 63, 8, 43, 100, 80, 17, 72, 69, 7, 7, 32, 80, 8, 58, 70, 81, 79, 67, 66, 24, 64, 66, 9, 67, 33, 11, 62, 86, 5, 84, 78, 85, 69, 3, 92, 14, 67, 90, 31, 40, 54, 63, 99, 88, 28, 100, 5, 72, 89, 60, 90, 71, 97, 16, 7, 60, 6, 57, 73, 84, 17, 8, 77, 60, 7, 74, 74, 24, 52, 43, 94, 48, 9, 99, 84, 89, 96, 40, 15, 29, 80, 19}));
        System.out.println(new Solution().maxNumOfMarkedIndices(new int[]{72, 97, 60, 79, 68, 25, 63, 82, 88, 60, 37, 60, 44, 14, 62, 36, 52, 73, 26, 98, 86, 50, 74, 68, 53, 80, 90, 60, 78, 56, 53, 84, 2}));
    }

    static class Solution {
        public int maxNumOfMarkedIndices(int[] nums) {
            // 不断用二分试出最大的k对
            int len = nums.length;
            Arrays.sort(nums);
            int left = 0;
            int right = len / 2 + 1;
            // 寻找右边界
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (canFindKPairs(nums, mid)) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left > 0 ? 2 * (left - 1) : 0;
        }

        private boolean canFindKPairs(int[] nums, int k) {
            // 只需比较最左边k对和最右边k对
            for (int i = 0; i < k; i++) {
                if (nums[i] * 2 > nums[nums.length - k + i]) {
                    return false;
                }
            }
            return true;
        }
    }

    static class Solution_重复标记 {
        public int maxNumOfMarkedIndices(int[] nums) {
            int len = nums.length;
            // 只统计下标，与顺序无关，所以先排序
            Arrays.sort(nums);
            // 遍历i + 二分找2*nums[i]
            int res = 0;
            for (int i = 0; i < len; i++) {
                int target = 2 * nums[i];
                int left = i + 1, right = len - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] >= target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                res += len - left;
            }
            return res;
        }
    }

}
