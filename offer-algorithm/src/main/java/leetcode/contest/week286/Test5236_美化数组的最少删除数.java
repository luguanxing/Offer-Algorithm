package leetcode.contest.week286;

import java.util.Stack;

public class Test5236_美化数组的最少删除数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minDeletion(new int[]{1, 1, 2, 3, 5}));
        System.out.println(new Solution().minDeletion(new int[]{1, 1, 2, 2, 3, 3}));
    }

    static class Solution {
        public int minDeletion(int[] nums) {
            Stack<Integer> stack = new Stack<>();
            stack.add(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];
                int index = stack.size() - 1;
                if (index % 2 == 0) {
                    int lastNum = stack.peek();
                    if (num == lastNum) {
                        continue;
                    }
                }
                stack.add(num);
            }
            if (stack.size() % 2 == 1) {
                stack.pop();
            }
            return nums.length - stack.size();
        }
    }

}
