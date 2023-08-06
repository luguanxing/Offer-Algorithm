package leetcode.contest.week357;

import java.util.*;

public class Test6953_判断是否能拆分数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().canSplitArray(
                Arrays.asList(2, 2, 1), 4
        ));
        System.out.println(new Solution().canSplitArray(
                Arrays.asList(2, 1, 3), 5
        ));
        System.out.println(new Solution().canSplitArray(
                Arrays.asList(2, 3, 3, 2, 3), 6
        ));
        System.out.println(new Solution().canSplitArray(
                Arrays.asList(1), 1
        ));
        System.out.println(new Solution().canSplitArray(
                Arrays.asList(1, 1), 3
        ));
    }

    static class Solution {
        public boolean canSplitArray(List<Integer> nums, int m) {
            if (nums.size() == 1 || nums.size() == 2) {
                return true;
            }
            for (int i = 0; i < nums.size() - 1; i++) {
                if (nums.get(i) + nums.get(i + 1) >= m) {
                    return true;
                }
            }
            return false;
        }
    }

}
