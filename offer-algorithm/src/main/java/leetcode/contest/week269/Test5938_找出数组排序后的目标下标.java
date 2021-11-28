package leetcode.contest.week269;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test5938_找出数组排序后的目标下标 {

    public static void main(String[] args) {
        System.out.println(new Solution().targetIndices(new int[]{1, 2, 5, 2, 3}, 2));
        System.out.println(new Solution().targetIndices(new int[]{1, 2, 5, 2, 3}, 3));
        System.out.println(new Solution().targetIndices(new int[]{1, 2, 5, 2, 3}, 5));
        System.out.println(new Solution().targetIndices(new int[]{1, 2, 5, 2, 3}, 4));
    }

    static class Solution {
        public List<Integer> targetIndices(int[] nums, int target) {
            Arrays.sort(nums);
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    res.add(i);
                }
            }
            return res;
        }
    }

}
