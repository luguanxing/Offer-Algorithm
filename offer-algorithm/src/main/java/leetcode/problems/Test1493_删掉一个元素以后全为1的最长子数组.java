package leetcode.problems;

public class Test1493_删掉一个元素以后全为1的最长子数组 {

    public static void main(String[] args) {
        // nums = [1,1,0,1]
        System.out.println(new Solution().longestSubarray(new int[]{1, 1, 0, 1}));
        // nums = [0,1,1,1,0,1,1,0,1]
        System.out.println(new Solution().longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
        // nums = [1,1,1]
        System.out.println(new Solution().longestSubarray(new int[]{1, 1, 1}));
        // nums = [0,1,0]
        System.out.println(new Solution().longestSubarray(new int[]{0, 1, 0}));
    }

    static class Solution {
        public int longestSubarray(int[] nums) {
            // 计算从左到右和从右到左的连续1的长度
            int len = nums.length;
            int[] left = new int[len];
            int[] right = new int[len];
            left[0] = nums[0];
            for (int i = 1; i < len; i++) {
                if (nums[i] == 1) {
                    left[i] = left[i - 1] + 1;
                }
            }
            right[len - 1] = nums[len - 1];
            for (int i = len - 2; i >= 0; i--) {
                if (nums[i] == 1) {
                    right[i] = right[i + 1] + 1;
                }
            }
            // 遍历数组，计算删除每个数后，左右两边连续1的长度之和
            int res = 0;
            for (int i = 0; i < len; i++) {
                int leftCount = i > 0 ? left[i - 1] : 0;
                int rightCount = i < len - 1 ? right[i + 1] :0;
                res = Math.max(res, leftCount + rightCount);
            }
            return res;
        }
    }

}
