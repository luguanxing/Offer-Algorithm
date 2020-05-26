package leetcode.problems;

public class Test0042_接雨水 {

    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(new Solution().trap(new int[]{}));
    }

    static class Solution {
        public int trap(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            }
            int sum = 0;
            // 保存左边最大和右边最大状态
            int[] leftMaxs = new int[height.length];
            int leftMax = height[0];
            for (int i = 1; i < height.length; i++) {
                leftMax = Math.max(leftMax, height[i]);
                leftMaxs[i] = leftMax;
            }
            int[] rightMaxs = new int[height.length];
            int rightMax = height[height.length - 1];
            for (int i = height.length - 1; i >= 0; i--) {
                rightMax = Math.max(rightMax, height[i]);
                rightMaxs[i] = rightMax;
            }
            // 从第一个柱子往右找，只有当前柱子比左右柱子都矮时才可以装水
            for (int i = 0; i < height.length; i++) {
                int h = height[i];
                if (h < leftMaxs[i] && h < rightMaxs[i]) {
                    sum += Math.min(leftMaxs[i], rightMaxs[i]) - h;
                }
            }
            return sum;
        }
    }

    static class Solution_ON2 {
        public int trap(int[] height) {
            int maxLeft = 0;
            int index = 0;
            int sum = 0;
            // 先找第一个柱子
            for (int i = 0; i < height.length; i++) {
                if (height[i] != 0) {
                    maxLeft = height[i];
                    index = i;
                    break;
                }
            }
            // 从第一个柱子往右找，只有当前柱子比左右柱子都矮时才可以装水
            for (int i = index + 1; i < height.length; i++) {
                int h = height[i];
                if (h > maxLeft) {
                    maxLeft = h;
                } else {
                    int maxRight = 0;
                    for (int j = i + 1; j < height.length; j++) {
                        maxRight = Math.max(maxRight, height[j]);
                    }
                    if (h < maxLeft && h < maxRight) {
                        sum += Math.min(maxLeft, maxRight) - h;
                    }
                }
            }
            return sum;
        }
    }

}
