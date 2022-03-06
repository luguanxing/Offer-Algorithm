package offer;

public class Test2104_子数组范围和 {

    public static void main(String[] args) {
        System.out.println(new Solution().subArrayRanges(new int[]{1, 2, 3}));
        System.out.println(new Solution().subArrayRanges(new int[]{1, 3, 3}));
        System.out.println(new Solution().subArrayRanges(new int[]{4, -2, -3, 4, 1}));
    }

    static class Solution {
        public long subArrayRanges(int[] nums) {
            int len = nums.length;
            int[][] maxDp = new int[len][len];
            int[][] minDp = new int[len][len];
            for (int i = 0; i < len; i++) {
                int max = nums[i];
                int min = nums[i];
                for (int j = i; j < len; j++) {
                    max = Math.max(max, nums[j]);
                    min = Math.min(min, nums[j]);
                    maxDp[i][j] = max;
                    minDp[i][j] = min;
                }
            }
            long res = 0;
            for (int i = 0; i < len; i++) {
                for (int j = i; j < len; j++) {
                    res += maxDp[i][j] - minDp[i][j];
                }
            }
            return res;
        }
    }

}
