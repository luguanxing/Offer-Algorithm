package leetcode.problems;

import java.util.Arrays;

public class Test2966_划分数组并满足最大差限制 {

    public static void main(String[] args) {
        // nums = [1,3,4,8,7,9,3,5,1], k = 2
        System.out.println(Arrays.deepToString(new Solution().divideArray(new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1}, 2)));
        // nums = [2,4,2,2,5,2], k = 2
        System.out.println(Arrays.deepToString(new Solution().divideArray(new int[]{2, 4, 2, 2, 5, 2}, 2)));
        // nums = [4,2,9,8,2,12,7,12,10,5,8,5,5,7,9,2,5,11], k = 14
        System.out.println(Arrays.deepToString(new Solution().divideArray(new int[]{4, 2, 9, 8, 2, 12, 7, 12, 10, 5, 8, 5, 5, 7, 9, 2, 5, 11}, 14)));
    }

    static class Solution {
        public int[][] divideArray(int[] nums, int k) {
            int len = nums.length;
            Arrays.sort(nums);
            // 贪心，如果最近的一组最大差大于k，那其它组合更加不可能满足条件
            int[][] res = new int[len / 3][3];
            for (int i = 0; i < len / 3; i++) {
                if (nums[i * 3 + 2] - nums[i * 3] > k) {
                    return new int[][]{};
                }
                res[i][0] = nums[i * 3];
                res[i][1] = nums[i * 3 + 1];
                res[i][2] = nums[i * 3 + 2];
            }
            return res;
        }
    }

}
