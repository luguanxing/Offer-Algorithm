package leetcode.contest.week239;

public class Test5746_到目标元素的最小距离 {

    public static void main(String[] args) {
        System.out.println(new Solution().getMinDistance(
                new int[]{1, 2, 3, 4, 5}, 5, 3
        ));
        System.out.println(new Solution().getMinDistance(
                new int[]{1}, 1, 0
        ));
        System.out.println(new Solution().getMinDistance(
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 1, 0
        ));
    }

    static class Solution {
        public int getMinDistance(int[] nums, int target, int start) {
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    res = Math.min(res, Math.abs(start - i));
                }
            }
            return res;
        }
    }

}
