package leetcode.interview;

public class Test17_21_直方图的水量 {

    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    static class Solution {
        public int trap(int[] height) {
            // 标记左边和右边最高点
            int len = height.length;
            int[] left = new int[len];
            int[] right = new int[len];
            int leftMax = 0;
            int rightMax = 0;
            for (int i = 0; i < len; i++) {
                left[i] = leftMax;
                leftMax = Math.max(leftMax, height[i]);
            }
            for (int i = len - 1; i >= 0; i--) {
                right[i] = rightMax;
                rightMax = Math.max(rightMax, height[i]);
            }
            // 判断每个点的存水
            int sum = 0;
            for (int i = 1; i < len - 1; i++) {
                int currenHeight = height[i];
                int waterHeight = Math.min(left[i], right[i]);
                int canFilled = waterHeight - currenHeight;
                if (canFilled > 0) {
                    sum += canFilled;
                }
            }
            return sum;
        }
    }

}
