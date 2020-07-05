package leetcode.contest.week196;

public class Test5453_所有蚂蚁掉下来前的最后一刻 {

    public static void main(String[] args) {
        System.out.println(new Solution().getLastMoment(4, new int[]{4, 3}, new int[]{0, 1}));
        System.out.println(new Solution().getLastMoment(7, new int[]{}, new int[]{0, 1, 2, 3, 4, 5, 6, 7}));
        System.out.println(new Solution().getLastMoment(7, new int[]{0, 1, 2, 3, 4, 5, 6, 7}, new int[]{}));
        System.out.println(new Solution().getLastMoment(9, new int[]{5}, new int[]{4}));
        System.out.println(new Solution().getLastMoment(6, new int[]{6}, new int[]{4}));
    }

    static class Solution {
        public int getLastMoment(int n, int[] left, int[] right) {
            // 碰撞相当于直接穿过，所以只需找到边界最远的距离
            int max = 0;
            for (int i = 0; i < right.length; i++) {
                max = Math.max(max, n - right[i]);
            }
            for (int i = 0; i < left.length; i++) {
                max = Math.max(max, left[i]);
            }
            return max;
        }
    }

}
