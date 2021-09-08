package leetcode.problems;

public class Test0704_二分查找 {

    public static void main(String[] args) {
        System.out.println(new Solution().search(
                new int[]{-1, 0, 3, 5, 9, 12}, 9
        ));
        System.out.println(new Solution().search(
                new int[]{-1, 0, 3, 5, 9, 12}, 2
        ));
    }

    static class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }

}
