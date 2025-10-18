package leetcode.problems;

import java.util.*;

public class Test3397_执行操作后不同元素的最大数量 {

    public static void main(String[] args) {
        // nums = [1,2,2,3,3,4], k = 2
        System.out.println(new Solution().maxDistinctElements(new int[]{1, 2, 2, 3, 3, 4}, 2));
        // nums = [4,4,4,4], k = 1
        System.out.println(new Solution().maxDistinctElements(new int[]{4, 4, 4, 4}, 1));
    }

    static class Solution {
        public int maxDistinctElements(int[] nums, int k) {
            Arrays.sort(nums);
            int res = 0;
            // 用pre记录上一个放置的位置，保证其递增
            int pre = Integer.MIN_VALUE;
            // 每个数往尽可能往左边靠，最多向左移动k位，但至少要大于pre => max(num - k, pre + 1)
            // 同时不能超过最右边界限，因为最多向右移动k位 => min(max(num - k, pre + 1), num + k)
            for (int num : nums) {
                int pos = Math.min(Math.max(num - k, pre + 1), num + k);
                // 判断是否仍然满足在pre的右边
                if (pos > pre) {
                    res++;
                    pre = pos;
                }
            }
            return res;
        }
    }

}
