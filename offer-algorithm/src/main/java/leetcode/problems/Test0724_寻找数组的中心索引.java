package leetcode.problems;

import java.util.Arrays;

public class Test0724_寻找数组的中心索引 {

    public static void main(String[] args) {
        System.out.println(new Solution().pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(new Solution().pivotIndex(new int[]{-1, -1, -1, 0, 1, 1}));
        System.out.println(new Solution().pivotIndex(new int[]{1, -1, 0}));
        System.out.println(new Solution().pivotIndex(new int[]{1, -1, -1, 1, 0, 0}));
        System.out.println(new Solution().pivotIndex(new int[]{1, -1, -1, -1, 0, 0}));
        System.out.println(new Solution().pivotIndex(new int[]{-1, -1, -1, 1, 1, 1}));
        System.out.println(new Solution().pivotIndex(new int[]{-1, -1, 0, 1, 1, -1}));
        System.out.println(new Solution().pivotIndex(new int[]{0, 1, -1}));
    }

    static class Solution {
        public int pivotIndex(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            int leftSum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (leftSum * 2 == sum - nums[i]) {
                    return i;
                }
                leftSum += nums[i];
            }
            return -1;
        }
    }

    static class Solution_前后缀和 {
        public int pivotIndex(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            // 构造前缀和与后缀和
            int len = nums.length;
            int[] leftSum = new int[len];
            int[] rightSum = new int[len];
            leftSum[0] = nums[0];
            for (int i = 1; i < len; i++) {
                leftSum[i] = leftSum[i - 1] + nums[i];
            }
            rightSum[len - 1] = nums[len - 1];
            for (int i = len - 2; i >= 0; i--) {
                rightSum[i] = rightSum[i + 1] + nums[i];
            }
            // 判断前后和，注意左右两个点顺序并且需要单独判断
            if (len > 1 && rightSum[1] == 0) {
                return 0;
            }
            for (int i = 1; i < len - 1; i++) {
                if (leftSum[i - 1] == rightSum[i + 1]) {
                    return i;
                }
            }
            if (len > 1 && leftSum[len - 2] == 0) {
                return len - 1;
            }
            return -1;
        }
    }

}
