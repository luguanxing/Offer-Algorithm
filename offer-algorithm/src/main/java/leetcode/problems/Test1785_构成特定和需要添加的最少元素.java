package leetcode.problems;

import java.util.Arrays;

public class Test1785_构成特定和需要添加的最少元素 {

    public static void main(String[] args) {
        System.out.println(new Solution().minElements(
                new int[]{1, -1, 1},
                3, -4
        ));
        System.out.println(new Solution().minElements(
                new int[]{1, -10, 9, 1},
                100, 0
        ));
    }

    static class Solution {
        public int minElements(int[] nums, int limit, int goal) {
            long sum = 0;
            for (int num : nums) {
                sum += num;
            }
            long diff = Math.abs(sum - goal);
            return (int) ((diff + limit - 1) / limit);
        }
    }

}
