package leetcode.problems;

import java.util.Arrays;

public class Test6418_有相同颜色的相邻元素数目 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().colorTheArray(4, new int[][]{{0, 2}, {1, 2}, {3, 1}, {1, 1}, {2, 1}})));
        System.out.println(Arrays.toString(new Solution().colorTheArray(1, new int[][]{{0, 100000}})));
    }

    static class Solution {
        public int[] colorTheArray(int n, int[][] queries) {
            int len = queries.length;
            int[] nums = new int[n];
            int[] res = new int[len];
            int count = 0;
            for (int i = 0; i < len; i++) {
                int idx = queries[i][0];
                int color = queries[i][1];
                // 更新老颜色
                if (idx > 0 && nums[idx - 1] != 0 && nums[idx - 1] == nums[idx]) {
                    count--;
                }
                if (idx + 1 < n && nums[idx + 1] != 0 && nums[idx + 1] == nums[idx]) {
                    count--;
                }
                // 更新新颜色
                nums[idx] = color;
                if (idx > 0 && nums[idx - 1] != 0 && nums[idx - 1] == nums[idx]) {
                    count++;
                }
                if (idx + 1 < n && nums[idx + 1] != 0 && nums[idx + 1] == nums[idx]) {
                    count++;
                }
                res[i] = count;
            }
            return res;
        }
    }

}
