package leetcode.contest.week271;

public class Test5953_子数组范围和 {

    public static void main(String[] args) {
        System.out.println(new Solution().subArrayRanges(new int[]{1, 2, 3}));
        System.out.println(new Solution().subArrayRanges(new int[]{1, 3, 3}));
        System.out.println(new Solution().subArrayRanges(new int[]{4, -2, -3, 4, 1}));
    }

    static class Solution {
        public long subArrayRanges(int[] nums) {
            int len = nums.length;
            // 计算max[y][x]或min[y][x]最大最小值
            int[][] max = new int[len][len];
            int[][] min = new int[len][len];
            for (int i = 0; i < len; i++) {
                max[i][i] = nums[i];
                min[i][i] = nums[i];
            }
            for (int y = 0; y < len; y++) {
                for (int x = y + 1; x < len; x++) {
                    max[y][x] = Math.max(max[y][x - 1], nums[x]);
                    min[y][x] = Math.min(min[y][x - 1], nums[x]);
                }
            }
            // 计算结果
            long res = 0;
            for (int y = 0; y < len; y++) {
                for (int x = y + 1; x < len; x++) {
                    res += max[y][x] - min[y][x];
                }
            }
            return res;
        }
    }

}
