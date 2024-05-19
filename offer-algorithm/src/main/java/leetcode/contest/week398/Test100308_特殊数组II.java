package leetcode.contest.week398;

import java.util.Arrays;

public class Test100308_特殊数组II {

    public static void main(String[] args) {
        // nums = [3,4,1,2,6], queries = [[0,4]]
        System.out.println(Arrays.toString(new Solution().isArraySpecial(new int[]{3, 4, 1, 2, 6}, new int[][]{{0, 4}})));
        // nums = [4,3,1,6], queries = [[0,2],[2,3]]
        System.out.println(Arrays.toString(new Solution().isArraySpecial(new int[]{4, 3, 1, 6}, new int[][]{{0, 2}, {2, 3}})));
    }

    static class Solution {
        public boolean[] isArraySpecial(int[] nums, int[][] queries) {
            int len = nums.length;
            int[] prefixSum = new int[len];
            for (int i = 1; i < len; i++) {
                int flag = 0;
                if ((nums[i] % 2 == 1 && nums[i - 1] % 2 == 1) || (nums[i] % 2 == 0 && nums[i - 1] % 2 == 0)) {
                    flag++;
                }
                prefixSum[i] = prefixSum[i - 1] + flag;
            }
            boolean[] res = new boolean[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                int left = query[0];
                int right = query[1];
                if (prefixSum[right] - prefixSum[left] == 0) {
                    res[i] = true;
                } else {
                    res[i] = false;
                }
            }
            return res;
        }
    }

}
