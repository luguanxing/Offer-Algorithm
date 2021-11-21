package leetcode.contest.week268;

public class Test5930_两栋颜色不同且距离最远的房子 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxDistance(new int[]{1, 1, 1, 6, 1, 1, 1}));
        System.out.println(new Solution().maxDistance(new int[]{1, 8, 3, 8, 3}));
        System.out.println(new Solution().maxDistance(new int[]{0, 1}));
    }

    static class Solution {
        public int maxDistance(int[] colors) {
            int max = 0;
            for (int i = 0; i < colors.length; i++) {
                for (int j = i + 1; j < colors.length; j++) {
                    if (colors[i] != colors[j]) {
                        max = Math.max(max, j - i);
                    }
                }
            }
            return max;
        }
    }

}
