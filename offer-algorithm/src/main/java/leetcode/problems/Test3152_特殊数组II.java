package leetcode.problems;

import java.util.Arrays;

public class Test3152_特殊数组II {

    public static void main(String[] args) {
        // nums = [3,4,1,2,6], queries = [[0,4]]
        System.out.println(Arrays.toString(new Solution().isArraySpecial(new int[]{3, 4, 1, 2, 6}, new int[][]{{0, 4}})));
        // nums = [4,3,1,6], queries = [[0,2],[2,3]]
        System.out.println(Arrays.toString(new Solution().isArraySpecial(new int[]{4, 3, 1, 6}, new int[][]{{0, 2}, {2, 3}})));
    }

    static class Solution {
        public boolean[] isArraySpecial(int[] nums, int[][] queries) {
            // 统计每个位置连续奇偶的个数，存储在类似前缀和的数组中
            int len = nums.length;
            int[] available = new int[len];
            available[0] = 1;
            for (int i = 1; i < len; i++) {
                available[i] = (nums[i] % 2 == nums[i - 1] % 2) ? 1 : available[i - 1] + 1;
            }
            // 处理查询，使用前缀和判断
            int qLen = queries.length;
            boolean[] res = new boolean[qLen];
            for (int i = 0; i < qLen; i++) {
                int[] query = queries[i];
                int left = query[0];
                int right = query[1];
                if (right - left == available[right] - available[left]) {
                    res[i] = true;
                }
            }
            return res;
        }
    }

}
