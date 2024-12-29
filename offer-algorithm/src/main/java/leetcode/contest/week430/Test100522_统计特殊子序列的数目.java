package leetcode.contest.week430;

import java.util.*;

public class Test100522_统计特殊子序列的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfSubsequences(new int[]{1, 2, 3, 4, 3, 6, 1}));
        System.out.println(new Solution().numberOfSubsequences(new int[]{3, 4, 3, 4, 3, 4, 3, 4}));
    }

    static class Solution {
        public long numberOfSubsequences(int[] nums) {
            int len = nums.length;
            long res = 0;
            // 暴力美剧
            for (int p = 0; p < len; p++) {
                for (int q = p + 2; q < len; q++) {
                    for (int r = q + 2; r < len; r++) {
                        for (int s = r + 2; s < len; s++) {
                            if (nums[p] * nums[r] == nums[q] * nums[s]) {
                                res++;
                            }
                        }
                    }
                }
            }
            return res;
        }
    }

}
