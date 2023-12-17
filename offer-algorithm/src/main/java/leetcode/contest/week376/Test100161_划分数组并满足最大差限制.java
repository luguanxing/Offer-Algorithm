package leetcode.contest.week376;

import java.util.*;

public class Test100161_划分数组并满足最大差限制 {

    public static void main(String[] args) {
        // nums = [1,3,4,8,7,9,3,5,1], k = 2
        System.out.println(Arrays.deepToString(new Solution().divideArray(new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1}, 2)));
        // nums = [1,3,3,2,7,3], k = 3
        System.out.println(Arrays.deepToString(new Solution().divideArray(new int[]{1, 3, 3, 2, 7, 3}, 3)));
    }

    static class Solution {
        public int[][] divideArray(int[] nums, int k) {
            int len = nums.length;
            if (len % 3 != 0) {
                return new int[0][0];
            }
            Arrays.sort(nums);
            int[][] result = new int[len / 3][3];
            int resultIndex = 0;
            for (int i = 0; i < len; i += 3) {
                if (nums[i + 2] - nums[i] > k) {
                    return new int[0][0];
                }
                result[resultIndex++] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
            }
            return result;
        }
    }

}
