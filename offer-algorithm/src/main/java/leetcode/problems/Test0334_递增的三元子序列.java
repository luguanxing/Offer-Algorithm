package leetcode.problems;

public class Test0334_递增的三元子序列 {

    public static void main(String[] args) {
        System.out.println(new Solution().increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Solution().increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        System.out.println(new Solution().increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
    }

    static class Solution {
        public boolean increasingTriplet(int[] nums) {
            // 计算出左边最小和右边最单
            int[] leftMin = new int[nums.length];
            int[] rightMax = new int[nums.length];
            leftMin[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
            }
            rightMax[nums.length - 1] = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
            }
            // 判断是否存在递增三元组
            for (int i = 1; i < nums.length - 1; i++) {
                if (leftMin[i - 1] < nums[i] && nums[i] < rightMax[i + 1]) {
                    return true;
                }
            }
            return false;
        }
    }

}
