package leetcode.problems;

public class Test1793_好子数组的最大分数 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumScore(
                new int[]{1, 4, 3, 7, 4, 5}, 3
        ));
        System.out.println(new Solution().maximumScore(
                new int[]{5, 5, 4, 5, 4, 1, 1, 1}, 0
        ));
    }

    static class Solution {
        public int maximumScore(int[] nums, int k) {
            int right = k;
            int left = k;
            int res = 0;
            // 左右扩张，高度缩小
            for (int height = nums[k]; height > 0; height--) {
                while (0 <= left && height <= nums[left]) {
                    left--;
                }
                while (right < nums.length && height <= nums[right]) {
                    right++;
                }
                res = Math.max(res, height * (right - left - 1));
                if (left < 0 && right >= nums.length - 1) {
                    break;
                }
            }
            return res;
        }
    }

}
