package leetcode.contest.week201;

import java.util.*;

public class Test5471_和为目标值的最大数目不重叠非空子数组数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxNonOverlapping(new int[]{1, 1, 1, 1, 1}, 2));
        System.out.println(new Solution().maxNonOverlapping(new int[]{-1, 3, 5, 1, 4, 2, -9}, 6));
        System.out.println(new Solution().maxNonOverlapping(new int[]{-2, 6, 6, 3, 5, 4, 1, 2, 8}, 10));
        System.out.println(new Solution().maxNonOverlapping(new int[]{0, 0, 0}, 0));
        System.out.println(new Solution().maxNonOverlapping(new int[]{-5, 5, -4, 5, 4}, 5));
        System.out.println(new Solution().maxNonOverlapping(new int[]{2, 2, 3, 3, -3, -1, 2, -3}, 4));
    }

    static class Solution {
        public int maxNonOverlapping(int[] nums, int target) {
            // 对每一段总和都用set保存下来，判断之前是否有某段+target=当前段
            Set<Integer> set = new HashSet<>();
            int curSum = 0;
            int res = 0;
            set.add(0);
            for (int num : nums) {
                curSum += num;
                if (set.contains(curSum - target)) {
                    // 如果当前段和减去之前某一段和为target，则符合条件，即当前curSum=上次curSum+target
                    set.clear();
                    set.add(0);
                    curSum = 0;
                    res++;
                } else {
                    // 还未满足条件，保留当前段的和
                    set.add(curSum);
                }
            }
            return res;
        }
    }

}
