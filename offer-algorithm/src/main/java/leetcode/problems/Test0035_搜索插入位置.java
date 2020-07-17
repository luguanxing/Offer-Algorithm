package leetcode.problems;

public class Test0035_搜索插入位置 {

    public static void main(String[] args) {
        System.out.println(new Solution().searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(new Solution().searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(new Solution().searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(new Solution().searchInsert(new int[]{1, 3, 5, 6}, 0));
    }

    static class Solution {
        public int searchInsert(int[] nums, int target) {
            if (nums == null) {
                return 0;
            }
            // 二分查找定位
            int left = 0;
            int right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int num = nums[mid];
                if (num < target) {
                    left = mid + 1;
                } else if (target < num) {
                    right = mid;
                } else {
                    return mid;
                }
            }
            return left;
        }
    }

}
