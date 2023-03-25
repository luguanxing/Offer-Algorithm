package leetcode.problems;

import java.util.Arrays;

public class Test1574_删除最短的子数组使剩余数组有序 {

    public static void main(String[] args) {
        System.out.println(new Solution().findLengthOfShortestSubarray(new int[]{1, 2, 3, 10, 4, 2, 3, 5}));
        System.out.println(new Solution().findLengthOfShortestSubarray(new int[]{5, 4, 3, 2, 1}));
        System.out.println(new Solution().findLengthOfShortestSubarray(new int[]{1, 2, 3}));
        System.out.println(new Solution().findLengthOfShortestSubarray(new int[]{1}));
        System.out.println(new Solution().findLengthOfShortestSubarray(new int[]{2, 2, 2, 1, 1, 1}));
        System.out.println(new Solution().findLengthOfShortestSubarray(new int[]{1, 2, 2, 2, 2, 2, 3, 1, 7, 5, 1, 2, 2, 2, 2, 2, 2, 5, 6}));
    }

    static class Solution {
        public int findLengthOfShortestSubarray(int[] arr) {
            int len = arr.length;
            // 先计算左边递增和右边递增的最长串
            int left = 0;
            int right = len - 1;
            while (left + 1 < len && arr[left] <= arr[left + 1]) {
                left++;
            }
            while (right - 1 >= 0 && arr[right - 1] <= arr[right]) {
                right--;
            }
            if (left >= right) {
                return 0;
            }
            // 取出砍去左边或右边的最小结果
            int res = Math.min(len - left - 1, right);
            // 取出砍掉中间的最短结果，需要枚举[0，left]中在右侧[right,len]的位置
            for (int i = 0; i <= left; i++) {
                // 枚举左侧i，使用二分查找右侧j左边界的位置
                int j = leftBound(arr, right, len, arr[i]);
                res = Math.min(res, j - i - 1);
            }
            return res;
        }

        int leftBound(int[] nums, int left, int right, int target) {
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }

}
