package leetcode.problems;

public class Test0011_盛最多水的容器 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    static class Solution {
        public int maxArea(int[] height) {
            int len = height.length;
            int l = 0;
            int r = len-1;
            int res = 0;
            while (l < r) {
                int lh = height[l];
                int rh = height[r];
                res = Math.max(res, Math.min(lh, rh) * (r - l));
                if (lh <= rh) {
                    l++;
                } else {
                    r--;
                }
            }
            return res;
        }
    }

    static class Solution_OLD {
        public int maxArea(int[] height) {
            // 滑动窗口找最大值
            int left = 0;
            int right = height.length - 1;
            // 左右高度不同时移动较矮得指针（因为移动高的肯定更小，只有移动矮的可能更大），相同时移动左边
            int max = 0;
            while (left < right) {
                int leftHeight = height[left];
                int rightHeight = height[right];
                int area = Math.min(leftHeight, rightHeight) * (right - left);
                max = Math.max(max, area);
                if (leftHeight <= rightHeight) {
                    left++;
                } else {
                    right--;
                }
            }
            return max;
        }
    }

    static class Solution_暴力 {
        public int maxArea(int[] height) {
            // 暴力循环找最大值
            int max = 0;
            for (int left = 0; left < height.length; left++) {
                for (int right = left + 1; right < height.length; right++) {
                    int currentHeight = Math.min(height[left], height[right]);
                    max = Math.max(max, currentHeight * (right - left));
                }
            }
            return max;
        }
    }

}
