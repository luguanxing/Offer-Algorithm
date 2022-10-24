package leetcode.problems;

public class Test0915_分割数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().partitionDisjoint(new int[]{5, 0, 3, 8, 6}));
        System.out.println(new Solution().partitionDisjoint(new int[]{1, 1, 1, 0, 6, 12}));
        System.out.println(new Solution().partitionDisjoint(new int[]{1, 1}));
        System.out.println(new Solution().partitionDisjoint(new int[]{90, 47, 69, 10, 43, 92, 31, 73, 61, 97}));
        System.out.println(new Solution().partitionDisjoint(new int[]{6, 0, 8, 30, 37, 6, 75, 98, 39, 90, 63, 74, 52, 92, 64}));
    }

    static class Solution {
        public int partitionDisjoint(int[] nums) {
            int len = nums.length;
            int[] leftMax = new int[len];
            int[] rightMin = new int[len];
            leftMax[0] = nums[0];
            rightMin[len - 1] = nums[len - 1];
            for (int i = 1; i < len; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
            }
            for (int i = len - 2; i >= 0; i--) {
                rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
            }
            int res = 1;
            for (int i = 1; i < len; i++) {
                if (leftMax[i - 1] <= rightMin[i]) {
                    return i;
                }
            }
            return res;
        }
    }

}
